package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public MainView(@Autowired DataService service) {

        Grid<Productos> grid = new Grid<>(Productos.class, false);
        grid.addColumn(Productos::getNombre).setHeader("Nombre");
        grid.addColumn(Productos::getCategoria).setHeader("Categoria");
        grid.addColumn(Productos::getEan13).setHeader("EAN13");
        grid.addColumn(Productos::getPrecio).setHeader("Precio");


;

        List<Productos> productos = service.getProductos();
        grid.setItems(productos);
        grid.setWidth("100%");
        grid.setWidthFull();


        add(grid);

    }

}
