package com.example.test;

import java.util.HashSet;
import java.util.Set;

public class StrengthMatch implements IMatchAlgo {

    public StrengthMatch() {}

    @Override
    public Integer match(Page page, Query query) {
        Set<String> queryWords = query.getWords();
        Set<String> pageWords = page.getWords();
        Set<String> intersection = new HashSet<>(queryWords);
        intersection.retainAll(pageWords);
        int value = 0;
        for(String word: intersection) {
            value += page.get(word) * query.get(word);
        }
        return value;
    }
}
