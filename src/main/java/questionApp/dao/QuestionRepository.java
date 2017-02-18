package questionApp.dao;

import org.springframework.data.repository.CrudRepository;

import questionApp.controller.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
