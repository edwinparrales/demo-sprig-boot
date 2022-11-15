package co.main.springdemo.controlador;

import co.main.springdemo.dao.CategoriaService;
import co.main.springdemo.dao.ProductoService;
import co.main.springdemo.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/producto",method = RequestMethod.GET)
public class ProductoController {
    @Autowired
    private ProductoService dao;
     @GetMapping("/listar")
     public ResponseEntity<List<Producto>> listar(){
         List<Producto> productos = dao.listarTodos();
         return new ResponseEntity<>(productos, HttpStatus.ACCEPTED);

     }

     @GetMapping("/buscar/{nombre}")
     public ResponseEntity<List<Producto>> buscarProducto(@PathVariable(name = "nombre") String nombre){
         List<Producto> productos = new ArrayList<>();

          productos = dao.buscarProducto(nombre);

         return new ResponseEntity<>(productos,HttpStatus.OK);
     }


     @PostMapping("/guardar")

    public ResponseEntity<Producto> guardar( @RequestBody Producto producto){
         Producto producto1 = dao.guardar(producto);
         return new ResponseEntity<>(producto1,HttpStatus.ACCEPTED);
     }









}
