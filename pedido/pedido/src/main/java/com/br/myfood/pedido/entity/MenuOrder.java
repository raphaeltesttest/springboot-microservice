package com.br.myfood.pedido.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_menu_order")
public class MenuOrder {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
   private Long idMenu;
   private Long idRestaurant;

}
