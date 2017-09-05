public class Array3 {

    public int maxSpan(int[] nums) {
        int max = 0;//C
        for (int i = 0; i < nums.length; i++) {//n*C

            int j = nums.length - 1;//n*C
            for (;; j--) {//n*n*C
                if (nums[j] == nums[i]) {//n*n*C
                    break;//n*n*C
                }
            }

            int span = j - i + 1;//n*C

            if (span > max) {//n*C
                max = span;//n*C
            }
        }
        return max;//C
        //Complejidad O(n*n)
    }

    public int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length; i++) {//n
            if (nums[i] == 4) {//n*C
                for (int j = 0; j < nums.length; j++) {//n*n*C
                    if (nums[j] == 5) {//n*n*C
                        if (j == 0 || nums[j - 1] != 4) {//n*n*C
                            nums[j] = nums[i + 1];//n*n*C
                            nums[i + 1] = 5;//n*n*C
                            i++;//n*n*C
                            break;//n*n*C
                        }
                    }
                }
            }
        }
        return nums;//C
        //Complejidad O(n^2)
    }

    public boolean canBalance(int[] nums) {
        int sum1 = 0;//C
        int sum2 = 0;//C
        for (int i = 0; i < nums.length; i++) {//n
            sum2 += nums[i];//n*C
        }

        for (int i = 0; i < nums.length; i++) {//n
            if (sum1 == sum2) {//n*C
                return true;//n*C | 1 | C .____. no se que hacer, solo ocurriria una vez...
            }
            sum1 += nums[i];//n*C
            sum2 -= nums[i];//n*C
        }

        return sum1 == sum2;//C
        //Complejidad O(n)
    }

    public boolean linearIn(int[] outer, int[] inner) {
        //outer = n, inner = m
        int oIdx = 0;//C
        int iIdx = 0;//C

        while (oIdx < outer.length && iIdx < inner.length) {//n

            if (outer[oIdx] == inner[iIdx]) {//n*C
                iIdx++;//n*C
            } else if (outer[oIdx] > inner[iIdx]) {//n*C
                return false;//n*C
            }
            oIdx++;//n*C
        }

        return iIdx == inner.length;//C
        //Complejidad O(n)
    }

    public int[] seriesUp(int n) {
        int[] arr = new int[n * (n + 1) / 2];//C

        int goal = 1;//C

        for (int i = 0; i < arr.length; i++) {//n
            int j = 0;//n*C
            while (j < goal) {//n*n*C
                arr[i + j] = j + 1;//n*n*C
                j++;//n*n*C
            }
            i = i + j - 1;//n*C
            goal++;//n*C
        }

        return arr;//C
        //COMPLEJIDAD: O(n*n)
    }
}
