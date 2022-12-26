package com.sparksfly.simple.d1;

/**
 * @author wangh
 * @desc 整数除法
 * @date 2022/11/29 15:48
 */

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'。
 *
 *
 * 注意：
 *
 *     整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
 *     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,231−1]。本题中，如果除法结果溢出，则返回 231− 1
 */
public class IntegerDivision {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }

    public static int divide(int dividend, int divisor){
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }
        if(dividend == Integer.MAX_VALUE && divisor == 1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MAX_VALUE && divisor == -1){
            return Integer.MIN_VALUE;
        }
        int sign = 1; // 0为整数 1为负数
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            sign = 0;
        }
        Long dividendL = Math.abs((long) dividend);
        Long divisorL = Math.abs((long) divisor);

        int result = 0;
        while (dividendL >= divisorL){
            Long temp = divisorL, i = 1L;
            while(dividendL >= temp){
                dividendL-=temp;
                result+=i;
                i<<=1;
                temp<<=1;
            }
        }

        result = sign == 0?result:-result;
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return result;
    }

}
