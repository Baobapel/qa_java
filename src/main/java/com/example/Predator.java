package com.example;

import java.util.List;

public interface Predator {
    int getKittens();
    int getKittens(int kittensCount);
    List<String> getFood();
    List<String> eatMeat() throws Exception;
}
