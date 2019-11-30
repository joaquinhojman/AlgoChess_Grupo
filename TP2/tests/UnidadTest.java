import Excepciones.AccionInvalidaException;
import Excepciones.BatallonInvalidoException;
import Excepciones.CasilleroInvalidoException;
import Excepciones.CasilleroOcupadoException;
import Tablero.Coordenada;
import Tablero.Direccion;
import Tablero.Tablero;
import Unidades.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

//Al ser abstracta, tenemos que usar un objeto tipo mock, no heredados de unidad.


public class UnidadTest {
    private Unidad prueba;
    private Tablero tablero = new Tablero();

    @Before
    public void setUp() {
        prueba = new SoldadoDeInfanteria();
    }

    @After
    public void tearDown() {
        prueba = null;
    }

    @Test
    public void unidadRecibeDanioYActualizaVida() {
        prueba.recibirDanio(20, tablero);
        Assert.assertEquals(80, prueba.obtenerVida(), 0.01); //Delta agregado para comparar flotantes, doubles
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
    }

    @Test
    public void SoldadoAtacaEnemigo() throws CasilleroInvalidoException, CasilleroOcupadoException {
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Jinete jinete = new Jinete();
        Coordenada coordenadajinete = new Coordenada(2,3);
        Coordenada coordenadasoldado = new Coordenada(2,4);
        tablero.ubicarUnidad(jinete, coordenadajinete);
        tablero.ubicarUnidad(soldado, coordenadasoldado);
        Assert.assertTrue(jinete.obtenerVida() == 100);
        soldado.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 90);
        Assert.assertTrue(soldado.obtenerVida() == 100);
    }

    @Test
    public void CatapultaAtacaEnemigo() throws CasilleroOcupadoException, CasilleroInvalidoException {
        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        Coordenada coordJinete = new Coordenada(9,5);
        tablero.ubicarUnidad(jinete, coordJinete);
        Assert.assertTrue(jinete.obtenerVida() == 100);
        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 80);
        Assert.assertTrue(catapulta.obtenerVida() == 50);
    }

   /* @Test
    public void CatapultaAtacaVariosEnemigosContiguos() throws CasilleroInvalidoException, CasilleroOcupadoException {
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(8,8);
        Coordenada coordenadaCurandero = new Coordenada(8,9);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaSoldado = new Coordenada(9,9);
        Coordenada coordenadaJinete2 = new Coordenada(2,2);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);

        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 80);
        Assert.assertTrue(soldado.obtenerVida() == 80);
        Assert.assertTrue(curandero.obtenerVida() == 55);
        Assert.assertTrue(jinete2.obtenerVida() == 80);
        Assert.assertTrue(catapulta.obtenerVida() == 50);

        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 60);
        Assert.assertTrue(soldado.obtenerVida() == 60);
        Assert.assertTrue(curandero.obtenerVida() == 35);
        Assert.assertTrue(jinete2.obtenerVida() == 60);
        Assert.assertTrue(catapulta.obtenerVida() == 50);
    }*/

  /*  @Test
    public void CataputalAtacaUnidadesEnLineaRecta() throws CasilleroInvalidoException, CasilleroOcupadoException {
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Curandero curandero2 = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(7,7);
        Coordenada coordenadaCurandero = new Coordenada(8,7);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaSoldado = new Coordenada(9,7);
        Coordenada coordenadaJinete2 = new Coordenada(9,8);
        Coordenada coordenadaCurandero2 = new Coordenada(5,5);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(curandero2, coordenadaCurandero2);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);
        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 80);
        Assert.assertTrue(soldado.obtenerVida() == 80);
        Assert.assertTrue(curandero.obtenerVida() == 55);
        Assert.assertTrue(curandero2.obtenerVida() == 55);
        Assert.assertTrue(jinete2.obtenerVida() == 80);
        Assert.assertTrue(catapulta.obtenerVida() == 50);
    }*/

   /* @Test
    public void CatapultaAtacaYNoDaniaAEnemigosNoContiguos() throws CasilleroInvalidoException, CasilleroOcupadoException {
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Coordenada coordenadaJinete = new Coordenada(9,8);
        Coordenada coordenadaCurandero = new Coordenada(9,9);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaJinete2 = new Coordenada(8,8);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);

        catapulta.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 80);
        Assert.assertTrue(curandero.obtenerVida() == 55);
        Assert.assertTrue(jinete2.obtenerVida() == 100);
        Assert.assertTrue(catapulta.obtenerVida() == 50);
    }*/

    @Test
    public void curanderoCuraAUnidadAliada() {
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida() == 100);
        jinete.recibirDanio(50, tablero);
        Assert.assertTrue(jinete.obtenerVida() == 50);
        curandero.realizarAccion(jinete, tablero, null);
        Assert.assertTrue(jinete.obtenerVida() == 65);
    }

   /* @Test
    public void jineteAtacaEnemigoADistanciaMediaConArcoYFlecha() throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException {
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(8,8);
        Coordenada coordenadaCurandero = new Coordenada(3,3);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        unidadesAliadas.add(soldado);
        unidadesAliadas.add(jinete);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        jinete.realizarAccion(curandero, tablero, unidadesAliadas);
        Assert.assertTrue(curandero.obtenerVida() == 60);
    }*/

   /* @Test
    public void jineteAtacaAUnidadEnemigaCercanaConEspada() throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException {
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(11,11);
        Coordenada coordenadaCurandero = new Coordenada(13,13);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        unidadesAliadas.add(curandero);
        unidadesAliadas.add(jinete);
        jinete.realizarAccion(soldado, tablero, unidadesAliadas);
        Assert.assertTrue(soldado.obtenerVida() == 95);
    }*/

    /*@Test(expected = AccionInvalidaException.class)
    public void jineteFallaAlAtacarEnemigoLejano() throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException {
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(7,6);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        jinete.realizarAccion(soldado, tablero, unidadesAliadas);
        Assert.fail();
    }*/

   /* @Test(expected = AccionInvalidaException.class)
    public void jineteFallaAlAtacarEnemigoCercanoTeniendoAliadosCerca() throws CasilleroInvalidoException, CasilleroOcupadoException, AccionInvalidaException {
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Catapulta catapulta = new Catapulta();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(9,8);
        Coordenada coordenadaCatapulta = new Coordenada(7,7);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        ArrayList<Unidad> unidadesAliadas = new ArrayList<>();
        unidadesAliadas.add(catapulta);
        jinete.realizarAccion(soldado, tablero, unidadesAliadas);
        Assert.fail();
    }*/

    @Test
    public void batallonSeMueveCorrectamente() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        Coordenada coordenadaDestino1 = new Coordenada(5, 5);
        Coordenada coordenadaDestino2 = new Coordenada(5, 6);
        Coordenada coordenadaDestino3 = new Coordenada(5, 7);
        tablero.ubicarUnidad(soldado1, coordenada1);
        tablero.ubicarUnidad(soldado2, coordenada2);
        tablero.ubicarUnidad(soldado3, coordenada3);
        Batallon batallon = new Batallon(soldado1, soldado2, soldado3);
        batallon.mover(tablero, Direccion.ABAJO);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteEnElLimite() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(1, 2);
        Coordenada coordenada3 = new Coordenada(1, 3);
        Coordenada coordenadaDestino1 = new Coordenada(2, 1);
        Coordenada coordenadaDestino2 = new Coordenada(2, 2);
        Coordenada coordenadaDestino3 = new Coordenada(2, 3);
        tablero.ubicarUnidad(soldado1, coordenada1);
        tablero.ubicarUnidad(soldado2, coordenada2);
        tablero.ubicarUnidad(soldado3, coordenada3);
        Batallon batallon = new Batallon(soldado1, soldado2, soldado3);
        batallon.mover(tablero, Direccion.ABAJO);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteSiSeMueveElDeUnaPunta() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(1, 2);
        Coordenada coordenada3 = new Coordenada(2, 2);
        Coordenada coordenadaDestino1 = new Coordenada(2, 1);
        Coordenada coordenadaDestino2 = new Coordenada(2, 2);
        Coordenada coordenadaDestino3 = new Coordenada(3, 2);
        tablero.ubicarUnidad(soldado1, coordenada1);
        tablero.ubicarUnidad(soldado2, coordenada2);
        tablero.ubicarUnidad(soldado3, coordenada3);
        Batallon batallon = new Batallon(soldado1, soldado2, soldado3);
        batallon.mover(tablero, Direccion.ABAJO);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonSeMueveCorrectamenteConObstaculo() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(1, 2);
        Coordenada coordenada3 = new Coordenada(1, 3);
        Coordenada coordenada4 = new Coordenada(2, 2);
        Coordenada coordenadaDestino1 = new Coordenada(2, 1);
        Coordenada coordenadaDestino3 = new Coordenada(2, 3);
        tablero.ubicarUnidad(soldado1, coordenada1);
        tablero.ubicarUnidad(soldado2, coordenada2);
        tablero.ubicarUnidad(soldado3, coordenada3);
        tablero.ubicarUnidad(curandero, coordenada4);
        Batallon batallon = new Batallon(soldado1, soldado2, soldado3);
        batallon.mover(tablero, Direccion.ABAJO);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(tablero.obtenerCasillero(coordenada2).obtenerUnidad(), soldado2);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
    }

    @Test
    public void batallonHabiendoCuatroSoldadosSeMuevenTres() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado4 = new SoldadoDeInfanteria();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        Coordenada coordenada4 = new Coordenada(4, 8);
        Coordenada coordenadaDestino1 = new Coordenada(5, 5);
        Coordenada coordenadaDestino2 = new Coordenada(5, 6);
        Coordenada coordenadaDestino3 = new Coordenada(5, 7);
        tablero.ubicarUnidad(soldado1, coordenada1);
        tablero.ubicarUnidad(soldado2, coordenada2);
        tablero.ubicarUnidad(soldado3, coordenada3);
        tablero.ubicarUnidad(soldado4, coordenada4);
        Batallon batallon = new Batallon(soldado1, soldado2, soldado3);
        batallon.mover(tablero, Direccion.ABAJO);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino1).obtenerUnidad(), soldado1);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino2).obtenerUnidad(), soldado2);
        Assert.assertEquals(tablero.obtenerCasillero(coordenadaDestino3).obtenerUnidad(), soldado3);
        Assert.assertEquals(tablero.obtenerCasillero(coordenada4).obtenerUnidad(), soldado4);
    }

    @Test
    public void batallonEnLineaRectaConObstaculoNoSeMueve() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException {
        SoldadoDeInfanteria soldado1 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado2 = new SoldadoDeInfanteria();
        SoldadoDeInfanteria soldado3 = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        Coordenada coordenadaCurandero = new Coordenada(4, 8);
        tablero.ubicarUnidad(soldado1, coordenada1);
        tablero.ubicarUnidad(soldado2, coordenada2);
        tablero.ubicarUnidad(soldado3, coordenada3);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        Batallon batallon = new Batallon(soldado1, soldado2, soldado3);
        batallon.mover(tablero, Direccion.DERECHA);
        Assert.assertEquals(tablero.obtenerCasillero(coordenada1).obtenerUnidad(), soldado1);
        Assert.assertEquals(tablero.obtenerCasillero(coordenada2).obtenerUnidad(), soldado2);
        Assert.assertEquals(tablero.obtenerCasillero(coordenada3).obtenerUnidad(), soldado3);
    }

    @Test(expected = BatallonInvalidoException.class)
    public void noSePuedeArmarBatallonConUnidadesQueNoSeanSoldado() throws CasilleroOcupadoException, CasilleroInvalidoException, BatallonInvalidoException{
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Coordenada coordenada1 = new Coordenada(4, 5);
        Coordenada coordenada2 = new Coordenada(4, 6);
        Coordenada coordenada3 = new Coordenada(4, 7);
        tablero.ubicarUnidad(curandero, coordenada1);
        tablero.ubicarUnidad(jinete, coordenada2);
        tablero.ubicarUnidad(jinete2, coordenada3);
        Batallon batallon = new Batallon(curandero, jinete, jinete2);
        Assert.fail();
    }
}