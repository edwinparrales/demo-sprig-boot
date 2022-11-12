package co.main.springdemo.controlador;

import co.main.springdemo.dao.CategoriaService;
import co.main.springdemo.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/categoria",method = RequestMethod.GET)
public class CategoriaController {
    @Autowired
    private CategoriaService dao;
    @GetMapping("/listar")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categorias = dao.listarTodos();

        return new ResponseEntity<>(categorias, HttpStatus.OK);

    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return new ResponseEntity<>(dao.guardar(categoria),HttpStatus.CREATED);

    }

}
