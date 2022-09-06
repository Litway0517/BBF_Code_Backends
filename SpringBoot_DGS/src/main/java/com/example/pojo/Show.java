package com.example.pojo;

import lombok.Data;

/**
 * 显示
 *
 * @author DELL_
 * @date 2022/09/06
 */
@Data
public class Show {
    private String title;
    private int releaseYear;

    public Show() {
    }

    public Show(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
}
