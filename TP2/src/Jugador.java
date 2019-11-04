import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Unidad> unidades;
    private int puntos;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.unidades = new ArrayList<>(); //Se declara asi para poner cualquier objeto hijo
        this.puntos = 20;
    }

    public void agregarUnidadAJugador(Unidad unidad) {
        this.unidades.add(unidad);
    }

    public int obtenerCantidadUnidades(){
        return this.unidades.size();
    }

    public String obtenerNombre(){
        return nombre;
    }

    public int obtenerPuntos() { return this.puntos; }

    public void ubicarUnidad( Unidad unidad, Casillero casillero) {
        unidad.ubicar(casillero);
    }

    public boolean tieneSuficientesPuntos(Unidad unidad) {
        if (unidad.getCosto() <= this.puntos) {
            return true;
        }
        return false;
    }

    public void comprar(Unidad unidad) throws PuntosInsuficientesException{
        if (tieneSuficientesPuntos(unidad)) {
            unidades.add(unidad);
            this.puntos -= unidad.getCosto();
        }
        else {
            throw new PuntosInsuficientesException();
        }
    }
    public void tratarException(Unidad unidad) {
        try {
            this.comprar(unidad);
        } catch (PuntosInsuficientesException exception) {
            System.out.println(exception.getMensaje());
        }
    }

    public void comprarUnidad(Unidad unidad) {
        tratarException(unidad);
    }
}

