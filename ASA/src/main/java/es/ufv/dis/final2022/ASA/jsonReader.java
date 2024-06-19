package es.ufv.dis.final2022.ASA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
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

    public void createPDF(Productos producto) {
        try {
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("productos/" + producto.getNombre() + ".pdf"));
            doc.open();
            String text = "some padding text";
            Paragraph p1 = new Paragraph(producto.getNombre());
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p1);
            p1 = new Paragraph(producto.getCategoria());
            doc.add(p1);
            p1 = new Paragraph(producto.getEan13());
            doc.add(p1);
            p1 = new Paragraph(producto.getPrecio());
            doc.add(p1);

            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
