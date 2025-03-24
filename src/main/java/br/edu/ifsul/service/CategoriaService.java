package br.edu.ifsul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifsul.dto.CategoriaDTO;
import br.edu.ifsul.dto.CursoDTO;
import br.edu.ifsul.entity.Categoria;
import br.edu.ifsul.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public CategoriaDTO findById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return new CategoriaDTO(categoria.get());
    }

    @Transactional(readOnly = true)
    public Page<CategoriaDTO> findAll(Pageable pageable) {
        Page<Categoria> categorias = categoriaRepository.findAll(pageable);
        return categorias.map(CategoriaDTO::new);   
    }

    @Transactional
    public CategoriaDTO insert(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
    }

    private void copyDtoToEntity(CategoriaDTO dto, Categoria entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        List<CursoDTO> cursos = dto.getCursos();
        for(CursoDTO c : cursos) {
            entity.getCursos().add(cursos);
        }
    }
}
