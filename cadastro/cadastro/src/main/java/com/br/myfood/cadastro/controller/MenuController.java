package com.br.myfood.cadastro.controller;

import com.br.myfood.cadastro.dto.MenuDto;
import com.br.myfood.cadastro.entity.Menu;
import com.br.myfood.cadastro.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @PostMapping("/insert")
    public ResponseEntity insertMenu(@RequestBody MenuDto menuDto) {

        try {

            Menu menu = menuService.insertMenu(menuDto);

            return Objects.nonNull(menu) ?
                    ResponseEntity.ok(menu) :
                    ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMenu(@PathVariable("id") Long id, @RequestBody MenuDto menuDto) {

        try {

            Menu menu = Menu.create(menuDto);
            menu.setId(id);

            Menu updateMenu = menuService.updateMenu(menu);

            return Objects.nonNull(updateMenu) ? ResponseEntity.ok(updateMenu) : ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMenu(@PathVariable("id") Long id) {
        return menuService.deleteMenu(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

       Optional<Menu> menu = menuService.findById(id);

       return menu.isPresent() ?
               ResponseEntity.ok(menu.get()) :
               ResponseEntity.notFound().build();


    }

}
