package altamirano.hernandez.asociaciones_spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @Column(name = "precio")
    private double total;

    //Muchas facturas tienen un solo cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //Constructor
    public Factura(){}
    public Factura(String descripcion, double total){
        this.descripcion = descripcion;
        this.total = total;
    }

    //Metodos Get y Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
