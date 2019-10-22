package com.example;

import lombok.Data;

// Ordinarily this would cause setters to be added, but the
// final declarations prevent that.
@Data
public class ValueObject {
    private final String name;
    private final int age;
}
