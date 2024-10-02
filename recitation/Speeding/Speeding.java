public class Speeding {
	public static void main(String[] args) {
		int speed = Integer.parseInt(args[0]);
		if (speed < 60) {
			System.out.println("WARNING");
		} else if(speed <= 75) {
			System.out.print("$100 fine");
		} else if (speed <= 90) {
			System.out.println("$200 fine");
		} else {
			System.out.println("$500 fine");
		}
	}
}
