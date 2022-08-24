package com.co.udea.mintic.UdeaDemo.Services;

import com.co.udea.mintic.UdeaDemo.Domain.Persona;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceProgramaAcademico {

    @Getter
    private String nombrePrograma;

    public String inscribirAlumno(Persona alumno) {
        String inscripcion =
                "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " con " + alumno.getEdad() +
                        " años, quedo inscrito al programa";
        return inscripcion;
    }

    public ArrayList doWhile (int a){
        ArrayList<String> objTraza = new ArrayList();
        do {
            System.out.println("Hola mundo " + a);
            objTraza.add("Hola mundo " + String.valueOf(a));
            a++;
        }while (a<10);
        return objTraza;
    }

}
