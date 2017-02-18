package questionApp.controller.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue
	@Column(name="subjectID")
	private int subjectID;
	@Column(name="subjectName")
	private String subjectName;
	
	@OneToMany(mappedBy = "relatedSubject", cascade = CascadeType.ALL)
	private Set<Question> questions;
	public Subject(){
		
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Set<Question> getQuestions(){
		return questions;
	}
	public void setQuestions(Set<Question> questions){
		this.questions = questions;
	}
}
