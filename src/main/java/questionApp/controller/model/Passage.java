package questionApp.controller.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import questionApp.service.dto.PassageDTO;
@Entity(name="passage")
public class Passage {

	@Id
	@GeneratedValue
	private Integer id;
	private String difficulty;
	private String description;
	private String name;
	@OneToMany(mappedBy = "passage", cascade = CascadeType.ALL)
	private Set<Question> questions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void assemble(PassageDTO passageDTO, Passage passage) {
		this.name = passageDTO.getName();
		this.difficulty = passageDTO.getDifficulty();
		this.description = passageDTO.getDescription();
		this.id= passageDTO.getId();
		
	}
	
	
}
