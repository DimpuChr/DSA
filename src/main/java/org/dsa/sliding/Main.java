package org.dsa.sliding;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Character> set = new HashSet<>();
        set.add('c');
        set.add('d');
        System.out.println(set);
        set.remove('c');
        System.out.println(set);
        System.out.println(set.size());

    }
}
