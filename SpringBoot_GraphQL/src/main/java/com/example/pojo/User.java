package com.example.pojo;

import lombok.Data;

import java.util.UUID;

/**
 * 用户
 *
 * @author DELL_
 * @date 2022/09/06
 */
@Data
public class User {
    private UUID id;
    private String username;
    private String nickname;
    private City city;
}
