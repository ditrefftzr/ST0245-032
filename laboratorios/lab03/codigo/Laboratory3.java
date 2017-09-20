import java.util.*;

/**
 * Class of the Laboratory 3, learning how to work with ArrayLists 
 * and LinkedLists, and to identify the differences between them and the 
 * advantages/weaknesses of each one.
 *
 * @author agusn, ditrefftzr
 */
public class Laboratory3 {
    //Para los calculos de complejidad se utiliza la siguiente notacion:
    //[A|L] <complejidad>, A para arreglos, L para listas, si no hay es genérico.
    
    /**
     * Returns the product of the numbers in the list.
     *
     * @param list - List of integers.
     * @return An integer which is the multiplication of the integers in the
     * array.
     */
    public static int multiply(List<Integer> list) {
        int n = 1;//C

        for (Integer i : list) {//n
            n *= i;
        }

        return n;//C
	//Complejidad O(n), gracias a los iteradores.
    }

    /**
     * Adds a an int to a list of integers if the value doesn´t exist.
     *
     * @param list a list of integers.
     * @param a the int element given to be added.
     */
    public static void smartInsert(List<Integer> list, int a) {
        if (!list.contains(a)) {//n
            list.add(a);//A n L C
        }
	//Complejidad, A O(n + n), L O(n)
	//Para arreglos, O(n)
	//Para listas, O(n)
    }
    
    /**
     * Returns the index of a list where it can be split into half and the
     * values before and after the index will be the closest to one another.
     *
     * @param list the given list to be "balanced".
     * @return the index in which the list is balanced. Notice that it's the
     * limit counting from left to right. eg: [1,2,3,4,5] returns 2.
     * returns -1 for any array of length less than 2. eg: [],[1], they can't be balanced.
     */
    public static int wherePivot(List<Integer> list) {
        int sum1 = 0, sum2 = 0; //C
	
	for(int i: list)//n
	    sum2 += i;
	
        int dif = sum2;//C

	int idx = 0;
	for(int x: list){//n
	    sum2 -= x;//n*C
	    sum1 += x;//n*C
	    int distTemp = Math.abs(sum2 - sum1);//n*C

	    if(distTemp < dif) dif = distTemp;//n*C
	    else break;//n*C
	    idx++;//n*C
	}
	
        return idx - 1;//C
	//Complejidad O(n + n)
	//O(n)
    }
    
    //NEVERAS
    private static class Nevera {
        private final int codigo;
        private final String nombre;
        
        public Nevera(int codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }
        
        @Override
        public String toString() {
            return "(" + codigo + "," + nombre + ")";
        }
    }
    
    private static class Solicitud {
        public final String nombre;
        public final int numNeveras;
        
        private Solicitud(String nombre, int numNeveras) {
            this.nombre = nombre;
            this.numNeveras = numNeveras;
        }
    }
    
    /**
     * Toma cada una de las solicitudes y le asigna el numero de neveras que se
     * pidió hasta que no hayan más neveras o más solicitudes.
     * @param neveras La pila de neveras que hay en el almacén, es decir, en el
     * orden que se hallan desde la puerta.
     * @param solicitudes La cola de clientes, con sus pedidos.
     */
    public static void ejercicio4(Stack<Nevera> neveras, Queue<Solicitud> solicitudes) {
        System.out.print("[\n");//C
	//n -> neveras, m -> solicitudes
        while (!solicitudes.isEmpty()) {//m
            Solicitud sl = solicitudes.poll();//m*C
            int i = sl.numNeveras;//m*C

            System.out.print("(");//m*C
            System.out.print(sl.nombre + ",[");//m*C

            while (i > 0 && !neveras.isEmpty()) {//m*n
                Nevera act = neveras.pop();//m*n*C
                System.out.print(act.toString() + ",");//m*n*C
                i--;//m*n*C
            }

            System.out.print("]),\n");//m*C
        }
        System.out.print("]\n");//C
	//Complejidad O(m*n)
    }
    
