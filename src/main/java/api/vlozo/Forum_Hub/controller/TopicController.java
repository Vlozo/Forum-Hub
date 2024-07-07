package api.vlozo.Forum_Hub.controller;

import api.vlozo.Forum_Hub.dto.request.CreateTopicDTO;
import api.vlozo.Forum_Hub.dto.response.TopicDTO;
import api.vlozo.Forum_Hub.repository.TopicRepository;
import api.vlozo.Forum_Hub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService service;

    @Autowired
    private TopicRepository repository;

    @PostMapping
    public ResponseEntity createTopic(@RequestBody @Valid CreateTopicDTO data, Authentication authentication) throws Exception {
        var loggedUser = authentication.getName();
        var topic = service.registerTopic(data, loggedUser);
        repository.save(topic);
        return ResponseEntity.ok().body(new TopicDTO(topic));
    }

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body("Hello World");
    }
}
