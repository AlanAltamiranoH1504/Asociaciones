package altamirano.hernandez.asociaciones_spring.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    //Relacion OneToMany con Factura
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<Factura> facturas = new ArrayList<>();

    //Relacion OneToMany con Direccion
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Direccion> direcciones = new ArrayList<>();

    //Constructores
    public Cliente(){}
    public Cliente(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //Metodos del Ciclo de vida
    @PostPersist
    public void postPersist(){
        System.out.println("Cliente persistido en la DB");
    }
    @PostUpdate
    public void postUpdate(){
        System.out.println("Cliente actualizado en la DB");
    }
    @PostRemove
    public void postRemove(){
        System.out.println("Cliente eliminado en la DB");
    }

    //Metodos Get y Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public List<Direccion> getDirecciones(){
        return this.direcciones;
    }
    public void setDirecciones(List<Direccion> direcciones){
        this.direcciones = direcciones;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    //Metodo auxiliares para agregar y eliminar facturass
    public void addFactura(Factura factura){
        this.facturas.add(factura);
    }
    public void removeFactura(Factura factura){
        for (var facturaE : this.facturas){
            if (facturaE.getId() == factura.getId()){
                this.facturas.remove(factura);
            }else{
                System.out.println("Factura no encontrada");
            }
        }
    }
    //Metodos auxiliares para direccion
    public void addDireccion(Direccion direccion){
        this.direcciones.add(direccion);
    }
    public void removeDireccion(Direccion direccion){
        for (var d: this.direcciones){
            if (d.getId() == direccion.getId()){
                this.direcciones.remove(direccion);
            }else{
                System.out.println("Direccion no encontrada");
            }
        }
    }
}
