package questionApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.xbean.spring.context.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import questionApp.controller.model.Subject;
import questionApp.controller.model.Passage;
import questionApp.controller.model.Question;
import questionApp.dao.QuestionRepository;
import questionApp.service.dto.QuestionDTO;

@Service
@Transactional
public class QuestionService {

	private final QuestionRepository questionRepository;
	public QuestionService(QuestionRepository questionRepository){
		this.questionRepository = questionRepository;
	}
	
	public List<Question> findAll(){
		ArrayList<Question> questions = new ArrayList<Question>();
		for(Question question : this.questionRepository.findAll()){
			questions.add(question);
		}
		return questions;
	}
	public Question findQuestion(int id){
		return this.questionRepository.findOne(id);
	}
	public void save(QuestionDTO questionDTO, SubjectService subjectService){
		Subject subject = subjectService.findSubject(Integer.parseInt(questionDTO.getSubjectID()));
		
		Question question = new Question();
		question.assemble(questionDTO, subject);
		this.questionRepository.save(question);
	}
	public void delete(Question question){
		this.questionRepository.delete(question);
	}
	public void delete(int id){
		this.questionRepository.delete(id);
	}

	public void save(QuestionDTO questionDTO, Passage passage, Subject subject) {
		
		Question question = new Question();
		
		question.assemble(questionDTO, passage,subject);
		this.questionRepository.save(question);
		
	}
}
