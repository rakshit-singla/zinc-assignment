package com.example.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Page {

    public final String id;
    private Map<String, Integer> words;

    public Page(String id, String pageString, int maxStrength) {
        this.id = id;
        String[] words = pageString.toLowerCase().split(" ");
        this.words = new HashMap<>();
        int str = maxStrength;
        for(int i=0;i<words.length;i++) {
            this.words.put(words[i],str);
            str--;
        }
    }

    public Set<String> getWords() {
        return words.keySet();
    }

    public boolean contains(String word) {
        return words.containsKey(word);
    }

    public Integer get(String word) {
        return words.getOrDefault(word, null);
    }


}
