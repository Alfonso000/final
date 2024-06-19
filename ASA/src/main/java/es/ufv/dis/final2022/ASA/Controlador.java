package es.ufv.dis.final2022.ASA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador {


    @GetMapping("/productos")
    public ArrayList<Productos> productos(){
        ArrayList<Productos> listaProductos = new jsonReader().leerJson("static/datos.json"); // leemos el fichero json
        return listaProductos;
    }
}
