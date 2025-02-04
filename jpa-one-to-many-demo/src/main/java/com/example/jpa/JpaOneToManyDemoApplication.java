package com.example.jpa;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Calendar;

@SpringBootApplication
@EnableJpaAuditing
public class JpaOneToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		commentRepository.deleteAllInBatch();
		postRepository.deleteAllInBatch();

		example_1();
	}

	private void example_1(){
		//=========================================

		// Create a Post instance
		Post post = new Post();
		post.setContent("Content_1");
		post.setTitle("Title_1");
		post.setDescription("Description_1");


		// Create a Comment instance
		Comment comment_1 = new Comment();
		comment_1.setText("Text_1");
		comment_1.setPost(post);

		Comment comment_2= new Comment();
		comment_2.setText("Text_2");
		comment_2.setPost(post);

		postRepository.save(post);
		commentRepository.save(comment_1);
		commentRepository.save(comment_2);

		//=========================================
	}
}
