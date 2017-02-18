package questionApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import questionApp.controller.model.Question;
import questionApp.service.QuestionService;

@RestController
public class SampleRestController {
	
	@Autowired
	private QuestionService noteService;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!!";
	}
	
//	@GetMapping("/all-notes")
//	public String allNotes(){
//		return noteService.findAll().toString();
//	}
//	@PostMapping("/delete-note")
//	public void deleteNote(@RequestBody Note note){
//		this.noteService.delete(note);
//	}
//	@PostMapping("/save-note")
//	public void saveNote(@RequestBody Note note){
//		this.noteService.save(note);
//	}
}
