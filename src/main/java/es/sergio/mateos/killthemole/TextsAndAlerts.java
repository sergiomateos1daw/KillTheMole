package es.sergio.mateos.killthemole;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Sergio
 */
public class TextsAndAlerts {
    LogicaInterna logicaInterna;
    LogicaGrafica logicaGrafica;
    Label labelPuntos; // AÑADIMOS EL OBJETO LABELPUNTOS
    ImageView bombaIcon;
    Image bombaIconImg = new Image(getClass().getResourceAsStream("/images/bombaIcon.png")); // CARGA LA IMAGEN DEL TOPO
    ButtonType jugarOtra = new ButtonType("Jugar de nuevo");
    ButtonType salir = new ButtonType("Salir");
    
    
    
    
    public TextsAndAlerts(Pane root, LogicaInterna logicaInterna, LogicaGrafica logicaGrafica){ // ESTE METODO CREA LOS TEXTOS QUE VAMOS A VER EN PANTALLA Y NOS DICEN LAS PUNTUACIÓN EN EL JUEGO
        this.logicaInterna = logicaInterna;
        this.logicaGrafica = logicaGrafica;
        labelPuntos = new Label(""+logicaInterna.puntos); // ESTO MUESTRA EN PANATALLA LOS PUTNOS ACUTALES
        Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/go3v2.ttf"), 25);
        font = Font.font("Gang of Three", FontWeight.BOLD, FontPosture.REGULAR, 25); // ESTABLECEMOS ALGUNAS DE LAS PROPIEDADES DE LA FUENTE DEL TEXTO
        labelPuntos.setFont(font); // CON ESTO LE APLICAMOS LAS POPIEDADES DE LA FUENTE AL TEXTO
        labelPuntos.setTextFill(Color.rgb(65, 45, 42)); // CAMBIA EL COLOR DEL TEXTO A NEGRO
        labelPuntos.setTranslateX(105); // CAMBIA LAS COORDENADAS X DEL TEXTO
        labelPuntos.setTranslateY(30); // CAMBIA LAS COORDENADAS Y DEL TEXTO
        root.getChildren().add(labelPuntos); // AÑADE EL TEXTO LABELPUTNOS AL ROOT
    }
    
    
    public void actualizarLabelPuntos(){ // ESTE METODO ACTUALIZA EL LABEL DE PUTNOS QUE SE MUESTRA EN LA PANTALLA DURANTE LA PARTIDA
        System.out.println(logicaInterna.puntos);
        labelPuntos.setText(""); // PRIMERO BORRAMOS EL TEXTO QUE YA SE ESTABA MOSTRANDO
        labelPuntos.setText(""+logicaInterna.puntos); // Y ESCRIBIMOS EL TEXTO NUEVO, CON LA PUNTUACION ACTUALIZADA
    }
    
    public void mostrarAlertInfo() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(jugarOtra, salir);
        alert.setHeaderText(null);
        alert.setHeaderText("¡Has explotado una bomba!");
        alert.setGraphic(new ImageView(new Image("/images/bombaIcon.png")));
        alert.setTitle("Fin de la partida");
        alert.setContentText("Has conseguido "+logicaInterna.puntos+" punto/s");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == null) {
            System.out.println("No se ha seleccionado nada");
        } else if (option.get() == jugarOtra) {
            System.out.println("Jugaremos otra partida");
            logicaInterna.reinicioPartida();
            actualizarLabelPuntos();
        } else if (option.get() == salir) {
            System.out.println("Salir de la partida");
            System.exit(0);
        }
    }
}
