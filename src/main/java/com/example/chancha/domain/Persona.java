package com.example.chancha.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="personas")
@Data
public class Persona {
    @Id //marca el campo como id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Permite crear o setear el campo como identity!
    private Long id;
    //@Column(name = "name") // le podemos decir q en nuestra bd se llama de otra forma!
    private String nombre;
    //@Column(name = "apellido")
    private String apellido;
    //@Column(name = "edad")
    private int edad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrera_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Carrera carrera;

    public Persona(Long id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
        id = 0L;
        nombre ="";
        apellido="";
        edad =0;
    }
}