public class RecursiveSum {
    public static void main(String[] args) {
        System.out.println(findEars(2));
    }

    public static int findEars(int bunny) {
        if (bunny == 0) {
            return 0;
        } else if (bunny % 2 == 0) {
            return 3 + findEars(bunny - 1);
        } else {
            return 2 + findEars(bunny - 1);
        }
    
    }
}