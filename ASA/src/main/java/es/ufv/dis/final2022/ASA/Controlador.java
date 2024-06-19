package es.ufv.dis.final2022.ASA;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controlador {


    @GetMapping("/productos")
    public ArrayList<Productos> productos(){
        ArrayList<Productos> listaProductos = new jsonReader().leerJson("static/datos.json"); // leemos el fichero json
        return listaProductos;
    }

    @PostMapping("/productos")
    public ResponseEntity<String> addProducto(@RequestBody Productos newProducto){
        ArrayList<Productos> listaProductos = new jsonReader().leerJson("static/datos.json"); // leemos el fichero json

        listaProductos.add(newProducto);
        new jsonReader().escribirJson("./src/main/resources/static/datos.json", listaProductos); // escribimos el fichero json
        return new ResponseEntity<>("Producto añadido", HttpStatus.OK);
    }
}
