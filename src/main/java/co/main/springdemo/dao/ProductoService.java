package co.main.springdemo.dao;

import co.main.springdemo.modelo.Producto;
import co.main.springdemo.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos(){
        List<Producto> productos = new ArrayList<>();
        try {
            productos = productoRepository.findAll();

        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return  productos;
    }

    public Producto guardar( Producto producto){
        Producto productoNuevo =  new Producto();
        try {
            System.out.println(producto.toString());
            productoNuevo = productoRepository.save(producto);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return  productoNuevo;
    }

}
