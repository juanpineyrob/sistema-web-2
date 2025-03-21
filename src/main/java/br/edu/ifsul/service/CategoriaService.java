package br.edu.ifsul.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifsul.dto.CategoriaDTO;
import br.edu.ifsul.entity.Categoria;
import br.edu.ifsul.repository.CategoriaRepository;

@Service
public class CategoryService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public CategoriaDTO findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return new CategoriaDTO(categoria.get());
    }
}
