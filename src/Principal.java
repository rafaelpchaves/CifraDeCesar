import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		int chave = Integer.MAX_VALUE;

		do {
			chave=  rand.nextInt(10);	
		} while (chave==0);
		
		System.out.println("Chave= "+ chave);
		System.out.println("Digite a mensagem a ser criptografada - tudo minusculo");
		String original = scanner.nextLine();

		String criptografada = criptografar(original, chave);
		System.out.println("Mensagem criptografada= "+criptografada);

		String descriptografada = descriptografar(criptografada, chave);
		System.out.println("Mensagem descriptografada= "+descriptografada);
	}

	public static String criptografar(String mensagem, int chave) {
		String criptografada = "";

		for (int i = 0; i < mensagem.length(); i++) {
			int caractere = mensagem.charAt(i);
			caractere = caractere + (chave % 26);
			if (caractere > 'z')
				caractere = caractere - 26;
			criptografada += (char) caractere;
		}

		return criptografada;
	}

	public static String descriptografar(String mensagem, int chave) {
		String descriptografada = "";

		for (int i = 0; i < mensagem.length(); i++) {
			int caractere = mensagem.charAt(i);
			caractere = caractere - (chave % 26);
			if (caractere < 'a')
				caractere = caractere + 26;
			descriptografada += (char) caractere;
		}

		return descriptografada;
	}

}
