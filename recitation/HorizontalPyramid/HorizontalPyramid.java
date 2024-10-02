public class HorizontalPyramid{
	public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n<1) {
            System.out.print("Please input a number greater than or equal to 1");
            return;
        }
        int starCount = 1;
        for (int i = 1;  i <= n*2-1 ; i++) {
            for (int j=1; j <= starCount; j++) {
                System.out.print("*");
            } 
            System.out.println("");
            if (i >= (n*2)/2) {
                starCount--;
            } else {
                starCount++;
            }
        }
    }
}
