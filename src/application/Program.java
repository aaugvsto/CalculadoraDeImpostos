package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> listaPessoas = new ArrayList<>();
		
		System.out.println("<--- Calculadora de Impostos --->");
		System.out.print("\nNúmero de pagantes: ");
		int numPagadores = sc.nextInt();

		for (int i = 1; i <= numPagadores; i++) {
			char pessoa = 'z';
			while (pessoa != 'f' && pessoa != 'j') {
				System.out.print("\nPessoa física ou juridica (f/j)? ");
				pessoa = sc.next().charAt(0);
			}

			String nome = "";
			while (nome == "") {
				System.out.print("Nome: ");
				sc.nextLine();
				nome = sc.nextLine();
			}

			Double rendaAnual = 0.0;
			while (rendaAnual <= 0) {
				System.out.print("Renda anual: ");
				rendaAnual = sc.nextDouble();
			}

			if (pessoa != 'f') {
				int numFunc = 0;
				while (numFunc <= 0) {
					System.out.print("Numero de funcionários: ");
					numFunc = sc.nextInt();
				}
				listaPessoas.add(new PessoaJuridica(nome, rendaAnual, numFunc));
			} else {
				Double gastoSaude = 0.0;
				while (gastoSaude <= 0) {
					System.out.print("Gastos com saúde: ");
					gastoSaude = sc.nextDouble();
					while(gastoSaude >= rendaAnual) {
						System.out.print("[ERRO] Gasto c/ sáude maior ou igual a renda anual! \nDigite novamente: ");
						gastoSaude = sc.nextDouble();
					}
				}
				listaPessoas.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
			}
		}

		System.out.println("\n<-- Lista de Pagamentos -->");
		for (Pessoa pessoa : listaPessoas) {
			System.out.println(pessoa.getNome() + ": R$" + String.format("%.2f", pessoa.calculaImposto()));
		}

		sc.close();

	}

}
