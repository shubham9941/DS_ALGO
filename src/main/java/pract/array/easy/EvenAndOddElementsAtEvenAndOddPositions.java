package pract.array.easy;

import pract.Reader;

/*
Given an array. The task is to arrange the array such that odd elements occupy the odd positions and even elements occupy the even positions. The order of elements must remain same. Consider zero-based indexing. After printing according to conditions, if remaining, print the remaining elements as it is.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, in a new line print the arranged array.

Constraints:
1<=T<=100
1<=N<=105
1<=A[i]<=105

Example:
Input:
2
6
1 2 3 4 5 6
4
3 2 4 1
Output:
2 1 4 3 6 5
2 3 4 1

*/
public class EvenAndOddElementsAtEvenAndOddPositions {

    static void shiftElements(int[] arr, int start, int end) {
        for (int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
    }

    static void convert(int[] arr, int size) {
        boolean flag;
        int temp;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0)
                flag = true;
            else
                flag = false;
            if (flag && arr[i] % 2 != 0) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] % 2 == 0) {
                        temp = arr[j];
                        shiftElements(arr, i, j);
                        arr[i] = temp;
                        break;
                    }
                }
            } else if (!flag && arr[i] % 2 == 0) {
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] % 2 != 0) {
                        temp = arr[j];
                        shiftElements(arr, i, j);
                        arr[i] = temp;
                        break;
                    }
                }
            }

        }
    }

// O(n)
    static void optimisedConvert(int[] arr, int size) {
        int[] temp = new int[size];
        int k = 0;
        for (int pos : arr) {
            if (pos % 2 == 0) {
                temp[k] = pos;
                k++;
            }
        }
        int negPos = k;
        int posPos = 0;
        for (int pos : arr) {
            if (!(pos % 2 == 0)) {
                temp[k] = pos;
                k++;
            }
        }

        int j = negPos;

        System.out.println(">>>>j>>>"+ j);
        int i = 0;

        for (; i < size; i++) {

            if(negPos >= size || posPos >=j)
                break;

            if (i % 2 == 0 && posPos < j) {
                arr[i] = temp[posPos];
                posPos++;
            } else if (negPos < size) {
                arr[i] = temp[negPos];
                negPos++;
            }
        }

    }


    // function to arrange
// odd and even numbers
    public static void arrangeOddAndEven(int arr[], int n)
    {
        int oddInd = 1;
        int evenInd = 0;
        while (true)
        {
            while (evenInd < n && arr[evenInd] % 2 == 0)
                evenInd += 2;

            while (oddInd < n && arr[oddInd] % 2 == 1)
                oddInd += 2;

            System.out.println("Even Index = " + evenInd);
            System.out.println("Odd Index  = " + oddInd);

            if (evenInd < n && oddInd < n)
            {
                int temp = arr[evenInd];
                arr[evenInd] = arr[oddInd];
                arr[oddInd] = temp;
            }

            else
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
//            convert(arr, size);
            optimisedConvert(arr, size);
//            arrangeOddAndEven(arr, size);
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }
}
