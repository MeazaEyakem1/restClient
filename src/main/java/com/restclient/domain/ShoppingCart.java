package com.restclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {


    public String cartNumber;
    public List<CartLine> cartLineList;
}
