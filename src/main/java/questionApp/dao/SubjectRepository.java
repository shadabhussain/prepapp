package questionApp.dao;

import org.springframework.data.repository.CrudRepository;

import questionApp.controller.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}
