package partie4;

import java.util.ArrayList;

public class MD5t {


	private int R[] = {7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22, 
			5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20, 
			4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23, 
			6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21};
	private int K[]; 

	private int a0 = 0x67452301;
	private int b0 = 0xEFCDAB89;
	private int c0= 0x98BADCFE;
	private int d0 = 0x10325476;

	public MD5t() {
		K = new int[64];
		for(int i = 0;i<64;i++) {
			K[i] = (int)(Math.abs(Math.sin(i+1)* Math.pow(2, 32)));
		}
	}
	public String md5(String message) {

		//Pre-processing: padding
		String padded_mess = padding(message);
		System.out.println(padded_mess);
		//Process the message in successive 512-bit chunks:
		int nb_block = (int)padded_mess.length()/512;
		for(int i = 0;i<nb_block;i++) {
			String s = padded_mess.substring(i*512, (i+1)*512);
			System.out.println(s);
			ArrayList<Integer> list_s = new ArrayList<>();
			for(int j = 0;j<16;j++) {
				String temp_s = s.substring((j*32),((j+1)*32));
				System.out.println(littleEndianBinary(temp_s));
				int decimal = Integer.parseUnsignedInt(littleEndianBinary(temp_s),2);
				list_s.add(Integer.parseUnsignedInt(Integer.toHexString(decimal)));
				System.out.println(Integer.parseUnsignedInt(Integer.toHexString(decimal))+"\n");
			}
			//Initialize hash value for this chunk:
			int A = a0;
			int B = b0;
			int C = c0;
			int D = d0;
			//Main loop
			int F = 0, g = 0;
			for(int k = 0; k < 64;k++) {
				if(k>=0 && k<=15) {
					F = D ^ (B & (C ^ D));
					g = k;
				}
				if(k>=16 && k<=31) {
					F = C ^ (D & (B ^ C));
					g = (5*k + 1)%16;
				}
				if(k>=32 && k<=47) {
					F = B ^ C ^ D;
					g = (3*k + 5)%16;
				}
				if(k>=48 && k<=63) {
					F = (C ^ (B | (~ D)));
					g = (7*k)%16;
				}
				int temp = D;
				D = C;
				C = B;
				B = B + leftrotate((A + F + K[k] + list_s.get(g)),R[k]);
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
		return "0x"+(""+Integer.toHexString(a0)+
			   ""+Integer.toHexString(b0)+
			   ""+Integer.toHexString(c0)+
			   ""+Integer.toHexString(d0)).toUpperCase();
	}

	private String littleEndianBinary(String temp_s) {
		String res = "";
		res += temp_s.substring(24,32);
		res += temp_s.substring(16,24 );
		res += temp_s.substring(8,16);
		res += temp_s.substring(0,8);
		return res;
	}
	private int leftrotate(int f, int i) {
		return (f << i) | (f >> (32-i));
	}



	//0xabcdefgh => 0xghefcdab
	public String padding(String mess) {//Pre-processing: padding with zeros
		byte []mess_byte = mess.getBytes();
		String res = "";
		for(byte b : mess_byte) {
			String temp = Integer.toBinaryString(b);
			while(temp.length() < 8) {
				temp = "0"+temp;
			}	
			res += temp;	
		}
		String size = intToLittleEndian(res.length());
		res+="1";

		while(res.length()%512 != 448) {
			res+="0";
		}
		res+= size;
		return res;
	}

	public String intToLittleEndian(int numero) {
		String res = Integer.toBinaryString(numero);
		while(res.length() < 64) {
			res = "0"+res;
		}
		return res;
	}
}



/*
//Note : Toutes les privateiables sont sur 32 bits

//Définir r comme suit : 
var entier[64] r, k
r[ 0..15] := {7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22,  7, 12, 17, 22}
r[16..31] := {5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20,  5,  9, 14, 20}
r[32..47] := {4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23,  4, 11, 16, 23}
r[48..63] := {6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21,  6, 10, 15, 21}

//MD5 utilise des sinus d'entiers pour ses constantes :
pour i de 0 à 63 faire
  k[i] := floor(abs(sin(i + 1)) × 2^32)
fin pour

//Préparation des variables :
var entier h0 := 0x67452301
var entier h1 := 0xEFCDAB89
var entier h2 := 0x98BADCFE
var entier h3 := 0x10325476

//Préparation du message (padding) :
ajouter le bit "1" au message
ajouter le bit "0" jusqu'à ce que la taille du message en bits soit égale à 448 (mod 512)
ajouter la taille du message codée en 64-bit little-endian au message

//Découpage en blocs de 512 bits :
pour chaque bloc de 512 bits du message
  subdiviser en 16 mots de 32 bits en little-endian w[i], 0 ≤ i ≤ 15

  //initialiser les valeurs de hachage :
  var entier a := h0
  var entier b := h1
  var entier c := h2
  var entier d := h3

  //Boucle principale :
  pour i de 0 à 63 faire
      si 0 ≤ i ≤ 15 alors
            f := (b et c) ou ((non b) et d)
            g := i
      sinon si 16 ≤ i ≤ 31 alors
            f := (d et b) ou ((non d) et c)
            g := (5×i + 1) mod 16
      sinon si 32 ≤ i ≤ 47 alors
            f := b xor c xor d
            g := (3×i + 5) mod 16
      sinon si 48 ≤ i ≤ 63 alors
          f := c xor (b ou (non d))
          g := (7×i) mod 16
      fin si
      var entier temp := d
      d := c
      c := b
      b := ((a + f + k[i] + w[g]) leftrotate r[i]) + b
      a := temp
  fin pour

  //ajouter le résultat au bloc précédent :
  h0 := h0 + a
  h1 := h1 + b 
  h2 := h2 + c
  h3 := h3 + d
fin pour

var entier empreinte := h0 concaténer h1 concaténer h2 concaténer h3 //(en little-endian)
 */