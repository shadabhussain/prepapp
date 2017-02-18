package questionApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import questionApp.controller.model.Passage;
import questionApp.controller.model.Question;
import questionApp.controller.model.Subject;
import questionApp.dao.PassageRepository;
import questionApp.dao.QuestionRepository;
import questionApp.service.dto.PassageDTO;
import questionApp.service.dto.QuestionDTO;

@Service
@Transactional
public class PassageService {
	
	private final PassageRepository passageRepository;
	public PassageService(PassageRepository passageRepository){
		this.passageRepository = passageRepository;
	}
	
	public List<Passage> findAll(){
		ArrayList<Passage> passages = new ArrayList<Passage>();
		for(Passage passage : this.passageRepository.findAll()){
			passages.add(passage);
		}
		return passages;
	}
	public Passage findPassage(int id){
		return this.passageRepository.findOne(id);
	}
	public void save(Passage passage){
//		Passage passage = new Passage();
//		passage.assemble(passageDTO, passage);
		this.passageRepository.save(passage);
	}
	public void delete(Passage passage){
		this.passageRepository.delete(passage);
	}
	public void delete(int id){
		this.passageRepository.delete(id);
	}

}
