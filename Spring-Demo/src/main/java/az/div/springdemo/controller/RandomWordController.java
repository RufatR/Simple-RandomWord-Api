package az.div.springdemo.controller;

import az.div.springdemo.service.RandomWordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/randomword")
public class RandomWordController {

    private final RandomWordService randomWordService;


    public RandomWordController(RandomWordService randomWordService) {
        this.randomWordService = randomWordService;
    }


    @GetMapping
    public String getWord() {
        return randomWordService.getWord();
    }

    @PostMapping
    public int addWord() {
        try {
            randomWordService.addWord();
            return 200;
        } catch (Exception e) {
            return 500;
        }
    }
}
