package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Estudante;

public class ManipulacaoArquivos {

	private static String caminho = "C:\\temp\\estudantes.csv";

	public static void adicionar(Estudante estudante) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminho,true))){
			bufferedWriter.write(estudante.getNome());
			bufferedWriter.write(";");
			bufferedWriter.write(estudante.getCurso());
			bufferedWriter.write(";");
			bufferedWriter.write(estudante.getMatricula());
			bufferedWriter.newLine();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static List<Estudante> listar(){
		List<Estudante> estudantes = new ArrayList<Estudante>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))){
			String line = bufferedReader.readLine();
			while (line != null) {
				String [] campos = line.split(";");
				Estudante estudante = new Estudante(campos[0], campos[1], campos[2]);
				estudantes.add(estudante);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		}
		return estudantes;
	}
}