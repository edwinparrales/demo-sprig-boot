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

    public List<Producto> listarTodos() {
        List<Producto> productos = new ArrayList<>();
        try {
            productos = productoRepository.findAll();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return productos;
    }

    public Producto guardar(Producto producto) {
        Producto productoNuevo = new Producto();
        try {
            System.out.println(producto.toString());
            productoNuevo = productoRepository.save(producto);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return productoNuevo;
    }

    public void eliminar(Long id) {
        try {
            productoRepository.deleteById(id);

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

    }

    public Producto buscarId(Long id) {
        Producto productoBuscado = new Producto();
        try {
            productoBuscado = productoRepository.findById(id).get();

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return productoBuscado;

    }

    public List<Producto> buscarProducto(String nombre) {
        List<Producto> productosEnc = new ArrayList<>();

        try {
            productosEnc = productoRepository.buscarProductos("%" + nombre + "%");

        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return productosEnc;

    }

    public Producto findProductoByCodigo(String codigo) {
        Producto productoBuscado = new Producto();
        try {
            productoBuscado = productoRepository.findProductoByCodigo(codigo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productoBuscado;
    }

    public List<Producto> findAllByDescripcionOrNombre(String descripcion, String nombre) {
        List<Producto> productos = new ArrayList<>();
        try {
            productos = productoRepository.findAllByDescripcionLikeOrNombreLike("%"+descripcion+"%", "%"+nombre+"%");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productos;
    }


}
