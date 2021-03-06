package es.sergio.mateos.killthemole;

public class LogicaInterna {
    
    boolean depuracion = false;
    
    short tamXTablero;
    short tamYTablero;
    char[][] tablero;
    final char JUGADOR1 = 'T';
    final char BOMBA = 'B';
    final char TOPO_DORADO = 'D';
    final char VACIO = '.';
    byte posColumna = 0;
    byte posFila = 0;
    boolean colocado = true;
    int posicionXTopo = 0;
    int posicionYTopo = 0;
    int posicionXBomba = 0;
    int posicionYBomba = 0;
    int posicionXTopoDorado = 0;
    int posicionYTopoDorado = 0;
    int puntos = 0;
    
    public void reinicioPartida(){ // ESTE METODO REESTABLECE EL VALOR DE LAS VARIABLES AL QUE TENIAN AL EMPEZAR LA EJECUCION DEL PROGRAMA
        if(depuracion==true){
            System.out.println("Se restablecen todas la variables a sus valores iniciales");
        }
        posColumna = 0;
        posFila = 0;
        colocado = true;
        posicionXTopo = 0;
        posicionYTopo = 0;
        posicionXBomba = 0;
        posicionYBomba = 0;
        posicionXTopoDorado = 0;
        posicionYTopoDorado = 0;
        puntos = 0;
    }
    
    //Método constructor
    public LogicaInterna(){ // ESTE METODO CREA EL ARRAY BASE EN EL QUE SE ALMACENARA LAS POSICIONES DE LOS OBJETOS (TOPO, TOPO DORADO, BOMBA)
        tamXTablero = 7;
        tamYTablero = 6;
        tablero = new char[tamXTablero][tamYTablero];
        for(int x=0;x<tamXTablero;x++){ // ESTE BUCLE RECORRE LA X DE TODO EL ARRAY
            for(int y=0;y<tamYTablero;y++){ // ESTE BUCLE RECORRE LA Y DE TODO EL ARRAY
                tablero[x][y] = VACIO; // ESTABLECE UN VALOR PARA LA POSICION SELECCIONADA
            }
        }
    }
    
    //Método constructor
    public LogicaInterna(short tamX, short tamY){ //ESTE METODO ES IGUAL QUE EL CONSTRUCCTOR DE ARRIBA, PERO SE LE PUEDEN PASAR LOS PARAMETROS PARA MODIFICARA EL TAMAÑO DEL ARRAY
        tamXTablero = tamX;
        tamYTablero = tamY;
        tablero = new char[tamXTablero][tamYTablero];
        for(int x=0;x<tamXTablero;x++){
            for(int y=0;y<tamYTablero;y++){
                tablero[x][y] = VACIO;
            }
        }
    }
    
    public void mostrarTableroConsola(){ // ESTE METODO MUESTRA EL TABLERO POR CONSOLA
        if(depuracion==true){
            System.out.println("");
            System.out.println("Tablero: ");
        }
        for(int y=0;y<tamYTablero;y++){
            for(int x=0;x<tamXTablero;x++){
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void borrarTableroConsola(){ 
        for(int y=0;y<tamYTablero;y++){
            for(int x=0;x<tamXTablero;x++){
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public boolean colocarObjeto(int columna, int fila, int jugador){
        if(columna >= 0 && columna < tamXTablero) {
            switch(jugador) {
            case 1:
                tablero[columna][fila] = JUGADOR1;
                break;
            case 2:
                tablero[columna][fila] = VACIO;
                break;
            case 3:
                tablero[columna][fila] = BOMBA;
                break;
            case 4:
                tablero[columna][fila] = TOPO_DORADO;
                break;
        }
            return true;
        } else {
            return false;
        }
    }
    
    public int buscarFila(int columna){
        int fila = 0;
        while(fila < tamYTablero && tablero[columna][fila] == VACIO){
            fila++;
        }
        return fila - 1;
    }
    
    
    
    public int[] obtenerPosicionTopo(){
        int[] posMoleArr = new int[2];
        for(int x=0;x<tamXTablero;x++){
            for(int y=0;y<tamYTablero;y++){
                if(tablero[x][y]==JUGADOR1){
                    posMoleArr[0]=x;
                    posMoleArr[1]=y;
                    posicionXTopo = posMoleArr[0];
                    posicionYTopo = posMoleArr[1];
                }
            }
        }
        return (posMoleArr);
    }
    
    public int[] obtenerPosicionBomba(){
        int[] posBombArr = new int[2];
        for(int x=0;x<tamXTablero;x++){
            for(int y=0;y<tamYTablero;y++){
                if(tablero[x][y]==BOMBA){
                    posBombArr[0]=x;
                    posBombArr[1]=y;
                    posicionXBomba = posBombArr[0];
                    posicionYBomba = posBombArr[1];
                }
            }
        }
        return (posBombArr);
    }
    
    public int[] obtenerPosicionTopoDorado(){
        int[] posTopoDoradoArr = new int[2];
        for(int x=0;x<tamXTablero;x++){
            for(int y=0;y<tamYTablero;y++){
                if(tablero[x][y]==TOPO_DORADO){
                    posTopoDoradoArr[0]=x;
                    posTopoDoradoArr[1]=y;
                    posicionXTopoDorado = posTopoDoradoArr[0];
                    posicionYTopoDorado = posTopoDoradoArr[1];
                }
            }
        }
        return (posTopoDoradoArr);
    }
    
    
}

