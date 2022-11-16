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
@RequestMapping(value = "api/producto", method = RequestMethod.GET)
public class ProductoController {
    @Autowired
    private ProductoService dao;

    //Listar todos los productos de la Bd
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = dao.listarTodos();
        return new ResponseEntity<>(productos, HttpStatus.ACCEPTED);

    }
    //Buscar un producto por su nombre conincidencias mas proximas
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<Producto>> buscarProducto(@PathVariable(name = "nombre") String nombre) {
        List<Producto> productos = new ArrayList<>();

        productos = dao.buscarProducto(nombre);

        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //Almacenar un registro de producto en la BD
    @PostMapping("/guardar")

    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        Producto producto1 = dao.guardar(producto);
        return new ResponseEntity<>(producto1, HttpStatus.ACCEPTED);
    }
    //Eliminacion de un producto
    @DeleteMapping("/eliminar/{id}")

    public ResponseEntity eliminar(@PathVariable Long id) {

        dao.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    //Busqueda por descripcion o nombre
    @GetMapping("/buscar/desnom/{parametro}")
    public ResponseEntity<List<Producto>> findAllByDescripcionOrNombre(@PathVariable(name = "parametro") String parametro) {
         List<Producto> productos =  dao.findAllByDescripcionOrNombre(parametro,parametro);
        return new ResponseEntity<>(productos, HttpStatus.ACCEPTED);
    }

    //Busqueda por codigo

    @GetMapping("/buscar/codigo/{codigo}")

    public ResponseEntity<Producto> buscarCodigo(@PathVariable String codigo) {
        Producto producto = dao.findProductoByCodigo(codigo);

        return new ResponseEntity<>(producto,HttpStatus.OK);
    }



}