    /**
     * Toma cada una de las solicitudes y le asigna el numero de neveras que se
     * pidió hasta que no hayan más neveras o más solicitudes.
     * @param neveras Las neveras que hay en el almacén en el orden que se
     * hallan. La nevera más cercana está al final de la lista.
     * @param solicitudes Una lista con las solicitudes de los clientes, en la
     * última posición va el último que solicitó.
     */
    public static void ejercicio4(List<Nevera> neveras, List<Solicitud> solicitudes) {
        System.out.print("[\n");//C
	//n -> neveras, m-> solicitudes
        while (!solicitudes.isEmpty()) {//m
            Solicitud sl = solicitudes.remove(0);//A m*m L m*C
            int i = sl.numNeveras;//C*m

            System.out.print("(");//C*m
            System.out.print(sl.nombre + ",[");//C*m

            while (i > 0 && !neveras.isEmpty()) {//m*n
                Nevera act = neveras.remove(neveras.size() - 1);//m*n*C
                System.out.print(act.toString() + ",");//m*n*C
                i--;//m*n*C
            }

            System.out.print("]),\n");//m*n
        }
        System.out.print("]\n");//C
	//Complejidad:
	//ArrayList -> O(m*m + m*n)
	//LinkedList -> O(m*n)
    }

    /**
     * Tests the methods.
     * It doesn't have user interaction, but was useful for knowing wether the code works 
     * well or it doesn't.
     *
     * @param args Nothing: No user interaction.
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[]{1, 3, 5, 7}));
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9}));

        // Multiply && wherePivot
        System.out.println("WHEREPIVOT Y MULTIPLY");
        System.out.println(multiply(linked));
        System.out.println(wherePivot(linked));
        System.out.println(multiply(array));
        System.out.println(wherePivot(array));
        
        //Neveras
        System.out.println("NEVERAS");
        Stack<Nevera> neveras = new Stack();
        neveras.push(new Nevera(1,"HACEB"));
        neveras.push(new Nevera(2,"LG"));
        neveras.push(new Nevera(3,"IBM"));
        neveras.push(new Nevera(4,"HACEB"));
        neveras.push(new Nevera(5,"LG"));
        neveras.push(new Nevera(6,"IBM"));
        neveras.push(new Nevera(7,"HACEB"));
        neveras.push(new Nevera(8,"LG"));
        neveras.push(new Nevera(9,"IBM"));
        neveras.push(new Nevera(8,"LG"));
        neveras.push(new Nevera(9,"IBM"));
        Queue<Solicitud> solicitudes = new LinkedList<>();
        solicitudes.add(new Solicitud("EXITO", 1));
        solicitudes.add(new Solicitud("OLIMPICA", 4));
        solicitudes.add(new Solicitud("LA14", 2));
        solicitudes.add(new Solicitud("EAFIT", 10));
        ejercicio4(neveras, solicitudes);
        
        //NEVERAS LIST
        System.out.println("NEVERAS LIST");
        ArrayList<Nevera> nevs = new ArrayList();
        nevs.add(new Nevera(1,"HACEB"));
        nevs.add(new Nevera(2,"LG"));
        nevs.add(new Nevera(3,"IBM"));
        nevs.add(new Nevera(4,"HACEB"));
        nevs.add(new Nevera(5,"LG"));
        nevs.add(new Nevera(6,"IBM"));
        nevs.add(new Nevera(7,"HACEB"));
        nevs.add(new Nevera(8,"LG"));
        nevs.add(new Nevera(9,"IBM"));
        nevs.add(new Nevera(8,"LG"));
        nevs.add(new Nevera(9,"IBM"));
        List<Solicitud> sols = new LinkedList<>();
        sols.add(new Solicitud("EXITO", 1));
        sols.add(new Solicitud("OLIMPICA", 4));
        sols.add(new Solicitud("LA14", 2));
        sols.add(new Solicitud("EAFIT", 10));
        ejercicio4(nevs, sols);
    }
}
