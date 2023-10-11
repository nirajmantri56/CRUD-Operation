package com.deal.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.deal.Entity.Item;

@Repository
public class ItemRepository {
    
    private final List<Item> items = new ArrayList<>();
    private int nextId = 1;

    public Item addItem(Item item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    public Optional<Item> getItemById(int id) {
        return items.stream().filter(item -> item.getId() == id).findFirst();
    }
}
