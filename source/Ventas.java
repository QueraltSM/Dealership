package concesionario.source;
import java.util.*;

/*
* @Author: María Queralt Sosa Mompel
*
*/

public class Ventas {
    private ArrayList<Vendible> ventas = new ArrayList<>();
    
    public void añadeVenta(Vendible v) {
        ventas.add(v);   
    }
    
    public int totalVentas() {
        int count = 0;
        for (Vendible i : ventas) {
            count += i.damePVP();
        }
        return count;
    }
    
    public List<Vendible> listaVentas() {
        return ventas;
    }
    
    public String masVendido() {
        int count = 0;
        Map<Vendible, Integer> mapa = new HashMap<>();
        
        for (Vendible i : ventas) {
            if (mapa.get(i) == null) {
                mapa.put(i, 1);
            } else {
                mapa.put(i, mapa.get(i)+1);
            }
        }
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Map.Entry<Vendible, Integer> entry : mapa.entrySet()) {
            numbers.add(entry.getValue());
        }
        
        Collections.sort(numbers);
        Collections.reverse(numbers);
        
        for (Integer j : numbers) {
            for (Map.Entry<Vendible, Integer> entries : mapa.entrySet()) {
                if (entries.getValue() == j) {
                    return entries.getKey().dameId();
                }
            }
        }
        return null;
    }
    
    public String toString() {
        String result = "";
        int count = 1;
        for (Vendible i : ventas) {
            result += count + ") " + i.toString() + "\n";
            count++;
        }
        return result;
    }
}