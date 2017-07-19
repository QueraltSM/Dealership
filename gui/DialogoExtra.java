package concesionario.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
* @Author: María Queralt Sosa Mompel
*
*/

public class DialogoExtra extends JDialog {
    private JPanel p = new JPanel();
    private JTextField nombre = new JTextField(10);
    private JTextField id = new JTextField(10);
    private JTextField PVP = new JTextField(10);
    private JTextField idVehiculo = new JTextField(10);
    
    private JButton add = new JButton("Añadir");
    private JButton cancel = new JButton("Cancelar");
    
    public DialogoExtra(JFrame f) {
        super(f, "Añadir Extra");
        p.setLayout(new GridLayout(5,1));
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(new JLabel("Introduzca nombre: "));
        p1.add(nombre, BorderLayout.CENTER);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("Introduzca id: "));
        p2.add(id, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(new JLabel("Introduzca PVP: "));
        p3.add(PVP, BorderLayout.CENTER);
        
        JPanel p5 = new JPanel();
        p5.setLayout(new FlowLayout());
        p5.add(new JLabel("Introduzca id del vehiculo: "));
        p5.add(idVehiculo, BorderLayout.CENTER);
        
        JPanel p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(add);
        
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                for (Vendible i : ConcesionarioGUI.getVentas().listaVentas()) {
                    if (i instanceof Vehiculo) {  
                        if (i.dameId().equals(idVehiculo.getText())) {
                            ((Vehiculo)i).añadeExtra(new Extra(id.getText(), nombre.getText(),
                                Integer.parseInt(PVP.getText())));
                        }
                    }
                }
                        
                ConcesionarioGUI.getLista().setText("");
                ConcesionarioGUI.getLista().setText(ConcesionarioGUI.getVentas()
                    .toString());
                dispose();
            }
        });
        
        
        p4.add(cancel);
        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                id.setText("");
                nombre.setText("");
                PVP.setText("");
                idVehiculo.setText("");
            }
        });
        
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p5);
        p.add(p4);
        
        add(p);
        
        setSize(350, 450);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
}