import java.util.*;

class CodeforcesChallenge{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	String s = sc.next();
	int n = sc.nextInt();

	while(n > 0){
	    int l = sc.nextInt() - 1;
	    int r = sc.nextInt() - 1;
	    int count = 0;
	    
	    for(int i=l; i<r; i++)
		if(s.charAt(i) == s.charAt(i+1)) count++;

	    System.out.println(count);
	    
	    n--;
	}
    }
}
