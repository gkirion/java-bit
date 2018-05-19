import java.util.Arrays;

public class BitPacking {
	
	private int[] array;
	private int index;
	private int length;
	private int dataSize;
	private final int CELL_SIZE = Integer.SIZE;
	
	public BitPacking() {
		length = 4;
		array = new int[length];
		index = 0;
		dataSize = 1;
	}
	
	public BitPacking(int dataSize) {
		length = 4;
		array = new int[length];
		index = 0;
		this.dataSize = dataSize + dataSize % 2;
	}
	
	public void add(int value) {
		int arrayIndex = index / (CELL_SIZE / dataSize);
		int cellIndex = index % (CELL_SIZE / dataSize);
		if (arrayIndex >= length) {
			length = length * 2;
			array = Arrays.copyOf(array, length);
		}
		//mask = mask >>> cellIndex * dataSize;
		//int cell = value << ((CELL_SIZE / dataSize - 1) - cellIndex) * dataSize;
		value = value << cellIndex * dataSize;
		array[arrayIndex] = array[arrayIndex] | value;
		index++;
	}
	
	public int get(int i) {
		int arrayIndex = i / (CELL_SIZE / dataSize);
		int cellIndex = i % (CELL_SIZE / dataSize);
		int mask = (int)Math.pow(2, dataSize) - 1;
		mask = mask << cellIndex * dataSize;
		int value = array[arrayIndex] & mask;
		value = value >>> cellIndex * dataSize;
		return value;
	}

}
