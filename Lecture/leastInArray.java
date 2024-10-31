public class leastInArray {
    public static void main(String[] args) {
        int[][] arr = {{9,2,1}, {6,9,5}, {7,6,8}};
        least(arr);
    }

    public static void least(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int least = arr[i][0];
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] < least) least = arr[i][j];
            }
            System.out.println("Minimum in Row " + i + ": " + least);
        }
    }
}