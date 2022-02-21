package es.sergio.mateos.killthemole;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Tablero {
    
    ImageView cielo1;
    ImageView cielo2;
    ImageView pradera;
    
    public void dibujarPradera(Pane root){
        Image cieloImg = new Image(getClass().getResourceAsStream("/images/cielo.png")); // CARGA LA IMAGEN DE FONDO
        Image praderaImg = new Image(getClass().getResourceAsStream("/images/pradera.png")); // CARGA LA IMAGEN DE FONDO
        cielo1 = new ImageView(cieloImg); // CREA EL OBJETO fondo1
        cielo2 = new ImageView(cieloImg); // CREA EL OBJETO fondo1
        pradera = new ImageView(praderaImg); // CREA EL OBJETO fondo1
        root.getChildren().add(cielo1);
        root.getChildren().add(cielo2);
        root.getChildren().add(pradera);
    }
    
}
