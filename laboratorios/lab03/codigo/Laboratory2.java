import java.util.*;

public class Laboratory2 {
    

    /**
     * Returns the product of the numbers in the list. 
     * @param list - List of integers.
     * @return An integer.
     */
    public static int multiply(List<Integer> list) {
	int n = 1;
	for(Integer i: list)
	    n*=i;
	return n;
    }

    public static void smartInsert(List<Integer> list, int a){
	if(!list.contains(a)){
	    list.add(a);
	}
    }

    public static int wherePivot(List<Integer> list){
	int sum1 = 0, sum2 = 0;

	for(int i=0; i<list.size(); i++)
	    sum2 += list.get(i);
	
	int dif = sum2;//Math.abs(sum2 - sum1);

	int i = list.size()-1;
	while(i >= 0){
	    sum1 += list.get(i);
	    sum2 -= list.get(i);
	    int dist = Math.abs(sum2-sum1);

	    if(dist < dif) dif = dist;
	    else return i;

	    i--;
	}
	
	return i;
    }

    
    
    /**
     * Tests the methods.
     * @param args
     */
    public static void main(String[] args) {
	LinkedList<Integer> linked = new LinkedList<>();
	linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));
	ArrayList<Integer> array = new ArrayList<>();
	array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));
	
	// Multiply
	System.out.println(multiply(linked));
	System.out.println(multiply(array));
	System.out.println(wherePivot(linked));
    }
}
