package com.deal.Response;

import com.deal.Entity.Item;

public class SuccessResponse {
    private String message;
    private Item item;

    public SuccessResponse(String message, Item item) {
        this.message = message;
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
