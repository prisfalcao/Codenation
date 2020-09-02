package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> listaFibonacci = new ArrayList<>();
		int num = 0, num1 = 1, fibo = 0;

		listaFibonacci.add(num);
		listaFibonacci.add(num1);

		while (fibo < 350) {
		listaFibonacci.add(fibo = num + num1);
		num = num1;
		num1 = fibo;
		}
		return listaFibonacci;
	}

	public static Boolean isFibonacci(Integer a) {

		return (fibonacci().contains(a));

	}
}