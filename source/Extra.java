package concesionario.source;
/*
* @Author: María Queralt Sosa Mompel
*
*/


public class Extra implements Vendible, Comparable<Extra> {
    private String id, nombre;
    private int PVP;
    
    public Extra(String id, String nombre, int PVP) {
        this.id = id;
        this.nombre = nombre;
        this.PVP = PVP;
    }
    
    public String dameId() {
        return id;
    }
    
    public String dameNombre() {
        return nombre;
    }
    
    public int damePVP() {
        return PVP;
    }
    
    
    public String toString() {
        return dameId() + " " + dameNombre() + " " + damePVP();
    }
    
    public int compareTo(Extra e) {
        if (e.damePVP()<damePVP()) {
            return -1;
        } else if (e.damePVP()>damePVP()) {
            return 1;
        } 
        
        
        if(e.dameId().compareTo(dameId())<0) {
            return 1;
        } else if (e.dameId().compareTo(dameId()) > 0) {
            return -1;
        }
        
        return 0;
    }
    
    public boolean equals(Extra i) {
        return i.dameId().equals(dameId());
    }
        

}