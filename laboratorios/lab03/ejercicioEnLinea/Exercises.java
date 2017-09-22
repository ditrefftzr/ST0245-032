import java.util.*;
import java.io.*;

public class Exercises{
    //EL EJERCICIO DEL TECLADO (2.1)
    public static LinkedList<StringBuilder> brokenKeyboard(String input) {
        LinkedList<StringBuilder> list = new LinkedList<>();//C

        boolean atFirst = true;//C
        StringBuilder sb = new StringBuilder();//C

        int i = 0;//C
        while (i < input.length()) {//n
            if (!isBracket(input.charAt(i))){//n*C
                sb.append(input.charAt(i));//n*C
            } else {
                add(sb, list, atFirst);//n*C
                sb = new StringBuilder();//n*C
                atFirst = input.charAt(i) == '[';//n*C
            }
            
            i++;//n*C
        }
        
        if(sb.length() > 0) add(sb, list, atFirst);//C
        return list;//C
        //Complejidad O(n)
    }
    
    private static void add(StringBuilder sb,
			    LinkedList<StringBuilder> list, boolean atFirst){//O(1)
        if (atFirst) list.addFirst(sb);
        else list.addLast(sb);
    }
    
    private static boolean isBracket(char o) {//O(1)
        return o == '[' || o == ']';
    }

    public static void testKeyboard() throws IOException{
	//Este es el metodo que pasa en el juez, sin embargo, para el input usual no sirve.
	//Por eso, en el main usaremos testKeyboard2()
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
	String s;
	while ((s = br.readLine()) != null && !s.equals("")) {
	    brokenKeyboard(s).forEach((str) -> {
		    pw.print(str);
	    });
	    pw.println();
	    pw.flush();
	}
	pw.close();
    }

    public static void testKeyboard2(){
	Scanner sc = new Scanner(System.in);
	String str;
	while(!(str = sc.nextLine()).equals("")){
	    brokenKeyboard(str).forEach((s) -> {
		    System.out.print(s);
		});
	    System.out.println();
	}
    }
    
    //EL EJERCICIO DE CODEFORCES
     public static void queries() {
        int li = 0;
        int ri = 0;
        Scanner input = new Scanner(System.in);
        String s = input.next();
        // Create acum array
        int acum = 0;
        int [] acumArray = new int[s.length()];
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                acum++;
            }
            acumArray[i+1] = acum;
        }
        System.out.println(Arrays.toString(acumArray));
        int m = input.nextInt();
        for(int i = 1; i <= m; i++) {
            li = input.nextInt();
            ri = input.nextInt();
            int dif = acumArray[ri-1] - acumArray[li-1];
            System.out.println(dif);
        }
    }
    
    public static void main(String [] args) {
        queries2();
    }
}

    
    public static void main(String[] args) throws IOException{
        System.out.println("PRUEBA BROKENKEYBOARD");
	testKeyboard2();
	System.out.println("PRUEBA CODEFORCES");
	queries();
    }
}
