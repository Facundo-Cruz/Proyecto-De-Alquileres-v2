package com.remax.alquileres.entidades;

import com.remax.alquileres.enumeraciones.Rol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "usuarios")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Boolean estado;
    private String clave;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    
}
