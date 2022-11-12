package co.main.springdemo.repositorio;

import co.main.springdemo.modelo.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad,Long> {
}
