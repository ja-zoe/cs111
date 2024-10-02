public class LoopPrint{
	public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	if (n<1) {
	    System.out.print("Please input a number greater than or equal to 1");
	    return;
    }
    for (int i = 1;  i <= n ; i++) {
        System.out.print(i + ",");
    }
}
}
