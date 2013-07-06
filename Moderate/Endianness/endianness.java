import java.nio.ByteOrder;
public class endianness {
	public static void main(String argv[]){
		ByteOrder b=ByteOrder.nativeOrder();
		if(b.equals(ByteOrder.BIG_ENDIAN))
			System.out.print("BigEndian");
		else
			System.out.print("LittleEndian ");
	}
}
