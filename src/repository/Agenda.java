package repository;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private static List<Pessoa> pessoas = new ArrayList<>();

	public static void adicionar (Pessoa pessoa){
		pessoas.add(pessoa);
	}
	
	public static List<Pessoa> listar(){
		return pessoas;
	}
}
