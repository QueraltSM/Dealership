package concesionario.test;
import concesionario.source.*;
import org.junit.*;
import static org.junit.Assert.*;

/*
* @Author: María Queralt Sosa Mompel
*
*/

public class ConcesionarioTest {
    private static Vehiculo base;
    private static Extra cincoPuertas;
    private static Extra pinturaMetalizada;
    private static Extra llantasAleacion;
    
    @Before 
    public void init() {
        base = new Vehiculo("vb","Vehículo base",8000);
        cincoPuertas = new Extra ("5p", "Cinco puertas", 350);
        pinturaMetalizada = new Extra ("pm", "Pintura metalizada", 450);
        llantasAleacion = new Extra ("lal", "Llantas aleación ligera", 750);
    }
    
    @After
    public void finalization() {
        System.out.println("Test was successful.");
    }
    
    
    // int damePVP();
    @Test
    public void test1() {
        base.añadeExtra(cincoPuertas);
        assertTrue(base.damePVP() == (8000 + 350));
        base.añadeExtra(cincoPuertas);
        assertTrue(base.damePVP() == (8000 + 350));
    }
    
    // boolean estaContenido(Extra)
    @Test
    public void test2() {
        assertFalse(base.estaContenido(cincoPuertas));
        base.añadeExtra(cincoPuertas);
        assertTrue(base.estaContenido(cincoPuertas));
    }
    
    // boolean añadeExtra(Extra)
    @Test
    public void test3 () {
        base.añadeExtra(cincoPuertas);
        base.añadeExtra(pinturaMetalizada);
        String s = base.dameId() + " " + base.dameNombre() + " " + base.getPVP();
        assertEquals(base.toString(), s + "(" + pinturaMetalizada.toString() + ", "
            + cincoPuertas.toString() + ")");
    }
    
    // boolean quitaExtra(Extra)
    public void test4 () {
        base.añadeExtra(cincoPuertas);
        base.añadeExtra(pinturaMetalizada);
        assertFalse(base.quitaExtra(llantasAleacion));
        assertTrue(base.quitaExtra(cincoPuertas));
    }
    
}