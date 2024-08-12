package com.eneskoseoglu.foodorder.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    NEW, IN_PROGRESS, DELIVERED, COMPLETED;

    public String getName() {
        return name();
    }
}
