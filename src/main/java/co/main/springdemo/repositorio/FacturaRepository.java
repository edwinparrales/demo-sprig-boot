package co.main.springdemo.repositorio;

import co.main.springdemo.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
