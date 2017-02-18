package questionApp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import questionApp.controller.model.Passage;
import questionApp.controller.model.Question;
import questionApp.controller.model.Subject;
import questionApp.service.PassageService;
import questionApp.service.QuestionService;
import questionApp.service.SubjectService;
import questionApp.service.dto.PassageDTO;
import questionApp.service.dto.QuestionDTO;

@Controller
public class MainController {
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private PassageService passageService;
	
	
	
	@GetMapping("/prepapp")
	public String home(HttpServletRequest request) {
		request.setAttribute("notes", questionService.findAll());
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	@GetMapping("/all-question")
	public String allQuestions(HttpServletRequest request){
		request.setAttribute("questions", questionService.findAll());
		request.setAttribute("mode", "MODE_QUESTIONS");
		return "index";
	}
	@GetMapping("/all-passages")
	public String allPassages(HttpServletRequest request){
		request.setAttribute("passages", passageService.findAll());
		request.setAttribute("mode", "MODE_PASSAGES");
		return "index";
	}
	@GetMapping("/new-question")
	public String newQuestion(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	@GetMapping("/new-passage-question")
	public String newPassageQuestion(@RequestParam int id,HttpServletRequest request){
		
		request.setAttribute("passage", passageService.findPassage(id));
		request.setAttribute("mode", "MODE_NEWPASSAGEQUESTION");
		return "managePassageQuestions";
	}
	@PostMapping("/save-passage-question")
	public String savePassageQuestion(@RequestParam int passageid,@ModelAttribute("question") QuestionDTO questionDTO, HttpServletRequest request){
		questionDTO.setSubjectID("2");
		questionService.save(questionDTO, passageService.findPassage(passageid), subjectService.findSubject(2));
		request.setAttribute("passage", passageService.findPassage(passageid));
		request.setAttribute("mode", "MODE_NEWPASSAGEQUESTION");
		return "managePassageQuestions";
	}
	@PostMapping("/save-question")
	public String saveQuestion(@ModelAttribute("productDTO") QuestionDTO questionDTO, HttpServletRequest request/*@ModelAttribute Question question, BindingResult bindingResult,*/){
		questionService.save(questionDTO, subjectService);
		request.setAttribute("questions", questionService.findAll());
//		request.setAttribute("mode", "MODE_QUESTIONS");
		return "index";
	}
	@PostMapping("/save-passage")
	public String savePassage(@ModelAttribute("passage") Passage passage, HttpServletRequest request/*@ModelAttribute Question question, BindingResult bindingResult,*/){
		
		passageService.save(passage);
		request.setAttribute("passages", passageService.findAll());
//		request.setAttribute("mode", "MODE_PASSAGES");
		return "index";
	}
	@GetMapping("/update-question")
	public String updateQuestion(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("note", questionService.findQuestion(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	@GetMapping("/delete-question")
	public String deleteNote(@RequestParam int id, HttpServletRequest request){
		questionService.delete(id);
		request.setAttribute("questions", questionService.findAll());
		request.setAttribute("mode", "MODE_QUESTIONS");
		return "index";
	}
	@GetMapping("/delete-passage")
	public String deletePassage(@RequestParam int id, HttpServletRequest request){
		passageService.delete(id);
		request.setAttribute("passages", passageService.findAll());
		request.setAttribute("mode", "MODE_PASSAGES");
		return "index";
	}
	
	

}
