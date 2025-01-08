package altamirano.hernandez.asociaciones_spring.repositories;

import altamirano.hernandez.asociaciones_spring.entities.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaRepository extends CrudRepository<Factura, Integer> {
}
