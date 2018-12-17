package partie4;

public class TestMD5{

	public static void main(String[] args){
		MD5t m = new MD5t();
		System.out.println(m.md5("Wikipedia est pas mal comme navigateur de feffffffffffffffffffffrecherche"));
		System.out.println(Integer.toBinaryString(Integer.parseInt("61", 16)));
		/*for(int i = 0 ; i<res.length;i++)
			System.out.println(res[i]);*/
		//System.out.println("Résultat attendu : ");
		/*System.out.println("-645128748\r\n" + 
				"78774415\r\n" + 
				"-1744207639\r\n" + 
				"2118318316");*/
		//System.out.println("0xD41D8CD98F00B204E9800998ECF8427E <== \"\"");
		//byte[] b = new MD5t().messPad("".getBytes());
	}

}
