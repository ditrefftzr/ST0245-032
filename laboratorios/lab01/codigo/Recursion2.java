/**
 * 
 * @author anietog1, ditrefftzr
 */
public class Recursion2 {
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; //C

        if (groupSum6(start + 1, nums, target - nums[start])) return true; //C + T(n-1)
        
        if (nums[start] == 6) target -= 6; //C
        
        return groupSum6(start + 1, nums, target); //C + T(n+1)
        //MODELO: T(n) =    |C, n=0
        //                  |C + T(n-1) + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              C(2^n - 1) + C1*2^(n-1)
        //COMPLEJIDAD
        //          O(C(2^n - 1) + C1*2^(n-1))
        //          O(C(2^n) + C1*2^(n))        -> Por regla de la suma             (2 veces)
        //          O(2^n + 2^n)                -> Por regla de la multiplicacion   (2 veces)
        //          O(2*2^n)
        //          O(2^n)                      -> Por regla de la multiplicacion
    }
    
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; //C
        
        if (groupNoAdj(start + 1, nums, target)) return true; //C + T(n-1)
        
        target -= nums[start]; //C
        
        if (start < nums.length - 1) start++; //C
        
        return groupNoAdj(start + 1, nums, target); //C + T(n-1)
        //MODELO: T(n) =    |C, n=0
        //                  |C + T(n-1) + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              C(2^n - 1) + C1*2^(n-1)
        //COMPLEJIDAD
        //          O(C(2^n - 1) + C1*2^(n-1))
        //          O(C(2^n) + C1*2^(n))        -> Por regla de la suma             (2 veces)
        //          O(2^n + 2^n)                -> Por regla de la multiplicacion   (2 veces)
        //          O(2*2^n)
        //          O(2^n)                      -> Por regla de la multiplicacion
    }
    
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; //C
        
        if (nums[start] % 5 == 0) { //C
            target -= nums[start]; //C
            if (start < nums.length - 1) { //C
                if (nums[start + 1] == 1) { //C
                    nums[start + 1] = 0; //C
                    start++; //C
                }
            }
            
            if(groupSum5(start + 1, nums, target)) return true; //C + T(n-1)
        }else if(groupSum5(start + 1, nums, target - nums[start])) return true; //C + T(n-1)

        return groupSum5(start + 1, nums, target); //C + T(n-1)
        //MODELO: T(n) =    |C, n=0
        //                  |C + T(n-1) + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              C(2^n - 1) + C1*2^(n-1)
        //COMPLEJIDAD
        //          O(C(2^n - 1) + C1*2^(n-1))
        //          O(C(2^n) + C1*2^(n))        -> Por regla de la suma             (2 veces)
        //          O(2^n + 2^n)                -> Por regla de la multiplicacion   (2 veces)
        //          O(2*2^n)
        //          O(2^n)                      -> Por regla de la multiplicacion
    }
    
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; //C

        int count = 0;//C

        if (start < nums.length - 1) { //C
            while (nums[start] == nums[start + count]) { //n
                count++;//n*C
            }
        } else {
            count = 1;//C
        }

        int summ = nums[start] * count;//C
        
        return groupSumClump(start + count, nums, target - summ)//C + T(n-1)
                || groupSumClump(start + count, nums, target); //C + T(n-1)
        //MODELO: T(n) =    |C     , n=0
        //                  |C + n + T(n-1) + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              (2*C + C1 + 4)*2^(n-1) - C - n - 2
        //COMPLEJIDAD
        //          O((2*C + C1 + 4)*2^(n-1) - C - n - 2)
        //          O((2*C + C1 + 4)*2^(n-1) - C - n)   -> Por regla de la suma
        //          O((2*C + C1 + 4)*2^(n-1) - n)       -> Por regla de la suma
        //          O((2*C + C1 + 4)*2^(n) - n)         -> Por regla de la suma
        //          O((C)*2^n - n)                      -> Por regla de la suma (varias constantes = 1 constante)
        //          O(2^n - n)                          -> Por regla de la multiplicacion
        //          O(2^n)                              -> Por regla de la suma
    }
    
    public boolean splitArray(int[] nums) {
        return helper(0, nums, 0, 0);
    }

    private boolean helper(int start, int[] nums, int sum1, int sum2) {
        if (start >= nums.length) {//C
            return sum1 == sum2;//C
        }
        
        return helper(start + 1, nums, sum1 + nums[start], sum2) || helper(start + 1, nums, sum1, sum2 + nums[start]);//C + 2*T(n-1)
        //MODELO: T(n) =    |C     , n=0
        //                  |C + 2*T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              C(2^n - 1) + C1*2^(n-1)
        //COMPLEJIDAD
        //          O(C(2^n - 1) + C1*2^(n-1))
        //          O(C(2^n) + C1*2^(n))        -> Por regla de la suma             (2 veces)
        //          O(2^n + 2^n)                -> Por regla de la multiplicacion   (2 veces)
        //          O(2*2^n)
        //          O(2^n)                      -> Por regla de la multiplicacion
    }
    
    public boolean split53(int[] nums) {
        return helper3(0, nums, 0, 0);
    }

    private boolean helper3(int index, int[] nums, int sum5s, int sum3n5) {
        if (index >= nums.length) { //C
            return sum5s == sum3n5; //C
        }
        
        if (nums[index] % 5 == 0) { //C
            return helper3(index + 1, nums, sum5s + nums[index], sum3n5); //C + T(n-1)
        }
        if (nums[index] % 3 == 0) { //C
            return helper3(index + 1, nums, sum5s, sum3n5 + nums[index]); //C + T(n-1)
        }

        return helper3(index + 1, nums, sum5s, sum3n5 + nums[index]) || helper3(index + 1, nums, sum5s + nums[index], sum3n5); //C + T(n-1) + T(n-1)
        //MODELO: T(n) =    |C     , n=0
        //                  |C + T(n-1) + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //              C(2^n - 1) + C1*2^(n-1)
        //COMPLEJIDAD
        //          O(C(2^n - 1) + C1*2^(n-1))
        //          O(C(2^n) + C1*2^(n))        -> Por regla de la suma             (2 veces)
        //          O(2^n + 2^n)                -> Por regla de la multiplicacion   (2 veces)
        //          O(2*2^n)
        //          O(2^n)                      -> Por regla de la multiplicacion
    }
}
