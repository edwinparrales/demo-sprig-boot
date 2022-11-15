package co.main.springdemo.repositorio;

import co.main.springdemo.modelo.FacturaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaItemRepository extends JpaRepository<FacturaItem,Long> {
}
