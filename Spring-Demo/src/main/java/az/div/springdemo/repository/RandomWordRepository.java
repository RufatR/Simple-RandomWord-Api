package az.div.springdemo.repository;

import az.div.springdemo.entity.RandomWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomWordRepository extends JpaRepository<RandomWordEntity , Long> {

}
