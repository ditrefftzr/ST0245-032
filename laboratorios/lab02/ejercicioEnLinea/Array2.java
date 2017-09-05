public class Array2 {

    public int countEvens(int[] nums) {
        int count = 0;//        C
        for (int n : nums) {//  n
            if (n % 2 == 0) {// n
                count++;    //  n
            }
        }
        return count;       //C
        //Complejidad O(n)
    }

    public int[] post4(int[] nums) {
        int[] arr = new int[0]; //C
        int idx = 0;    //C

        for (int i = 0; i < nums.length; i++) { //n
            if (nums[i] == 4) {                 //n*C
                arr = new int[nums.length - 1 - i];//n*C
                idx = 0;                        //n*C
            } else if (arr.length > 0) {//n*C
                arr[idx] = nums[i];     //n*C
                idx++;//n*C
            }
        }

        return arr;//C
        //Complejidad O(n)
    }

    public boolean only14(int[] nums) {
        for (int n : nums) {//n
            if (n != 4 && n != 1) {//n*C1
                return false;//n*C2
            }
        }
        return true;//C3
        //Complejidad O(n)
    }

    public String[] fizzArray2(int n) {
        String[] arr = new String[n];//C

        for (int i = 0; i < arr.length; i++) {//n
            arr[i] = "" + i;//n
        }
        return arr;//C
        //Complejidad O(n)
    }

    public boolean has12(int[] nums) {
        boolean one = false;//C
        for (int i = 0; i < nums.length; i++) {//n
            if (nums[i] == 1 && !one) {//n*C
                one = true;//n*C
            } else if (one) {//n*C
                if (nums[i] == 2) {//n*C
                    return true;//n*C
                }
            }
        }

        return false;//C
        //Complejidad O(n)
    }
}
