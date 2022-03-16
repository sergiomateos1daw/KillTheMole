
package es.sergio.mateos.killthemole;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;

public class UserRegister {
    
    LogicaInterna logicaInterna;
    
    ImageView note; // AÑADIMOS EL OBJETO NOTE
    String usuarioActual = ""; // ALMACENA EL NOMBRE DEL USUARIO QUE ESTA JUGANDO DURANTE LA EJECUCION DEL JUEGO
    int recordActual = 0;
    String usuarioRecord = "";
    
    public void registroNombre(LogicaInterna logicaInterna){ // ESTE METODO LANZA UNA PEQUEÑA VENTANA PARA QUE EL USUARIO INTRODUZCA SU NOMBRE ANTES DE QUE COMIENZE A JUGAR
        
        this.logicaInterna = logicaInterna;
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setGraphic(note);
        dialog.setTitle("Kill The Mole");
        dialog.setHeaderText("Introduce tu nombre para guardar tu puntuación");
        dialog.setContentText("Introduce tu nombre:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            usuarioActual = result.get();
        }
    }
    public void writeFileRecord() // ESTE METODO ALMACENA EL NUMERO DE PUTNOS QUE SE HAN OBTENIDO, SIEMPRE Y CUANDO SE SUPERE EL RECORD ANTERIOR
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("files/record.txt"); // ESTA ES LA RUTA EN LA QUE SE ALMACENA LA PUNTUACION
            pw = new PrintWriter(fichero);
            pw.println(logicaInterna.puntos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              
           }
        }
    }
    public void writeFileUsuario()// ESTE METODO ALMACENA EL NOMBRE DEL JUGADOR ACTUAL EN EL FICHERO DE USUARIORECORD, SIEMPRE Y CUANDO SE SUPERE EL RECORD ANTERIOR
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("files/usuarioRecord.txt"); // ESTA ES LA RUTA EN LA QUE SE ALMACENA EL NOMBRE DEL USUARIO
            pw = new PrintWriter(fichero);
            pw.println(usuarioActual);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              
           }
        }
    }
    
    public void readFileInt(String ruta){ // ESTE METODO LEE Y DEVUELVE EL CONTENIDO DE UN FICHERO, SIEMPRE DEVUELVE UN VALOR DE TIPO INT
       try (BufferedReader reader = new BufferedReader(new FileReader(new File(ruta)))) {
            String line;
            line = reader.readLine();
            recordActual = Integer.parseInt(line);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readFileString(String ruta){// ESTE METODO LEE Y DEVUELVE EL CONTENIDO DE UN FICHERO, SIEMPRE DEVUELVE UN VALOR DE TIPO STRING
       try (BufferedReader reader = new BufferedReader(new FileReader(new File(ruta)))) {
            String line;
            line = reader.readLine();
            usuarioRecord = line;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
