package pe.upc.estudiando2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.estudiando2.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
