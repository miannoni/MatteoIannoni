package br.pro.hashi.ensino.desagil.tequilada;
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String [] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("test")); // Salvar arquivo em variavel

			String string = br.readLine(); // Ler primeira linha da variavel que contem o arquivo, essa linha tem a informacao de quantas linhas e colunas a matriz do labirinto deve ter
			String[] parts = string.split(" "); // Criar uma variavel que contenha a informacao de linhas e colunas em memorias separadas, permitindo utilizar a informacao independentemente uma da outra
			int x = Integer.parseInt(parts[1]); // Salvar a quantidade de colunas na variavel x
			int y = Integer.parseInt(parts[0]); // Salvar a quantidade de linhas na variavel y

//			As proximas duas linhas printam o valor de x e y para motivos de debug
//			System.out.println("Valor de x: " + Integer.parseInt(parts[1]));
//			System.out.println("Valor de y: " + Integer.parseInt(parts[0]));

//`			Criar uma matriz booleana para guardar a informacao 'Wall' ou 'Nao wall' como 'true' e 'false'
//			respectivamente
			boolean[][] boo = new boolean[y][x];
//			A matriz tem tamanho x por y, informacoes tiradas da primeira linha do arquivo de texto
//			A matriz comeca com todos os valores false

//			Contador j vai nos permitir saber em qual linha e coluna estamos, ele é necessario para
//			podermos salvar na matriz quais valores sao 'true'
			int j = 0;

//			Enquanto a conta j/x for menor que y, portanto, enquanto a linha 'do momento' tiver index
//			menor que y:
			while (j/x < y) {

//				Reutilizar a variavel string do tipo String igual à linha 'do momento' da variavel br
				string = br.readLine();

//				Enquanto o resto da divizao de j/x for menor que x, portanto, enquanto o caracter 'do momento'
//				tiver index menor do que x:
				while (j%x < x) {

//					Se o caracter 'do momento' for igual a um hashtag:
					if (string.charAt(j%x) == '#') {
//						O item na coluna 'do momento' e na linha 'do momento' da matriz boo (matriz do 
//						labirinto) vai ser true
						boo[j/x][j%x] = true;
					}

//					Somar 1 à variavel j, para ela representar quantos itens ja foram levados em conta na
//					matriz, consequentemente nos permitindo saber exatamente em qual linha e coluna estamos
					j++;

//					Se o resto da divisao j/x for zero e o valor de j nao for zero, quebrar esse while -- que
//					serve para iterar de linha em linha, nao criando um while infinito que fica só na primeira
//					linha
					if ((j%x == 0)&&(j != 0)) {
						break;
					}
				}
			}

//			for simples só pra printar todas as linhas contidas na matriz boo por motivos de debug, foi assim
//			que descobri que a matriz boo tinha as linhas e colunas invertidas, o que nao é um problema tao
//			grande mas o codigo feito a partir desse ponto teria que levar esse erro em consideracao, portanto,
//`			é melhor corrigir aqui!
	        for (boolean[] row : boo) {
	        	System.out.println(Arrays.toString(row));
	        }

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
