package aplicacao;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import entidade.Funcionario;

/*Fazer um programa para ler um n�mero inteiro N e depois os dados (id, nome e salario) de
N funcion�rios. N�o deve haver repeti��o de id.
Em seguida, efetuar o aumento de X por cento no sal�rio de um determinado funcion�rio.
Para isso, o programa deve ler um id e o valor X. Se o id informado n�o existir, mostrar uma
mensagem e abortar a opera��o. Ao final, mostrar a listagem atualizada dos funcion�rios,
conforme exemplos.
Lembre-se de aplicar a t�cnica de encapsulamento para n�o permitir que o sal�rio possa
ser mudado livremente. Um sal�rio s� pode ser aumentado com base em uma opera��o de
aumento por porcentagem dada.*/

public class Programa {

	public static void main(String[] args) {

		Scanner ent = new Scanner(System.in);

		// List<ClasseObjeto> vari�vel = new ArrayList<>(); Forma de criar uma objeto
		// numa lista.
		List<Funcionario> listaFunc = new ArrayList<>();

		System.out.println("Quantos funcion�rios ser�o registrados?");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Funcionario: " + i + ": ");
			System.out.println("ID: ");
			int id = ent.nextInt();
			ent.nextLine();
			System.out.println("Nome: ");
			String nome = ent.nextLine();
			System.out.println("Sal�rio: ");
			double salario = ent.nextDouble();
			listaFunc.add(new Funcionario(id, nome, salario));
		}

		System.out.println("Informe o ID do funcion�rio que ter� seu sal�rio acrescido a comiss�o: ");
		int id = ent.nextInt();

		Funcionario funcionario = listaFunc.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		// Filtrando o Id existente na lista, caso atenda a condi��o, pegar� o primeiro,
		// e caso n�o atenda a condi��o, ser� nulo.

		if (funcionario == null) {// Caso o Id seja nulo.
			System.out.println("Esse ID n�o existe!");
		}

		else {// Caso o Id seja v�lido.
			System.out.print("Informe o percentual que ser� acrescido: ");
			double comissao = ent.nextDouble();
			funcionario.salMaisComissao(comissao);
		}

		System.out.println();
		System.out.println("Lista de funcion�rios:");

		for (Funcionario funcionarios : listaFunc) {
			System.out.println(funcionarios);// Imprimindo lista de funcionarios atualizada.
		}

		ent.close();

	}

}
