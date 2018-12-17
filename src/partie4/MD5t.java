package partie4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class MD5t {


	private int a0 = 0x67452301;
	private int b0 = 0xEFCDAB89;
	private int c0= 0x98BADCFE;
	private int d0 = 0x10325476;

	private int R[] = {
			7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22, 
			5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20, 
			4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23, 
			6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21
	};

	private int[] K = new int[64]; 


	public MD5t() {
		for (int i = 0; i < 64; i++)
			K[i] = (int)(long)((1L << 32) * Math.abs(Math.sin(i + 1)));
	}
	public byte[] md5(String message) {


		//Pre-processing: padding
		String padded_mess = padding(message);
		System.out.println(padded_mess);
		//Process the message in successive 512-bit chunks:
		int nb_block = (int)padded_mess.length()/124;
		int A = a0;
		int B = b0;
		int C = c0;
		int D = d0;
		for(int i = 0;i<nb_block;i++) {
			String s = padded_mess.substring(i*124, (i+1)*124);
			System.out.println(s);
			ArrayList<Integer> list_s = new ArrayList<>();
			for(int j = 0;j<16;j++) {
				String temp_s = s.substring((j*32),((j+1)*32));
				//System.out.println(littleEndianBinary(temp_s));
				int decimal = Integer.parseUnsignedInt(littleEndianBinary(temp_s),2);
				list_s.add(Integer.parseUnsignedInt(Integer.toHexString(decimal)));
				//System.out.println(Integer.parseUnsignedInt(Integer.toHexString(decimal))+"\n");
			}
			//Main loop
			int F = 0;
			int g = 0;
			for(int k = 0; k < 64;k++) {
				if(k>=0 && k<=15) {
					F = (B & C) | (~B & D);
					g = k;
				}
				if(k>=16 && k<=31) {
					F = (B & D) | (C & ~D);
					g = (5*k + 1)%16;
				}
				if(k>=32 && k<=47) {
					F = B ^ C ^ D;
					g = (3*k + 5)%16;
				}
				if(k>=48 && k<=63) {
					F = C ^ (B | ~D);
					g = (7*k)%16;
				}
				int temp = D;
				D = C;
				C = B;
				B = B + Integer.rotateLeft((A + F + K[k] + list_s.get(g)),R[k]);
				A = temp;
			}
			//Add this chunk's hash to result so far:
			a0 += A;
			b0 += B;
			c0 += C;
			d0 += D;
		}
		System.out.println(a0);
		System.out.println(b0);
		System.out.println(c0);
		System.out.println(d0);
		
		byte[] md5 = new byte[16];
		int count = 0;
		for (int i = 0; i < 4; i++)
		{
			int n = (i == 0) ? a0 : ((i == 1) ? b0 : ((i == 2) ? c0 : d0));
			for (int j = 0; j < 4; j++)
			{
				md5[count++] = (byte)n;
				n >>>= 8;
			}
		}
		return md5;
	}

	private String littleEndianBinary(String temp_s) {
		String res = "";
		res += temp_s.substring(24,32);
		res += temp_s.substring(16,24 );
		res += temp_s.substring(8,16);
		res += temp_s.substring(0,8);
		return res;
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
	public String padding(String mess) {//Pre-processing: padding with zeros
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

	public String toHexString(Integer s){return Integer.toString(s,16);}
	
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
	
	public byte[] messPad(byte[] message) {
		int messageLenBytes = message.length;
		int numBlocks = ((messageLenBytes + 8) >>> 6) + 1;
		int totalLen = numBlocks << 6;
		byte[] paddingBytes = new byte[totalLen - messageLenBytes];
		paddingBytes[0] = (byte)0x80;

		long messageLenBits = (long)messageLenBytes << 3;
		for (int i = 0; i < 8; i++)
		{
			paddingBytes[paddingBytes.length - 8 + i] = (byte)messageLenBits;
			messageLenBits >>>= 8;
		}
		return paddingBytes;
	}
}
