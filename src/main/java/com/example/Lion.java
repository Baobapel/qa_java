package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private IKitty kitty;

    public Lion(String sex) throws Exception {
        this(new Feline(), sex);
    }

    public Lion(IKitty kitty, String sex) throws Exception {
        if (kitty == null) {
            throw new IllegalArgumentException("Kitty не может быть null");
        }
        this.kitty = kitty;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return kitty.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return kitty.getFood();
    }
}
