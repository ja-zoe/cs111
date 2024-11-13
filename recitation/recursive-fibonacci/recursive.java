public class recursive {
    public static void main(String[] args) {
        int n = 10;
        int arr = fibonacci(n);
        System.out.println(arr);
    }

    public static int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } 
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}