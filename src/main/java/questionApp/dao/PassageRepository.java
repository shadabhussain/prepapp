package questionApp.dao;

import org.springframework.data.repository.CrudRepository;

import questionApp.controller.model.Passage;

public interface PassageRepository  extends CrudRepository<Passage, Integer>{

}
