package es.sergio.mateos.killthemole;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        
        short tamXPantalla = 400; // Esto es el tamaño X de la pantalla
        short tamYPantalla = 600; // Esto es el tamaño Y de la pantalla
        
        var scene = new Scene(root, tamXPantalla, tamYPantalla); // Con esto creamos el scene del juego
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false); // BLOQUEAR REESCALADO DE LA VENTANA
        Image image = new Image("/images/mazo0.png");  // Carga la imagen del mouse
        stage.getIcons().add(new Image("/images/topo.png")); // AÑADIMOS EL ICONO A LA VENTANA
        scene.setCursor(new ImageCursor(image)); // Aplica la imagen cargada anteriormente
        
        LogicaInterna logicaInterna = new LogicaInterna((short)3,(short)4); // LLama a la clase LogicaInterna
        LogicaGrafica logicaGrafica = new LogicaGrafica(); // LLama a la clase LogicaGrafica
        UserRegister userRegister = new UserRegister(); // LLama a la clase UserRegister
        HomeScreen homeScreen = new HomeScreen(); // LLama a la clase HomeScreen
        
        homeScreen.creacionPosterTitulo(root, scene, logicaInterna, logicaGrafica, userRegister); // Llama a un método de la clase HomeScreen y le pasamos una serie de parámetros que va a usar posteriormente
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}