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
    public static void codeForcesChallenge(){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

	int[] acum = new int[s.length()];
        acum[0] = 0;
        for(int i=1; i<acum.length; i++){
	    acum[i] = acum[i-1];
	    if(s.charAt(i) == s.charAt(i-1))
		acum[i]++;
	}

	// for(int i: acum)
	//     System.out.print(i);

        int n = sc.nextInt();

        while(n > 0){
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;

            System.out.println(acum[r] - acum[l]);
            n--;
        }
    }
    
    public static void main(String[] args) throws IOException{
        System.out.println("PRUEBA BROKENKEYBOARD");
	testKeyboard2();
	System.out.println("PRUEBA CODEFORCES");
	codeForcesChallenge();
    }
}
