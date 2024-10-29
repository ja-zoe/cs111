public class CountEven {
    public static void main(String[] args) {
        int[] jawn = {1,2,3,4};
        System.out.println(countEven(jawn));
    }

    public static int countEven(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
    }
}