package br.com.juan.word.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Word> words = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	private static Integer chaveSequencialUser = 1;
	
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
		
		
		System.out.println(s1.toString());
		System.out.println(t1.toString());
		users.add(t1);
		users.add(s1);
	}
	
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
	
	public static User searchUser(String username, String password) {
		for(User user:users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	
	
}
