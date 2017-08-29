/**
 * 
 * @author anietog1, ditrefftzr
 */
public class Recursion1 {
    public int triangle(int rows) {
        if (rows == 0) return 0; //C
        return rows + triangle(rows - 1); //C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA: 
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }
    
    public boolean nestParen(String str) {
        if (str.length() % 2 != 0) return false; //C
        
        if (str.equals("")) return true; //C
        
        boolean isClosed = str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')'; //C
        
        if (isClosed == false) return false; //C
        
        if (str.length() == 2) return isClosed; //C
        
        return isClosed && nestParen(str.substring(1, str.length() - 1)); //C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA: 
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }
    
    public int count11(String str) {
        if (str.length() < 2) return 0; //C
        
        if (str.substring(0, 2).equals("11")) //C
            return 1 + count11(str.substring(2)); //C + T(n-1)
        
        return count11(str.substring(1)); //C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA: 
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }
    
    public String endX(String str) {
        return endXAux(str, str.length() - 1);
    }
    
    private String endXAux(String str, int start) {
        if (start < 0) return str; //C
        
        if (str.charAt(start) == 'x') //C
            str = str.substring(0, start) + str.substring(start + 1) + 'x'; //C
        
        return endXAux(str, start - 1);//C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA: 
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }
    
    public String changePi(String str) {
        if (str.length() < 2) return str; //C
        if (str.substring(0, 2).equals("pi")) //C
            return 3.14 + changePi(str.substring(2)); //C + T(n-1)
        return str.charAt(0) + changePi(str.substring(1)); //C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA: 
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }
}
