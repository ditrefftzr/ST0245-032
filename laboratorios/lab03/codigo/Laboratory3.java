import java.util.*;

/**
 * @author agusn, ditrefftzr
 */
public class Laboratory3 {

    /**
     * Returns the product of the numbers in the list.
     *
     * @param list - List of integers.
     * @return An integer which is the multiplication of the integers in the
     * array.
     */
    public static int multiply(List<Integer> list) {
        int n = 1;

        for (Integer i : list) {
            n *= i;
        }

        return n;
    }

    /**
     * Adds a an int to a list of integers if the value doesn´t exist.
     *
     * @param list a list of integers.
     * @param a the int element given to be added.
     */
    public static void smartInsert(List<Integer> list, int a) {
        if (!list.contains(a)) {
            list.add(a);
        }
    }

    /**
     * Returns the index of a list where it can be split into half and the
     * values before and after the index will be the closest to one another.
     *
     * @param list the given list to be "balanced".
     * @return the index in which the list is balanced. Notice that it's the
     * limit counting from left to right. eg: [1,2,3,4,5] returns 2.
     */
    public static int wherePivot(List<Integer> list) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < list.size(); i++) {
            sum2 += list.get(i);
        }

        int dif = sum2;//Math.abs(sum2 - sum1);

        int i = list.size() - 1;
        while (i >= 0) {
            sum1 += list.get(i);
            sum2 -= list.get(i);
            int dist = Math.abs(sum2 - sum1);

            if (dist < dif) {
                dif = dist;
            } else {
                return i;
            }

            i--;
        }

        return i;
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
        System.out.print("[\n");

        while (!solicitudes.isEmpty()) {
            Solicitud sl = solicitudes.poll();
            int i = sl.numNeveras;

            System.out.print("(");
            System.out.print(sl.nombre + ",[");

            while (i > 0 && !neveras.isEmpty()) {
                Nevera act = neveras.pop();
                System.out.print(act.toString() + ",");
                i--;
            }

            System.out.print("]),\n");
        }
        System.out.print("]\n");
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
        System.out.print("[\n");

        while (!solicitudes.isEmpty()) {
            Solicitud sl = solicitudes.remove(0);
            int i = sl.numNeveras;

            System.out.print("(");
            System.out.print(sl.nombre + ",[");

            while (i > 0 && !neveras.isEmpty()) {
                Nevera act = neveras.remove(neveras.size() - 1);
                System.out.print(act.toString() + ",");
                i--;
            }

            System.out.print("]),\n");
        }
        System.out.print("]\n");
    }

    /**
     * Tests the methods.
     *
     * @param args Nothing.
     */
    public static void main(String[] args) {
        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[]{1, 3, 5, 7}));
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[]{2, 4, 6, 8}));

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
