import java.util.*;

public class Pedrito{
    public static void main(String[] args){
	HashTable<String, String> tb = new HashTable<>();
	tb.add("Google", "Estados Unidos");
	tb.add("La locura", "Colombia");
	tb.add("Nokia", "Finlandia");
	tb.add("Sony","Japon");
	System.out.println("Google está: " + (tb.get("Google") != null));
	System.out.println("Pais de Motorola: " + tb.get("Motorola"));

	ArrayList<String> keys = tb.getKeys();
	boolean hayIndia = false;
	boolean hayEstadosUnidos = false;
	for(String str: keys){
	    if(!hayIndia)
		if(tb.get(str).equals("India")) hayIndia = true;
	    if(!hayEstadosUnidos)
		if(tb.get(str).equals("Estados Unidos")) hayEstadosUnidos = true;
	    if(hayIndia && hayEstadosUnidos) break;	
	}
	
	System.out.println("Hay India: " + (hayIndia));
	System.out.println("Hay Estados Unidos: " + (hayEstadosUnidos));
    }
}
