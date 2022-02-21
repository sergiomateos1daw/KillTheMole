package es.sergio.mateos.killthemole;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;



public class App extends Application {
    
    
    int posColumna = 0;
    int posFila = 0;
    boolean colocado = true;
    
    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        
        short tamXPantalla = 400;
        short tamYPantalla = 600;
        
        var scene = new Scene(root, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        
        LogicaInterna cuatroEnRaya = new LogicaInterna((short)10,(short)7);
        Tablero tablero = new Tablero();
        
        tablero.dibujarPradera(root);
        
        
        Timeline generarTopo = new Timeline(
                  new KeyFrame(Duration.seconds(1), (ActionEvent ae) -> {
                        colocado = cuatroEnRaya.colocarFicha(posColumna, posFila, 2);
                        posColumna = (int) (Math.random() * (9 -0)) + 0;
                        posFila = (int) (Math.random() * (6 -0)) + 0;
                        colocado = cuatroEnRaya.colocarFicha(posColumna, posFila, 1);
                        if(colocado == true) {
                            cuatroEnRaya.mostrarTableroConsola();
        }
                  })
          );
          
          generarTopo.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
          generarTopo.play(); // EJECUTAR EL TIMELINE
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}