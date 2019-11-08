import org.junit.*;

/*
   Al ser abstracta, tenemos que usar un objeto
   tipo mock, no heredados de unidad.
 */
public class UnidadTest {
    private Unidad prueba;

    @Before
    public void setUp() {
        prueba = new SoldadoDeInfanteria();
    }

    @After
    public void tearDown() {
        prueba = null;
    }

    @Test
    public void unidadRecibeDanioYActualizaVida(){
        prueba.recibirDaño(20);
        Assert.assertEquals(80, prueba.obtenerVida(), 0.01); //Delta agregado para comparar flotantes, doubles

    }

    /*@Test
    public void unidadSePuedeUbicarEnCasilleroDesocupado(){
        Casillero unCasillero = new Casillero();
        prueba.ubicar(unCasillero);
        Assert.assertTrue(unCasillero.estaOcupado());
    }

    //Lanzar excepcion si casillero ocupado
    @Test
    public void unidadNoPuedeUbicarseEnCasilleroOcupado(){
        Casillero unCasillero = new Casillero();
        Unidad otraUnidad = new Catapulta();
        prueba.ubicar(unCasillero);
        otraUnidad.ubicar(unCasillero);
    }*/

    @Test
    public void SoldadoAtacaEnemigo(){
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        soldado.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==90);
        Assert.assertTrue(soldado.obtenerVida()==100);
    }

    @Test
    public void CatapultaAtacaEnemigo(){
        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        catapulta.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }

    @Test
    public void CatapultaAtacaVariosEnemigosContiguos()throws CasilleroInvalidoException, CasilleroOcupadoException{
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(14,14);
        Coordenada coordenadaCurandero = new Coordenada(14,15);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaSoldado = new Coordenada(15,15);
        Coordenada coordenadaJinete2 = new Coordenada(16,16);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);

        catapulta.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(soldado.obtenerVida()==80);
        Assert.assertTrue(curandero.obtenerVida()==55);
        Assert.assertTrue(jinete2.obtenerVida()==80);
        Assert.assertTrue(catapulta.obtenerVida()==50);

        catapulta.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==60);
        Assert.assertTrue(soldado.obtenerVida()==60);
        Assert.assertTrue(curandero.obtenerVida()==35);
        Assert.assertTrue(jinete2.obtenerVida()==60);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }

    @Test
    public void CataputalAtacaUnidadesEnLineaRecta()throws CasilleroInvalidoException, CasilleroOcupadoException{
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Curandero curandero2 = new Curandero();
        Catapulta catapulta = new Catapulta();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(14,14);
        Coordenada coordenadaCurandero = new Coordenada(15,14);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaSoldado = new Coordenada(16,14);
        Coordenada coordenadaJinete2 = new Coordenada(17,14);
        Coordenada coordenadaCurandero2 = new Coordenada(18,14);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(curandero2, coordenadaCurandero2);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);
        catapulta.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(soldado.obtenerVida()==80);
        Assert.assertTrue(curandero.obtenerVida()==55);
        Assert.assertTrue(curandero2.obtenerVida()==55);
        Assert.assertTrue(jinete2.obtenerVida()==80);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }

    @Test
    public void CatapultaAtacaYNoDaniaAEnemigosNoContiguos()throws CasilleroInvalidoException, CasilleroOcupadoException {
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        Jinete jinete2 = new Jinete();
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        Coordenada coordenadaJinete = new Coordenada(14,14);
        Coordenada coordenadaCurandero = new Coordenada(14,15);
        Coordenada coordenadaCatapulta = new Coordenada(1,1);
        Coordenada coordenadaJinete2 = new Coordenada(18,18);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        tablero.ubicarUnidad(catapulta, coordenadaCatapulta);
        tablero.ubicarUnidad(jinete2, coordenadaJinete2);

        catapulta.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==80);
        Assert.assertTrue(curandero.obtenerVida()==55);
        Assert.assertTrue(jinete2.obtenerVida()==100);
        Assert.assertTrue(catapulta.obtenerVida()==50);
    }


        @Test
    public void curanderoCuraAUnidadAliada(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Assert.assertTrue(jinete.obtenerVida()==100);
        jinete.recibirDaño(50);
        Assert.assertTrue(jinete.obtenerVida()==50);
        curandero.realizarAccion(jinete);
        Assert.assertTrue(jinete.obtenerVida()==65);

    }

    @Test
    public void jineteAtacaEnemigo()throws CasilleroInvalidoException, CasilleroOcupadoException{
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Curandero curandero = new Curandero();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(11,11);
        Coordenada coordenadaCurandero = new Coordenada(13,13);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        tablero.ubicarUnidad(curandero, coordenadaCurandero);
        jinete.realizarAccion(soldado);
        jinete.realizarAccion(curandero);
        Assert.assertTrue(soldado.obtenerVida()==95);
        Assert.assertTrue(curandero.obtenerVida()==60);
    }

    @Test
    public void jineteFallaAlAtacarEnemigo()throws CasilleroInvalidoException, CasilleroOcupadoException{
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        Coordenada coordenadaJinete = new Coordenada(9,9);
        Coordenada coordenadaSoldado = new Coordenada(11,18);
        tablero.ubicarUnidad(jinete, coordenadaJinete);
        tablero.ubicarUnidad(soldado, coordenadaSoldado);
        jinete.realizarAccion(soldado);
        Assert.assertTrue(soldado.obtenerVida()==100);
    }


    /*@Test
    public void unidadSeUbicaEnCoordenadaCorrespondiente(){
        Curandero curandero = new Curandero();
    }*/

}