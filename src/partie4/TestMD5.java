package partie4;

public class TestMD5{

	public static void main(String[] args){
		MD5 m = new MD5();
		//System.out.println("0x"+m.toHexString(m.computeMD5("a".getBytes())));
		System.out.println(m.md5("a".getBytes()));
	}

}
