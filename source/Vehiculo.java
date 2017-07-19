package concesionario.source;
import java.util.*;

/*
* @Author: María Queralt Sosa Mompel
*
*/

public class Vehiculo implements Vendible {
    private int PVP;
    private String id, nombre;
    private ArrayList<Extra> extras;
    
    public Vehiculo (String id, String nombre, int PVP) {
        this.id = id;
        this.nombre = nombre;
        this.PVP = PVP;
        extras = new ArrayList<>();
    }   
        
    public String dameId() {
        return id;
    }    
    
    public String dameNombre() {
        return nombre;
    }
    
    public boolean equals(Vehiculo i) {
        return i.dameId().equals(dameId());
    }
    
    public int getPVP() {
        return PVP;
    }
    
    public int damePVP() {
        int count = 0;
        for (Extra i : extras) {
            count += i.damePVP();
        }
        return PVP + count;
    }
    
    public boolean añadeExtra(Extra e) {
        for (Extra i : extras) {
            if (i.equals(e)) {
                return false; 
            }
        }
        extras.add(e);
        return true; 
    }
    
    public boolean quitaExtra(Extra e) {
        for (Extra i : extras) {
            if (i.equals(e)) {
                extras.remove(i);
                return true;
            }
        }
        return false; 
    }
    
    // return true i está contenido
    public boolean estaContenido(Extra e) {
        for (Extra i : extras) {
            if (i.equals(e)) {
                return true;
            }
        }
        return false; 
    }
    


    public Set<Extra> dameExtras() {
        Collections.sort(extras);
        Set<Extra> set = new HashSet<>();
        
        for (Extra i : extras) {
            set.add(i);
        }
        
        return set;
    }
    
    
    public String toString() {
        Collections.sort(extras);
        String result = id + " " + nombre + " " + PVP;
        if (extras.size()!=0) {
            result += "(";
            for (Extra i : extras) {
                result += i.toString() +  ", ";
            }
            String s = result.substring(0, result.length()-2);
            return s + ")";
        } 
        return result;
    }
    
    
}