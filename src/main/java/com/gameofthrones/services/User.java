package com.gameofthrones.services;

import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 22/11/2016.
 */
@Builder
@Getter
@Setter
public class User {
    private int id;
    @Singular
    private List<String> films;
    @Singular
    private Map<String,String> headers;
    private int age;
}
