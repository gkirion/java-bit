import java.util.ArrayList;

public class Launcher {

	public static void main(String[] args) {
		int num = 0;
		System.out.println(num);
		num = (int)Math.pow(2, 2) - 1;
		System.out.println(num);
		num = num << Integer.SIZE - 2;
		System.out.println(num);
		int cell = 0xAFFFFFFF;
		System.out.println(cell);
		System.out.println((cell & num) >>> Integer.SIZE - 2);
		BitPacking bitPacking = new BitPacking(2);
		ArrayList<Integer> arrayList = new ArrayList<>();
		for (int i = 0; i < 100000000; i++) {
			//bitPacking.add(2);
			arrayList.add(2);
		}
		for (int i = 0; i < 100000000; i++) {
		/*	if (bitPacking.get(i) != arrayList.get(i)) {
				System.out.println("NOT OK");
			}*/
			//bitPacking.get(i);
			arrayList.get(i);
		}
	}

}
