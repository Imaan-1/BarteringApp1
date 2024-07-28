package com.example.barteringapp;

public class ProductsHelper {
    String location, itemneeded,itemtobarter;

    public ProductsHelper(String location, String itemneeded, String itemtobarter) {

        this.location = location;
        this.itemneeded = itemneeded;
        this.itemtobarter = itemtobarter;
    }

    public String getItemneeded() {
        return itemneeded;
    }
    public String getItemtobarter() {
        return itemtobarter;
    }
    public String getLocation() {
        return location;
    }
}
