package br.com.juan.word.model;

public class Correction {
	private int id;
	private Word word;
	private Teacher teacher;
	private String comment;
	
	public Correction(Word word) {
		this.word = word;
	}
	
	public Correction(Word word, Teacher teacher) {
		this.word = word;
		this.teacher = teacher;
	}
	
	
	public Correction(Word word, Teacher teacher, String comment) {
		super();
		this.word = word;
		this.teacher = teacher;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Correction [id=" + id + ", word=" + word + ", teacher=" + teacher + ", comment=" + comment + "]";
	}
	
	
	
}
