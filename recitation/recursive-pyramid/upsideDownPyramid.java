public class upsideDownPyramid {
    public static void main(String[] args) {
        pyramid(6);
    }

    public static void pyramid(int n) {
        if (n == 1) {
            System.out.println("*");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
            pyramid(n - 1);
        }
    }
}