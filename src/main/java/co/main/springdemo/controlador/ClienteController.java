package co.main.springdemo.controlador;

import co.main.springdemo.dao.ClienteService;
import co.main.springdemo.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/cliente",method = RequestMethod.GET)
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar(){
        return new ResponseEntity<>(clienteService.listarTodos(), HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "/guardar")
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente){

        return new ResponseEntity<>(clienteService.guardar(cliente),HttpStatus.CREATED);
    }


}
