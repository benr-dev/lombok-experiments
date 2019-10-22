package com.example;

import lombok.Data;

// Ordinarily this would cause setters to be added, but the
// final declarations prevent that.
// This version gets a fluent builder called 'of' so no constructor.
@Data(staticConstructor = "of")
public class ValueObjectWithBuilder {
    private final String name;
    private final int age;
}
