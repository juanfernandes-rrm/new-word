package br.com.juan.word.model;

public class Student extends User{
	int numEnroll;

	public int getNumEnroll() {
		return numEnroll;
	}

	public void setNumEnroll(int numEnroll) {
		this.numEnroll = numEnroll;
	}
	
	
	public Student() {
		this.role="Student";
	}
}
