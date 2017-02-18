package questionApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import questionApp.controller.model.Question;
import questionApp.controller.model.Subject;
import questionApp.dao.QuestionRepository;
import questionApp.dao.SubjectRepository;
@Service
@Transactional
public class SubjectService {
	private final SubjectRepository subjectRepository;
	public SubjectService(SubjectRepository subjectRepository){
		this.subjectRepository = subjectRepository;
	}
	
	public List<Subject> findAll(){
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		for(Subject subject : this.subjectRepository.findAll()){
			subjects.add(subject);
		}
		return subjects;
	}
	public Subject findSubject(int id){
		return this.subjectRepository.findOne(id);
	}
	public void save(Subject subject){
		this.subjectRepository.save(subject);
	}
	public void delete(Subject subject){
		this.subjectRepository.delete(subject);
	}
	public void delete(int id){
		this.subjectRepository.delete(id);
	}

}
