package com.example.testnvs.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private String price;

    private String title;

    private Date createdAt;

    private Date updateAt;
}
