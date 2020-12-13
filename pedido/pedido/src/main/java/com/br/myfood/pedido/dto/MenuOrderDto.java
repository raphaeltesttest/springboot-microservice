package com.br.myfood.pedido.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {

   private Long idMenu;
   private Long idRestaurant;

}
