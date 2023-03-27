package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private String pname;
    private int page;
    private int gender;
    private String[] hobby;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private List<Pet> pets;
    private Map<String,Pet> petMap;

    @Override
    public String toString() {
        return "Person{" +
                "pname='" + pname + '\'' +
                ", page=" + page +
                ", gender=" + gender +
                ", hobby=" + Arrays.toString(hobby) +
                ", birthdate=" + birthdate +
                ", pets=" + pets +
                ", petMap=" + petMap +
                '}';
    }
}
