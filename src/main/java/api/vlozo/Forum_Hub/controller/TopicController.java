package api.vlozo.Forum_Hub.controller;

import api.vlozo.Forum_Hub.dto.request.CreateTopicDTO;
import api.vlozo.Forum_Hub.dto.request.UpdateTopicDTO;
import api.vlozo.Forum_Hub.dto.response.TopicDTO;
import api.vlozo.Forum_Hub.repository.TopicRepository;
import api.vlozo.Forum_Hub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService service;

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateTopicDTO data, Authentication authentication, UriComponentsBuilder uriBuilder) throws Exception {
        var loggedUser = authentication.getName();
        var topic = service.registerTopic(data, loggedUser);
        repository.save(topic);
        var uri = uriBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> list(@PageableDefault(size = 10, sort = {"course"}) Pageable pagination){
        var page = repository.findAll(pagination).map(TopicDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody UpdateTopicDTO data, Authentication authentication, @PathVariable Long id) throws Exception {
        var loggedUser = authentication.getName();
        var topic = service.updateTopic(data, loggedUser, id);
        return ResponseEntity.ok(new TopicDTO(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id, Authentication authentication) throws Exception {
        var loggedUser = authentication.getName();
        var topic = service.deleteTopic(loggedUser, id);
        repository.delete(topic);
        return ResponseEntity.noContent().build();
    }
}
