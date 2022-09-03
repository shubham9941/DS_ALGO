//package pract.array.basic;
//
//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class FindMissingAndRepeating {
//
//    static public class Reader {
//        final private int BUFFER_SIZE = 1 << 16;
//        private DataInputStream din;
//        private byte[] buffer;
//        private int bufferPointer, bytesRead;
//
//        public Reader() {
//            din = new DataInputStream(System.in);
//            buffer = new byte[BUFFER_SIZE];
//            bufferPointer = bytesRead = 0;
//        }
//
//        public Reader(String file_name) throws IOException {
//            din = new DataInputStream(new FileInputStream(file_name));
//            buffer = new byte[BUFFER_SIZE];
//            bufferPointer = bytesRead = 0;
//        }
//
//        public String readLine() throws IOException {
//            byte[] buf = new byte[64]; // line length
//            int cnt = 0, c;
//            while ((c = read()) != -1) {
//                if (c == '\n')
//                    break;
//                buf[cnt++] = (byte) c;
//            }
//            return new String(buf, 0, cnt);
//        }
//
//        public int nextInt() throws IOException {
//            int ret = 0;
//            byte c = read();
//            while (c <= ' ')
//                c = read();
//            boolean neg = (c == '-');
//            if (neg)
//                c = read();
//            do {
//                ret = ret * 10 + c - '0';
//            } while ((c = read()) >= '0' && c <= '9');
//
//            if (neg)
//                return -ret;
//            return ret;
//        }
//
//        public long nextLong() throws IOException {
//            long ret = 0;
//            byte c = read();
//            while (c <= ' ')
//                c = read();
//            boolean neg = (c == '-');
//            if (neg)
//                c = read();
//            do {
//                ret = ret * 10 + c - '0';
//            }
//            while ((c = read()) >= '0' && c <= '9');
//            if (neg)
//                return -ret;
//            return ret;
//        }
//
//        public double nextDouble() throws IOException {
//            double ret = 0, div = 1;
//            byte c = read();
//            while (c <= ' ')
//                c = read();
//            boolean neg = (c == '-');
//            if (neg)
//                c = read();
//
//            do {
//                ret = ret * 10 + c - '0';
//            }
//            while ((c = read()) >= '0' && c <= '9');
//
//            if (c == '.') {
//                while ((c = read()) >= '0' && c <= '9') {
//                    ret += (c - '0') / (div *= 10);
//                }
//            }
//
//            if (neg)
//                return -ret;
//            return ret;
//        }
//
//        private void fillBuffer() throws IOException {
//            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
//            if (bytesRead == -1)
//                buffer[0] = -1;
//        }
//
//        private byte read() throws IOException {
//            if (bufferPointer == bytesRead)
//                fillBuffer();
//            return buffer[bufferPointer++];
//        }
//
//        public void close() throws IOException {
//            if (din == null)
//                return;
//            din.close();
//        }
//    }
//
//    static void printMissing(int[] arr, int size) {
//        int[] newArr = new int[size];
//        for (int i : arr) {
//            if (i != 0) {
//                newArr[i - 1] = -1;
//            }
//        }
//        for (int j = 0; j < newArr.length; j++) {
//            if (newArr[j] == 0)
//                System.out.println(j + 1);
//        }
//    }
//
//    static void findMissingAndRepeatingNumber(int[] arr, int size) {
//
//
//        for (int i = 0; i < size; i++) {
//            if (arr[i] == 0) {
//                System.out.println("" + arr[i - 1]);
//            }
//        }
//        for (int j = 0; j < size; j++) {
//            if (arr[j] != 0) {
//                System.out.println("j = " + j);
//                System.out.println("Missing element:- " + (j + 1));
//            }
//        }
//
//    }
//
//    static void printTwoElements(int arr[], int size)
//    {
//        int i;
//        System.out.print("The repeating element is ");
//
//        for (i = 0; i < size; i++) {
//            int abs_val = Math.abs(arr[i]);
//            if (arr[abs_val - 1] > 0)
//                arr[abs_val - 1] = -arr[abs_val - 1];
//            else
//                System.out.println(abs_val);
//        }
//
//        System.out.print("And the missing element is ");
//        for (i = 0; i < size; i++) {
//            if (arr[i] > 0)
//                System.out.println(i + 1);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        Reader sc = new Reader();
//        int testCases = sc.nextInt();
//        while (testCases-- > 0) {
//            int size = sc.nextInt();
//            int[] arr = new int[size];
//            for (int i = 0; i < size - 1; i++) {
//                arr[i] = sc.nextInt();
//            }
//            printTwoElements(arr, size);
//
//        }
//
//    }
//}
