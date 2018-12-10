package partie4;

public class TestMD5 {

	public static void main(String[] args) {
		String a= "a";
		System.out.println(new MD5().padding(a));
		System.out.println(new MD5().intToLittleEndian(87).toString());
	}

}
