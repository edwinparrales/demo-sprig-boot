package co.main.springdemo.controlador;

import co.main.springdemo.dao.CiudadService;
import co.main.springdemo.modelo.Ciudad;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/ciudad",method = RequestMethod.GET)
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<Ciudad>> listar(){
        return new ResponseEntity<>(ciudadService.listarTodo(), HttpStatus.OK);
    }
    @PostMapping(value = "/guardar")
    public ResponseEntity<Ciudad> guardar(@RequestBody Ciudad ciudad){
        return new ResponseEntity<>(ciudadService.guardar(ciudad),HttpStatus.CREATED);
    }

}
