package br.com.juan.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Palavra> palavras = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	public void adicionaPalavra(Palavra palavra) {
		palavra.setId(chaveSequencial);
		palavras.add(palavra);
	}
	
	public void removePalavra(Integer id){
		Iterator<Palavra> it = palavras.iterator();
		
		while(it.hasNext()) {
			Palavra p = it.next();
			if(p.getId() == id) {
				it.remove();
			}
		}
	}

	public static List<Palavra> getPalavras() {
		return palavras;
	}
	
	
}
