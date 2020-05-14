package pract.array.easy;

public class FindAnEqualPointInAStringOfBrackets {

    // Using brut force - But have one index problem in some test cases
    static int getIndex(char[] arr, int l) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < l; i++) {
            closeCount = 0;

            if (arr[i] == '(')
                openCount++;
            else closeCount++;

            for (int j = i + 1; j < l; j++) {
                if (arr[j] == ')') {
                    closeCount++;
                }
            }
            if (openCount == closeCount) {
                return i;
            }
        }
        System.out.println("openCount:- " + openCount);
        if (openCount == 0) {
            return l;
        }
        return -1;
    }


    //My optimised solution but have one index problem, idea is same as solution provided by geeks
    static int getIndex2(char[] arr, int l) {
        int[] open = new int[l];
        int[] closed = new int[l];
        if (arr[0] == '(')
            open[0] = 1;

        for (int i = 1; i < l; i++) {
            if (arr[i] == '(')
                open[i] = open[i - 1] + 1;
            else open[i] = open[i - 1];
        }

        if (arr[l - 1] == ')')
            closed[l - 1] = 1;
        for (int i = l - 2; i >= 0; i--) {
            if (arr[i] == ')')
                closed[i] = closed[i + 1] + 1;
            else closed[i] = closed[i + 1];
        }
        for(int i = 0 ; i < l ; i ++){
            if (open[i] == closed[i]){
                System.out.println(i);

            }
//                return i ;
        }
        return -1;


    }


    // GEEKS solution
    static int findIndex(String str)
    {
        int len = str.length();
        int open[] = new int[len+1];
        int close[] = new int[len+1];
        int index = -1;

        open[0] = 0;
        close[len] = 0;
        if (str.charAt(0)=='(')
            open[1] = 1;
        if (str.charAt(len-1) == ')')
            close[len-1] = 1;

        // Store the number of opening brackets
        // at each index
        for (int i = 1; i < len; i++)
        {
            if ( str.charAt(i) == '(' )
                open[i+1] = open[i] + 1;
            else
                open[i+1] = open[i];
        }

        // Store the number of closing brackets
        // at each index
        for (int i = len-2; i >= 0; i--)
        {
            if ( str.charAt(i) == ')' )
                close[i] = close[i+1] + 1;
            else
                close[i] = close[i+1];
        }

        // check if there is no opening or closing
        // brackets
        if (open[len] == 0)
            return len;
        if (close[0] == 0)
            return 0;

        // check if there is any index at which
        // both brackets are equal
        for (int i=0; i<=len; i++)
            if (open[i] == close[i])
                index = i;

        return index;
    }

    public static void main(String[] args) throws Exception {
        String open = "())(((())(()()(()))))()(()))(((()))((()()(((";
        String closed = "(()())()()())()))((()()()((()()()())()())))";
        String str = "(())))(";

//        String str = "())(((())(()()(()))))()(()))(((()))((()()(((()())()()())()))((()()()((()()()())()())))";
//        System.out.print(findIndex("(())"));
//        String str2 = "";
//        System.out.print(getIndex2("(())".toCharArray() , "(())".length()));
        System.out.print(getIndex2("(())".toCharArray() , "(())".length()));
//
//        System.out.println(open.length() - 1);
//        countOpen(open.toCharArray(), open.length());
//        countOpen(closed.toCharArray(), closed.length());
//        Reader sc = new Reader();
//        int testCases = sc.nextInt();
//        while (testCases-- > 0) {
//            String str = sc.readLine();
//            System.out.println(getIndex(str.toCharArray(),  str.length()));
//        }
    }
}
