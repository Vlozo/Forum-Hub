package api.vlozo.Forum_Hub.service;

import api.vlozo.Forum_Hub.domain.Course;
import api.vlozo.Forum_Hub.domain.Topic;
import api.vlozo.Forum_Hub.domain.User;
import api.vlozo.Forum_Hub.dto.request.CreateTopicDTO;

import api.vlozo.Forum_Hub.repository.CourseRepository;
import api.vlozo.Forum_Hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public Topic registerTopic(CreateTopicDTO data, String loggedUser) throws Exception {

        if (!courseRepository.existsById(data.course_id())) {
            throw new Exception("O curso informado não foi encontrado.");
        }

        var author = userRepository.getReferenceByUsername(loggedUser);
        var course = courseRepository.getReferenceById(data.course_id());

        return new Topic(data, course, author);
    }
}
