package com.deal.Controller;

import com.deal.Entity.Item;
import com.deal.Repository.ItemRepository;
import com.deal.Response.ErrorResponse;
import com.deal.Response.SuccessResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {

    
    private final ItemRepository itemRepository;
    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@Valid @RequestBody Item item, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Item addedItem = itemRepository.addItem(item);

        SuccessResponse successResponse = new SuccessResponse("Item successfully added", addedItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {
        Optional<Item> item = itemRepository.getItemById(id);

        if (item.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("Item with ID " + id + " not found", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(item.get());
    }
}
