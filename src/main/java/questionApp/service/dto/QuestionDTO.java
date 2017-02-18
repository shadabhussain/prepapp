package questionApp.service.dto;

public class QuestionDTO {
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
	private String subjectID;
	private int passageId;
	
	public QuestionDTO(){
		
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
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
	public boolean isIsanswered() {
		return isanswered;
	}
	public void setIsanswered(boolean isanswered) {
		this.isanswered = isanswered;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public int getPassageId() {
		return passageId;
	}
	public void setPassageId(int passageId) {
		this.passageId = passageId;
	}
	
	

}
