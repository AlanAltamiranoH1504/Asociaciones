package altamirano.hernandez.asociaciones_spring.repositories;

import altamirano.hernandez.asociaciones_spring.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Integer> {
}
