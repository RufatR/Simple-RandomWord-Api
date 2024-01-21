package az.div.springdemo.service;

import az.div.springdemo.entity.RandomWordEntity;
import az.div.springdemo.repository.RandomWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class RandomWordService implements RandomWordServiceInter {

    private final RandomWordRepository repository;

    @Autowired
    RestTemplate restTemplate;

    public RandomWordService(RandomWordRepository repository) {
        this.repository = repository;
    }


    @Override
    public String getWord() {
        List<RandomWordEntity> allWords = repository.findAll();
        int randomId = new Random().nextInt(allWords.size()-1);
        return allWords.get(randomId).getWords();
    }

    @Override
    public void addWord() {

        for (int i = 0; i < 50 ; i++) {
            String wordFromUrl = restTemplate.getForObject("https://random-word-api.herokuapp.com/word", String.class);
            String cleanWord = wordFromUrl.replace("[\"", "").replace("\"]", "");
            RandomWordEntity randomWordEntity = RandomWordEntity.builder().words(cleanWord).length(cleanWord.length()).build();
            repository.save(randomWordEntity);
        }

    }
}
