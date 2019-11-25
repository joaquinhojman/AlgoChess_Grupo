package vista;

import AlgoChess.Jugador;
import Tablero.Casillero;
import Tablero.Coordenada;
import Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;


public class TableroVista extends Group {
    public static final double casilleroSize = 2;
    public static final int ancho = 20;
    public static final int alto = 20;
    Tablero tablero;

    Jugador jugador1;
    Jugador jugador2;

    public GridPane tableroGui;

    private CasilleroVista[][] casilleros;

    public TableroVista(Tablero tablero, Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        tableroGui = new GridPane();
        tableroGui.setGridLinesVisible(true);
        casilleros = new CasilleroVista[ancho][alto];
        for(int i = 1; i <= alto; i++) {
            for(int j = 1; j <= ancho; j++) {
                Coordenada coordenada = new Coordenada(i, j);
                Casillero casillero = tablero.obtenerCasillero(coordenada);
                CasilleroVista casilleroVista = new CasilleroVista(casillero, jugador1, jugador2);
                casilleroVista.setStyle("-fx-background-color: white; -fx-border-color: black;");
                casilleroVista.setPrefSize(33,33);
                tableroGui.add(casilleroVista, i, j);
                this.casilleros[i-1][j-1] = casilleroVista;
            }
        }

        this.agregarVista(tableroGui);
    }

    public void agregarVistaAlMapa (){
        for (int i=1; i<=alto; i++ ){
            for ( int j=1; j<= ancho; j++){
                CasilleroVista casilleroVista = this.casilleros[i-1][j-1];
                casilleroVista.update();
            }
        }
    }

    public void agregarVista(Node vista){
        this.getChildren().add(vista);
    }

    public void updateVista(Node vista){
        this.getChildren().remove(vista);
        this.getChildren().add(vista);
    }

    public GridPane getGridPane() {
        return this.tableroGui;
    }

}
