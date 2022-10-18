package com.example.test;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static IMatchAlgo matchAlgo;

    private static Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
        }
    };

    public static void main(String[] args) {

        matchAlgo = new StrengthMatch();
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("P1","Ford Car Review", 8));
        pages.add(new Page("P2","Review Car", 8));
        pages.add(new Page("P3","Review Ford", 8));
        pages.add(new Page("P4","Toyota Car", 8));
        pages.add(new Page("P5","Honda Car", 8));
        pages.add(new Page("P6","Car", 8));
        List<Query> queries = new ArrayList<>();
        queries.add(new Query("Q1","Ford", 8));
        queries.add(new Query("Q2","Car", 8));
        queries.add( new Query("Q3","Review", 8));
        queries.add(new Query("Q4","Ford Review", 8));
        queries.add( new Query("Q5","Ford Car", 8));
        queries.add(new Query("Q6","Cooking french", 8));
        for (Query query: queries) {
            System.out.println(handleQuery(query, pages));
        }
    }

    static String handleQuery(Query query, List<Page> pages) {
        Map<String, Integer> strength = new HashMap<>();
        for(Page page: pages) {
            strength.put(page.id, matchAlgo.match(page, query));
        }
        List<Map.Entry<String, Integer>> matches = strength.entrySet().stream()
                .filter(strEntry -> strEntry.getValue()>0)
                .sorted(comp)
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder(query.id + ": ");
        for(int i = 0; i < 5; i++) {
            if(i==matches.size()) {
                break;
            }
            result.append(matches.get(i).getKey());
            result.append(" ");
        }
        return result.toString();
    }
}
