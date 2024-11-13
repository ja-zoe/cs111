public class pyramid {

     public static void main(String[] args) {
        int n = 6;
        pyramid(n);
     }

     public static void pyramid(int num) {
        if (num == 0) {
            return;
        }
        pyramid(num - 1);

        for(int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
     }
}