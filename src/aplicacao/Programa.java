package aplicacao;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import entidade.Funcionario;

/*Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
N funcionários. Não deve haver repetição de id.
Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
conforme exemplos.
Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
aumento por porcentagem dada.*/

public class Programa {

	public static void main(String[] args) {

		Scanner ent = new Scanner(System.in);

		// List<ClasseObjeto> variável = new ArrayList<>(); Forma de criar uma objeto
		// numa lista.
		List<Funcionario> listaFunc = new ArrayList<>();

		System.out.println("Quantos funcionários serão registrados?");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Funcionario: " + i + ": ");
			System.out.println("ID: ");
			int id = ent.nextInt();
			ent.nextLine();
			System.out.println("Nome: ");
			String nome = ent.nextLine();
			System.out.println("Salário: ");
			double salario = ent.nextDouble();
			listaFunc.add(new Funcionario(id, nome, salario));
		}

		System.out.println("Informe o ID do funcionário que terá seu salário acrescido a comissão: ");
		int id = ent.nextInt();

		Funcionario funcionario = listaFunc.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		// Filtrando o Id existente na lista, caso atenda a condição, pegará o primeiro,
		// e caso não atenda a condição, será nulo.

		if (funcionario == null) {// Caso o Id seja nulo.
			System.out.println("Esse ID não existe!");
		}

		else {// Caso o Id seja válido.
			System.out.print("Informe o percentual que será acrescido: ");
			double comissao = ent.nextDouble();
			funcionario.salMaisComissao(comissao);
		}

		System.out.println();
		System.out.println("Lista de funcionários:");

		for (Funcionario funcionarios : listaFunc) {
			System.out.println(funcionarios);// Imprimindo lista de funcionarios atualizada.
		}

		ent.close();

	}

}
