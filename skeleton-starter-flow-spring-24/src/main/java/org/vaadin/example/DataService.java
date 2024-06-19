package org.vaadin.example;

import com.google.common.reflect.TypeToken;
import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;


@Service
public class DataService {
    public ArrayList<Productos> getProductos()  {
        HttpClient client = HttpClient.newHttpClient();
        try{



            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/productos"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Type prodcutosList = new TypeToken<ArrayList<Productos>>() {
            }.getType();
            return gson.fromJson(response.body(), prodcutosList);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveData (Productos productosLista) {
        String url = "http://localhost:8080/productos";

        Gson gson = new Gson();
        String productosListJson = gson.toJson(productosLista);
        System.out.println(productosListJson);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .headers("Content-Type", "application/JSON")
                    .POST(HttpRequest.BodyPublishers.ofString(productosListJson))
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
