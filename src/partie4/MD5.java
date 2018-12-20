package partie4;



public class MD5 {

	private static final int a0 = 0x67452301;
	private static final int b0 = (int)0xEFCDAB89;
	private static final int c0= (int)0x98BADCFE;
	private static final int d0 = 0x10325476;

	private int R[] = {
			7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22, 
			5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20, 
			4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23, 
			6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21
	};

	private int[] K = new int[64]; 


	public String md5(byte[] message) {

		//MD5 utilise des sinus d'entiers pour ses constantes :
		for (int i = 0; i < 64; i++) K[i] = (int)(long)(Math.abs(Math.sin(i+1)) * Math.pow(2, 32));

		//Préparation des variables :
		int a = a0;
		int b = b0;
		int c = c0;
		int d = d0;

		//Préparation du message (padding) :
		int messageLen = message.length;
		int nb_block = ((messageLen + 8) >>> 6) + 1;
		int totalLen = (int)(nb_block*Math.pow(2, 6));//taille du message initial en 64 bits
		byte[] padded_mess = new byte[totalLen - messageLen];
		padded_mess[0] = (byte)0x80;//ajout du bit "1" au message
		int sizeBits = (int)(messageLen*Math.pow(2,3)); // taille du message en binaire ( 8-bit par lettre)
		for (int i = 0; i < 8; i++)// on met la taille en little endian
		{
			padded_mess[padded_mess.length - 8 + i] = (byte)sizeBits;//premier est la taille 
			sizeBits >>>= 8;//on descend sizebits de 8 shift à droite 
		}
		//Découpage en blocs de 512 bits :
		for(int i = 0;i<nb_block;i++) {
			int index = i << 6;
			int[] buffer = new int[16];
			for(int j = 0;j<64;j++,index++) {
				if(index < messageLen) {
					//j >>> 2 est l'indice de 0 à 16 en unsigned
					buffer[j >>> 2] = ((int)(message[index] << 24) | (buffer[j >>> 2] >>> 8));//
				}else {
					buffer[j >>> 2] = ((int)(padded_mess[index - message.length] << 24) | (buffer[j >>> 2] >>> 8));
				}
			}

			//initialiser les valeurs de hachage :
			int A = a;
			int B = b;
			int C = c;
			int D = d;

			//Boucle principale :
			for(int k = 0; k < 64;k++) {
				int F = 0;
				int g = k;
				if(k>=0 && k<=15) {
					F = (B & C) | (~B & D);
					g = k;
				}
				if(k>=16 && k<=31) {
					F = (B & D) | (C & ~D);
					g = (5*k + 1)%16 & 0x0F;
				}
				if(k>=32 && k<=47) {
					F = B ^ C ^ D;
					g = (3*k + 5)%16 & 0x0F;
				}
				if(k>=48 && k<=63) {
					F = C ^ (B | ~D);
					g = (7*k)%16 & 0x0F;
				}
				int temp = B + Integer.rotateLeft((A + F + K[k] + buffer[g]),R[k]);
				A = D;
				D = C;
				C = B;
				B = temp;
			}
			//ajouter le résultat au bloc précédent :
			a += A;
			b += B;
			c += C;
			d += D;
		}

		//var entier empreinte := h0 concaténer h1 concaténer h2 concaténer h3 //(en little-endian)
		byte[] md5 = new byte[16];

		int count = 0;
		for (int i = 0; i < 4; i++)
		{
			int n = (i == 0) ? a : ((i == 1) ? b : ((i == 2) ? c : d));
			for (int j = 0; j < 4; j++)
			{
				md5[count++] = (byte)n;
				n >>>= 8;
			}
		}
		return "0x"+toHexString(md5);
	}

	public String toHexString(byte[] b)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++)
		{
			sb.append(String.format("%02X", b[i] & 0xFF));
		}
		return sb.toString();
	}



	//0xabcdefgh => 0xghefcdab
	public String padding(String mess) {
		//Pre-processing: padding with zeros
		byte[]mess_byte = mess.getBytes();
		String res = "";
		String resHexa = "";
		/*****Mot en Hexa*****/
		for(int i = 0;i<mess_byte.length;i++) {
			String temp = Integer.toBinaryString(mess_byte[i]);
			while(temp.length() < 8 ) {
				temp = "0"+temp;
			}
			res += temp;
		}
		String sizebin = Integer.toBinaryString(res.length());
		/*****Ajout du 1*****/
		res = res + "1";
		while(res.length()%512 != 448) {
			res = res+"0";
		}
		resHexa = toHexString(res);
		/*****SIZE*****/
		while(sizebin.length()<8) {
			sizebin = "0"+sizebin;
		}
		while(sizebin.length()<64) {
			sizebin = sizebin+"0";
		}
		String sizeHex = toHexString(sizebin);
		return resHexa+sizeHex;
	}

	public String toHexString(String s) {
		String res = "";
		if(s.length()%8 == 0) {
			for(int i = 0;i<s.length();i = i+4) {
				String temp = s.substring(i, i+4);
				int decimal = Integer.parseInt(temp,2);
				res = res + Integer.toString(decimal,16);
			}
		}
		return res;
	}
}
