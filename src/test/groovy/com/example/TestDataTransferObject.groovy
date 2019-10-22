package com.example

import spock.lang.Specification

import java.lang.reflect.Constructor
import java.lang.reflect.Method

class TestDataTransferObject extends Specification{

    def "dto has getters"() {
        setup:
        def clazz = Class.forName("com.example.DataTransferObject")

        when:
        def getterCount = countGetters(clazz)

        then:
        assert getterCount == 2
    }

    def "dto has setters"() {
        setup:
        def clazz = Class.forName("com.example.DataTransferObject")

        when:
        def setterCount = countSetters(clazz)

        then:
        assert setterCount == 2
    }

    def "dto has default constructor"() {
        setup:
        def clazz = Class.forName("com.example.DataTransferObject")

        expect: hasDefaultConstructor(clazz)
    }

    private int countGetters(Class<?> clazz) {
        def getterCount = 0
        for (Method m : clazz.methods) {
            if (m.name.startsWith("get") && m.name != "getClass") getterCount++
        }
        return getterCount
    }

    boolean hasDefaultConstructor(Class<?> aClass) {
        Constructor[] constructors = aClass.constructors

        for(Constructor c : constructors) {
            if(c.parameterCount == 0) return true
        }

        return false
    }

    private int countSetters(Class<?> clazz) {
        def setterCount = 0
        for (Method m : clazz.methods) {
            if (m.name.startsWith("set")) setterCount++
        }
        return setterCount
    }
}
