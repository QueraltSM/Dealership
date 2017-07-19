import concesionario.source.*;

public class Concesionario {
    public static void main(String[] args){
// DESCOMENTAR EL SIGUIENTE CÓDIGO PARA USAR LAS CLASES: Extra, Vehiculo y Ventas
        Extra pinturaMetalizada = new Extra ("pm", "Pintura metalizada", 450);
        Extra aABizona = new Extra ("acb", "Aire acondicionadao bizona", 650);
        Extra cincoPuertas = new Extra ("5p", "Cinco puertas", 350);
        Extra llantasAleacion = new Extra ("lal", "Llantas aleación ligera", 750);
        Vehiculo base= new Vehiculo("vb","Vehículo base",8000);
        Vehiculo ls= new Vehiculo("vls","Vehículo normal",12000);
        Vehiculo lx= new Vehiculo("vlx","Vehículo lujo",28000);
        ls.añadeExtra(cincoPuertas);
        ls.añadeExtra(pinturaMetalizada);
        lx.añadeExtra(cincoPuertas);
        lx.añadeExtra(aABizona);
        lx.añadeExtra(llantasAleacion);
        lx.añadeExtra(pinturaMetalizada);
        Ventas v=new Ventas();
        v.añadeVenta(base);
        v.añadeVenta(ls);
        v.añadeVenta(ls);
        v.añadeVenta(llantasAleacion);
        v.añadeVenta(base);
        v.añadeVenta(aABizona);
        v.añadeVenta(lx);

// RESULTADO MOSTRADO EN CONSOLA:
// 1) vb Vehículo base 8000                                                        
// 2) vls Vehículo normal 12000 (pm Pintura metalizada 450, 5p Cinco puertas 350)   
// 3) lal Llantas aleación ligera 750                                              
// 4) vb Vehículo base 8000                                                        
// 5) acb Aire acondicionadao bizona 650                                           
// 6) vlx Vehículo lujo 28000 (lal Llantas aleación ligera 750, pm Pintura metalizada 450, 5p Cinco puertas 350, acb Aire acondicionadao bizona 650)

// DESCOMENTAR LA SIGUIENTE LÍNEA PARA EJECUTAR LOS TEST
       org.junit.runner.JUnitCore.main("concesionario.test.ConcesionarioTest");
    }
}
