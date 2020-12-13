package com.br.myfood.pedido.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long idClient;
    private Long idRestaurant;
    private Long idMenu;

}
