package br.com.juan.word.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Word> words = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	public void addWord(Word word) {
		word.setId(chaveSequencial++);
		words.add(word);
	}
	
	public void deleteWord(Integer id){
		Iterator<Word> it = words.iterator();
		
		while(it.hasNext()) {
			Word p = it.next();
			if(p.getId() == id) {
				it.remove();
			}
		}
	}

	public static List<Word> getWords() {
		return words;
	}
	
	public Word getWordById(int id) {
		for(Word word:words) {
			if(word.getId()==id) {
				return word;
			}
		}
		return null;
	}
	
	
}
