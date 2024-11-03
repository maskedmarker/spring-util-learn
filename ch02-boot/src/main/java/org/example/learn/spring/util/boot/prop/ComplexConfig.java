package org.example.learn.spring.util.boot.prop;

import java.util.List;

public class ComplexConfig {

    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
