package altamirano.hernandez.asociaciones_spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calle;
    private int numero;

    //Constructores
    public Direccion(){}
    public Direccion(String calle, int numero){
        this.calle = calle;
        this.numero = numero;
    }

    //Metodos GET y SET
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
