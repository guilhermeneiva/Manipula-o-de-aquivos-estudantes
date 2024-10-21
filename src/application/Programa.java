package application;

import java.util.List;

import entities.Estudante;

public class Programa {

	public static void main(String[] args) {

		ManipulacaoArquivos.adicionar(new Estudante("Guilherme", "Engheria de Software", "12547789-E"));

		List<Estudante> estudantes = ManipulacaoArquivos.listar();
		for (Estudante estudante : estudantes) {
			System.out.println(estudante.toString());
		}
	}
}