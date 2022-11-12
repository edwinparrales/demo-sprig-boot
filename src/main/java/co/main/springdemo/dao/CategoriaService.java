package co.main.springdemo.dao;

import co.main.springdemo.modelo.Categoria;
import co.main.springdemo.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos(){
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = categoriaRepository.findAll();

        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return  categorias;
    }

    public Categoria guardar(Categoria categoria) {
        return  categoriaRepository.save(categoria);
    }
}
