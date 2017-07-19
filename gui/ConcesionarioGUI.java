package concesionario.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase ConcesionarioGUI que representa la ventana principal del concesionario
 */
public class ConcesionarioGUI extends JFrame {
    // Panel principal de la ventana principal
    private Container contentPane;

    // Componentes visuales de la ventana principal
    private static JTextArea lista;
    private JButton otro;
    
    private JButton addExtra = new JButton("Añadir Extra");

    // Atributo que representa las ventas realizadas 
    private static Ventas ventas;
    
    public static Ventas getVentas() {
        return ventas;
    }
    
    public static JTextArea getLista(){
        return lista;
    }
    
    /**
     * Constructor de la ventana principal al que se le pasa 
     * el título de la aplicación
     * 
     * @param t título de la aplicación
     */ 
    public ConcesionarioGUI(String t){
        // Se inicializan las opciones de la ventana de la aplicación
        super(t);
        initVentas();
        contentPane = getContentPane();
        lista = new JTextArea(20,40);
        otro = new JButton("Añadir vehículo");
        contentPane.add(new JScrollPane(lista),BorderLayout.CENTER);
        JPanel rellenoBotón = new JPanel();
        rellenoBotón.setLayout(new GridLayout(5,1));
        JPanel aux1 = new JPanel();
        aux1.add(otro, BorderLayout.CENTER);
        rellenoBotón.add(aux1);

        JPanel aux2 = new JPanel();
        aux2.add(addExtra, BorderLayout.CENTER);
        rellenoBotón.add(aux2);
        
        otro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DialogoVehiculo(new JFrame());
            }
        });
        
        addExtra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new DialogoExtra(new JFrame());
            }
        });
        
        
       
       
       
       
        contentPane.add(rellenoBotón,BorderLayout.EAST);
        lista.setEditable(false);
        lista.setText(ventas.toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicializa el concesionario con varias ventas realizadas de vehículos y extras
     */ 
    private void initVentas(){
        ventas = new Ventas();
        Extra pinturaMetalizada = new Extra ("pm", "Pintura metalizada", 450);
        Extra aABizona = new Extra ("acb", "Aire acondicionadao bizona", 650);
        Extra cincoPuertas = new Extra ("5p", "Cinco puertas", 350);
        Extra llantasAleacion = new Extra ("lal", "Llantas aleación ligera", 750);
        Vehiculo base = new Vehiculo("vb","Vehículo base",8000);
        Vehiculo ls = new Vehiculo("vls","Vehículo normal",12000);
        Vehiculo lx = new Vehiculo("vlx","Vehículo lujo",28000);
        ls.añadeExtra(cincoPuertas);
        ls.añadeExtra(pinturaMetalizada);
        lx.añadeExtra(cincoPuertas);
        lx.añadeExtra(aABizona);
        lx.añadeExtra(llantasAleacion);
        lx.añadeExtra(pinturaMetalizada);
        ventas.añadeVenta(base);
        ventas.añadeVenta(ls);
        ventas.añadeVenta(llantasAleacion);
        ventas.añadeVenta(base);
        ventas.añadeVenta(aABizona);
        ventas.añadeVenta(lx);
    }

    
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception e){
            
        }
        new ConcesionarioGUI("Concesionario de vehículos");
    }
}
