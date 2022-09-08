package com.co.udea.mintic.UdeaDemo.Services;

import com.co.udea.mintic.UdeaDemo.Domain.Persona;
import com.co.udea.mintic.UdeaDemo.Repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.Repository.RepositoryPersona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePersona {

    @Getter @Setter
    private String nombrePrograma;

    @Autowired
    RepositoryPersona repositoryPersona;

    ArrayList<Persona> listaP;

    public ServicePersona(ArrayList<Persona> listaP) {
        this.listaP = listaP;
    }

    public String inscribirAlumno(Persona alumno) {
        String inscripcion =
                "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " con " + alumno.getEdad() +
                        " años, quedo inscrito al programa";
        return inscripcion;
    }

    public ArrayList doWhile(int a) {
        ArrayList<String> objTraza = new ArrayList();
        do {
            System.out.println("Hola mundo " + a);
            objTraza.add("Hola mundo " + String.valueOf(a));
            a++;
        } while (a < 10);
        return objTraza;
    }

    public boolean addPersona(Persona persona) {

        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());

        listaP.add(objPersona);

        return Boolean.TRUE;
    }

    public boolean addPersonaCC(Persona persona, String doc) {
        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());

        System.out.println("Creo la persona con CC");

        listaP.add(objPersona);

        return Boolean.TRUE;
    }

    public boolean addPersonaTI(Persona persona, String doc) {

        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(persona.getDoc());

        System.out.println("Creo la persona con TI");

        listaP.add(objPersona);

        return Boolean.TRUE;
    }

    public ArrayList<Persona> listar() {

        System.out.println("Ingreso al metodo listar");

        return listaP;
    }

    public Persona buscarPersona(int id) {
        Persona persona = null;
        for (Persona p : listaP) {
            if (p.getId() == id) {
                return p;
            }
        }
        return persona;
    }

    public Boolean borrarPersona(Persona persona) {

        listaP.remove(persona);

        return Boolean.TRUE;
    }

    public List <EntityPersona> listarTodoJPA(){

        List<EntityPersona> List = repositoryPersona.findAll();

        return List;

    }

    public Boolean insertarPersonaJPA(EntityPersona persona){
        try {
            repositoryPersona.save(persona);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public Boolean actualizarTodoJPA(EntityPersona persona){

        try {
            repositoryPersona.save(persona);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void actualizarParcialJPA(EntityPersona persona) {
        EntityPersona personaTemp = repositoryPersona.findById(persona.getId()).orElse(null);

        if (persona.getNombre() != null) {
            personaTemp.setNombre(persona.getNombre());
        } else if (persona.getApellido() != null) {
            personaTemp.setApellido(persona.getApellido());
        } else if (persona.getEdad() != null) {
            personaTemp.setEdad(persona.getEdad());
        } else if (persona.getDoc() != null) {
            personaTemp.setDoc(persona.getDoc());
        } else if (persona.getPassword() != null) {
            personaTemp.setPassword(persona.getPassword());
        }

        repositoryPersona.save(personaTemp);
    }

    public void deletePersonaJPA(Long id){
        repositoryPersona.deleteById(id);
    }

}

