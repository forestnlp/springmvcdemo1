package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {
    private int id;
    private String name;
    private String password;
    private String nickname;
    private String photo;
    private String filetype;
}
