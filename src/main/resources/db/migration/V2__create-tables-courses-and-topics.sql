create table courses(
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    category varchar(255) not null
 );

 create table topics(
    id bigint auto_increment primary key,
    title varchar(255) not null,
    message text not null,
    created_date datetime,
    topic_status varchar(100) not null,
    author_id bigint,
    course_id bigint,
    foreign key (author_id) references users(id),
    foreign key (course_id) references courses(id)
 );