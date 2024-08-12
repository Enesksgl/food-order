package com.eneskoseoglu.foodorder.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TableStatus {
    IDLE, USING, RESERVED;

    public String getName() {
        return name();
    }
}
