package com.restclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private String id;
    private Long productNumber;
    private double price;
    private String description;
}
