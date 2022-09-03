package com.co.udea.mintic.UdeaDemo.Controler;

import com.co.udea.mintic.UdeaDemo.Domain.Persona;
import com.co.udea.mintic.UdeaDemo.Services.ServiceProgramaAcademico;
import com.co.udea.mintic.UdeaDemo.Util.UtilidadesComunes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "persona", description = "Metodos para Api persona")
@RestController
@RequestMapping(value = "/persona")
public class ControllerProgramaAcademico {

    @Autowired
    ServiceProgramaAcademico serviceProgramaAcademico;
    @Autowired
    UtilidadesComunes utilidadesComunes;

    @ApiOperation(value = "Endpoint para listar user")
    @GetMapping(path = "/udea/mintic/program", produces = "application/json")
    public ResponseEntity<String> callServicePrograma() {

        Persona objPersona = new Persona();
        objPersona.setNombre("Omar");
        objPersona.setApellido("Velez");
        objPersona.setEdad(24);

        String salida = serviceProgramaAcademico.inscribirAlumno(objPersona);

        return new ResponseEntity<String>(salida, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/udea/mintic/doWhile", produces = "application/json")
    public ArrayList doWhileController() {

        ArrayList<String> salida = new ArrayList<String>();

        salida = serviceProgramaAcademico.doWhile(7);

        return salida;
    }

    @GetMapping(path = "/udea/mintic/listaPersonas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Persona> listaPersonas() {

        utilidadesComunes.mensaje();
        return serviceProgramaAcademico.listar();
    }

    @PostMapping(path = "/udea/mintic/crearPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {

        boolean salida = serviceProgramaAcademico.addPersona(persona);

        if (salida == true) {

            return new ResponseEntity<Persona>(persona, HttpStatus.OK);

        } else {

            return new ResponseEntity("Error de Ejecucion", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping(path = "/udea/mintic/buscarPersona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> buscarPersona(@PathVariable int id) {
        if (serviceProgramaAcademico.buscarPersona(id) != null) {
            return new ResponseEntity<Persona>(serviceProgramaAcademico.buscarPersona(id), HttpStatus.OK);
        } else {
            return new ResponseEntity("Error de Ejecucion", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/udea/mintic/crearPersona/{doc}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> crearPersonaCondicional(@RequestBody Persona persona, @PathVariable String doc) {

        switch (doc) {
            case "CC":
                serviceProgramaAcademico.addPersonaCC(persona, doc);
                break;
            case "TI":
                serviceProgramaAcademico.addPersonaTI(persona, doc);
                break;

            default:
                return new ResponseEntity("Error de Ejecucion", HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<Persona>(persona, HttpStatus.OK);

    }

}

