package br.edu.ifsul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsul.dto.CategoriaDTO;
import br.edu.ifsul.service.CategoryService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
        CategoriaDTO dto = categoryService.findById(id);
        return ResponseEntity.ok(dto);
    }
}
