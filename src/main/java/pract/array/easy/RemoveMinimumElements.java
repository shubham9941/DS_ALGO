package pract.array.easy;

/*

Remove minimum elements from either side such that 2*min becomes more than max
Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. Elements should be removed either end of the array.
Number of removals should be minimum.

Examples:

arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
Output: 4
We need to remove 4 elements (4, 5, 100, 200)
so that 2*min becomes more than max.


arr[] = {4, 7, 5, 6}
Output: 0
We don't need to remove any element as
4*2 > 7 (Note that min = 4, max = 8)

arr[] = {20, 7, 5, 6}
Output: 1
We need to remove 20 so that 2*min becomes
more than max

arr[] = {20, 4, 1, 3}
Output: 3
We need to remove any three elements from ends
like 20, 4, 1 or 4, 1, 3 or 20, 3, 1 or 20, 4, 1

*/
public class RemoveMinimumElements {
    // A utility function to find minimum of two numbers
    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    // A utility function to find minimum in arr[l..h]
    static int min(int arr[], int l, int h) {
        int mn = arr[l];
        for (int i = l + 1; i <= h; i++)
            if (mn > arr[i])
                mn = arr[i];
        return mn;
    }

    // A utility function to find maximum in arr[l..h]
    static int max(int arr[], int l, int h) {
        int mx = arr[l];
        for (int i = l + 1; i <= h; i++)
            if (mx < arr[i])
                mx = arr[i];
        return mx;
    }

    // Returns the minimum number of removals from either end
// in arr[l..h] so that 2*min becomes greater than max.
    static int minRemovals(int arr[], int l, int h) {
        // If there is 1 or less elements, return 0
        // For a single element, 2*min > max
        // (Assumption: All elements are positive in arr[])
        System.out.println("l = " + l);
        System.out.println("h = " + h);
        System.out.println();
        if (l >= h) return 0;

        // 1) Find minimum and maximum in arr[l..h]
        int mn = min(arr, l, h);
        int mx = max(arr, l, h);

        //If the property is followed, no removals needed
        if (2 * mn > mx) {
            System.out.println("Min : " + mn);
            System.out.println("Max : " + mx);
            return 0;
        }

        // Otherwise remove a character from left end and recur,
        // then remove a character from right end and recur, take
        // the minimum of two is returned
        int rmL = minRemovals(arr, l + 1, h);
        int rmR = minRemovals(arr, l, h - 1);
//        System.out.println("MnL" +);
//        System.out.println("MnR");
        return min(rmL, rmR) + 1;
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200};
        int n = arr.length;
        System.out.print(minRemovals(arr, 0, n - 1));
    }
}
