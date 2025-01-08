package altamirano.hernandez.asociaciones_spring;

import altamirano.hernandez.asociaciones_spring.entities.Cliente;
import altamirano.hernandez.asociaciones_spring.entities.Direccion;
import altamirano.hernandez.asociaciones_spring.entities.Factura;
import altamirano.hernandez.asociaciones_spring.repositories.IClienteRepository;
import altamirano.hernandez.asociaciones_spring.repositories.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AsociacionesSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AsociacionesSpringApplication.class, args);
    }

    //Inyectamos los repositorios
    @Autowired
    private IFacturaRepository iFacturaRepository;
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public void run(String... args) throws Exception {
        oneToManyBusqueda();
    }

    //Metodo OneToMany (Cliente - Direccion)
    @Transactional
    public void oneToMany(){
        //Creamos el cliente
        Cliente cliente = new Cliente("Gregorio", "Altamirano Perez");

        //Creamos dos direcciones para ese cliente
        Direccion direccion1 = new Direccion("Antonio Rodriguez", 17);
        Direccion direccion2 = new Direccion("Bugambilia", 15);

        //Seteamos al cliente esas direccion
        cliente.addDireccion(direccion1);
        cliente.addDireccion(direccion2);

        iClienteRepository.save(cliente);
        System.out.println("cliente = " + cliente);
    }

    //Metodo OneToMany (Cliente - Direccion) Busqueda
    @Transactional
    public void oneToManyBusqueda(){
        Cliente clienteEncontrado = iClienteRepository.findById(3).orElse(null);

        if (clienteEncontrado != null) {
            Direccion direccion1 = new Direccion("Antonio Rodriguez", 17);
            Direccion direccion2 = new Direccion("Palmas", 35);

            clienteEncontrado.addDireccion(direccion1);
            clienteEncontrado.addDireccion(direccion2);

            iClienteRepository.save(clienteEncontrado);
        }else {
            System.out.println("Nos disponible");
        }
    }

    //Metodo ManyToOne
    @Transactional
    public void manyToOne(){
        //Creamos cliente
        Cliente cliente1 = new Cliente("Raquel", "Hernandez Hernandez");
        iClienteRepository.save(cliente1);

        //Creamos factura con el cliente
        Factura factura1 = new Factura("Compras Amazon", 2500);
        Cliente clienteEncontrado = iClienteRepository.findById(1).orElse(null);
        factura1.setCliente(clienteEncontrado);
        Factura facturaGuardada = iFacturaRepository.save(factura1);
        System.out.println("facturaGuardada = " + facturaGuardada);
    }

    @Transactional
    public void manyToOneFindById(){
        Cliente clienteEncontrado = iClienteRepository.findById(1).orElse(null);
        if (clienteEncontrado != null){
            //Asignamos una factura a ese nuevo cliente
            Factura factura2 = new Factura("Compras bocinas", 500);
            factura2.setCliente(clienteEncontrado);
            iFacturaRepository.save(factura2);
        }else{
            System.out.println("clienteEncontrado no encontrado");
            return;
        }
        System.out.println("clienteEncontrado = " + clienteEncontrado);
    }
}
