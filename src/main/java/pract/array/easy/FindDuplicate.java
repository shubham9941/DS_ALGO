package pract.array.easy;

/*
Find duplicates in O(n) time and O(1) extra space | Set 1
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
*/

class FindDuplicate
{
    // Function to print duplicates
    void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
            if (arr[ Math.abs(arr[i])] >= 0)
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    // Driver program
    public static void main(String[] args)
    {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;

        duplicate.printRepeating(arr, arr_size);
    }
}
