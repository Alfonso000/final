package es.ufv.dis.final2022.ASA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class jsonReader {
    public ArrayList<Productos> leerJson(String fichero){
        try{
            // leer fichero
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fichero)));

            // convertir JSON a un arraylist
            ArrayList<Productos> listaProductos = new Gson().fromJson(reader, new TypeToken<ArrayList<Productos>>(){}.getType());

            //cerramos el reader
            reader.close();

            // devolvemos el arraylist
            return listaProductos;

        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void escribirJson(String fichero, ArrayList<Productos> listaProductos){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(fichero)){
            gson.toJson(listaProductos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
