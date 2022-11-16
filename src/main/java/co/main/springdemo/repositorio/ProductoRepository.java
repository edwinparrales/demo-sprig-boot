package co.main.springdemo.repositorio;

import co.main.springdemo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "select p from  Producto p where p.nombre like :nombre")
    List<Producto> buscarProductos(@Param("nombre") String nombre);

    Producto findProductoByCodigo(String codigo);

    List<Producto> findAllByDescripcionLikeOrNombreLike(String descripcion, String nombre);
}
