package com.co.udea.mintic.UdeaDemo.Repository;

import com.co.udea.mintic.UdeaDemo.Util.EnumRol;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Persona")
public class EntityPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private Long edad;
    @Column(name = "doc")
    private String doc;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private EnumRol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Collection<EntityPermisos> permisosCollection;

    public EntityPersona(Long id, String nombre, String apellido, Long edad, String doc, String password, EnumRol rol, Collection<EntityPermisos> permisosCollection) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.doc = doc;
        this.password = password;
        this.rol = rol;
        this.permisosCollection = permisosCollection;
    }

    public EntityPersona() {

    }
}
