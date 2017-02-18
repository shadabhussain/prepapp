package questionApp.controller.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import questionApp.service.dto.QuestionDTO;


@Entity(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int questionID;
	private String type;
	private String subtype;
	private String description;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	private String answer;
	private boolean isanswered;
	@ManyToOne
	@JoinColumn(name = "passageID")
	private Passage passage;
	 @ManyToOne
	 @JoinColumn(name = "subjectID")
	private Subject relatedSubject;
	
	public Question(){
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}

	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getIsAnswered() {
		return isanswered;
	}

	public void setIsAnswered(boolean isAnswered) {
		this.isanswered = isAnswered;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIsanswered() {
		return isanswered;
	}

	public void setIsanswered(boolean isanswered) {
		this.isanswered = isanswered;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	
	

	public Subject getRelatedSubject() {
		return relatedSubject;
	}

	public void setRelatedSubject(Subject relatedSubject) {
		this.relatedSubject = relatedSubject;
	}

	public Passage getPassage() {
		return passage;
	}

	public void setPassageId(Passage passage) {
		this.passage = passage;
	}

	public void assemble(QuestionDTO questionDTO, Passage passage, Subject subject) {

		this.passage = passage;
		this.questionID = questionDTO.getQuestionID();
		this.type = questionDTO.getType();
		this.description = questionDTO.getDescription();
		this.option1 = questionDTO.getOption1();
		this.option2 = questionDTO.getOption2();
		this.option3 = questionDTO.getOption3();
		this.option4 = questionDTO.getOption4();
		this.option5 = questionDTO.getOption5();
		this.answer = questionDTO.getAnswer();
		this.isanswered = questionDTO.isIsanswered();
		this.relatedSubject = subject;
		
		
		
	}
	
	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public void setPassage(Passage passage) {
		this.passage = passage;
	}

	public void assemble(QuestionDTO questionDTO, Subject subject) {

		this.relatedSubject = subject;
		this.questionID = questionDTO.getQuestionID();
		this.type = questionDTO.getType();
		this.subtype = questionDTO.getSubtype();
		this.description = questionDTO.getDescription();
		this.option1 = questionDTO.getOption1();
		this.option2 = questionDTO.getOption2();
		this.option3 = questionDTO.getOption3();
		this.option4 = questionDTO.getOption4();
		this.option5 = questionDTO.getOption5();
		this.answer = questionDTO.getAnswer();
		this.isanswered = questionDTO.isIsanswered();
		
		
		
	}

}
