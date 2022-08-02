package br.com.juan.word.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Word> words = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static List<Correction> corrections = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static Integer chaveSequencialUser = 1;
	private static Integer chaveSequencialWord = 1;
	private static Integer chaveSequencialCorrection = 1;
	
	static {
		Student s1 = new Student();
		s1.setId(chaveSequencialUser++);
		s1.setUsername("juan");
		s1.setPassword("1234");
		System.out.println("Banco = s1");
		
		Teacher t1 = new Teacher();
		t1.setId(chaveSequencialUser++);
		t1.setUsername("juan");
		t1.setPassword("12345");
		
		Word w1 = new Word();
		w1.setId(chaveSequencialWord++);
		w1.setContent("test");
		w1.setPhrase("it`s a test");
		words.add(w1);
		
		System.out.println(s1.toString());
		System.out.println(t1.toString());
		users.add(t1);
		users.add(s1);
	}
	
	public void addWord(Word word) {
		word.setId(chaveSequencial++);
		words.add(word);
	}
	
	private void deleteWord(Integer id){
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
	
	public static User searchUser(String username, String password) {
		for(User user:users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User getUserById(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public void addCorrection(Correction correction) {
		correction.setId(chaveSequencialCorrection++);
		corrections.add(correction);
	}

	public Correction getCorrectionById(int id) {
		for(Correction correction:corrections) {
			if(correction.getId()==id) {
				return correction;
			}
		}
		return null;
	}
	
	public static List<Correction> getCorrections() {
		return corrections;
	}

	public void deleteCorrection(int id) {
		Iterator<Correction> it = corrections.iterator();
		
		while(it.hasNext()) {
			Correction correction = it.next();
			if(correction.getId() == id) {
				it.remove();
				deleteWord(correction.getWord().getId());
			}
		}
		
	}
	
	
}
