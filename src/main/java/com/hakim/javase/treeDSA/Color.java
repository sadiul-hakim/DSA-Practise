package com.hakim.javase.treeDSA;

public enum Color {
    RED("red"),
    BLACK("black");

    private final String name;


    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
