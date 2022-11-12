package co.main.springdemo.dao;

import co.main.springdemo.modelo.Ciudad;
import co.main.springdemo.repositorio.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;
    public List<Ciudad> listarTodo(){
        return ciudadRepository.findAll();
    }

    public Ciudad guardar(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }

}
