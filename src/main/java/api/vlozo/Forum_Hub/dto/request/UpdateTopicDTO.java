package api.vlozo.Forum_Hub.dto.request;

import api.vlozo.Forum_Hub.domain.TopicStatus;

public record UpdateTopicDTO(String title, String message, Long course_id, TopicStatus status){

}
