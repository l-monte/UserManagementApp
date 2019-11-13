package com.lman.application.utils;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

//    private static volatile IdGenerator INSTANCE = new IdGenerator();

    private Integer cache;

//    public static IdGenerator instance() {
//
//        if (INSTANCE == null) {
//            synchronized (IdGenerator.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new IdGenerator();
//                }
//            }
//        }
//        return INSTANCE;
//    }

    public IdGenerator() {
        System.out.println("MONTE: private c-tor of IdGenerator");

//        if (INSTANCE != null) {
//            throw new IllegalStateException("IdGenerator instance already created");
//        }

        cache = 0;
    }

    public Integer uniqueId() {
        Integer val = cache;
        cache++;
        return val;
    }
}
