package co.main.springdemo.dao;

import co.main.springdemo.modelo.Cliente;
import co.main.springdemo.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos(){

        return clienteRepository.findAll();

    }
    public Cliente guardar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
