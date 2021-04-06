/*

You are given an array of up to four non-negative integers, each less than 256.
Your task is to pack these integers into one number M so that the first element of the array occupies the first (or least significant) 8 bits of M; the second element occupies next 8 bits, and so on.
Return the obtained integer M as unsigned integer.

Note
As indicated the first 8 bits are the least significant bits of M, meaning the right-most bits of the integer.
For further clarification see the following example.

Specification
Challenge.arrayPacking(array)
Parameters
array: List<Integer> - up to four unsigned integers

Return Value
Integer - an unsigned integer

Constraints
array.length == 3
0 ≤ array[i] < 256

Example
For [24, 85, 0] the output should be 21784

[24,       85,       0       ] - The initial array
[00011000, 01010101, 00000000] - Translate each number to Binary
   000000000101010100011000    - Compact to a single number
            21784              - Translate to Decimal
 */

import java.util.Arrays;
import java.util.List;

public class Challenge3 {
    public static void main(String[] args) {
        System.out.println(arrayPacking(Arrays.asList(24,85,0)));

    }

    public static Integer arrayPacking( List<Integer> integers ){
        String[] myArray = new String[3];
        for (int i = 0; i < 3; i++){
            //gets the integer list index and converts it to a string binary and stores it in myArray index
            myArray[i] = Integer.toBinaryString(integers.get(i));
            // Padding the left side with zeros
            while (myArray[i].length() != 8) myArray[i] = "0" + myArray[i];
        }
        //add all the binary in myArray index together
        String result = myArray[2] + myArray[1] + myArray[0];
        int num = Integer.parseInt(result, 2);
        return num;
    }
}

