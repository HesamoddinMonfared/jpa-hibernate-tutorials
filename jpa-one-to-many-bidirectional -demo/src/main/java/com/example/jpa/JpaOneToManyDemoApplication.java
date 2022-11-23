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
import java.util.Optional;
import java.util.Set;

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
		example_2();
	}

	private void example_1() {
		//=========================================

		// Create a Post
		Post post = new Post();
		post.setTitle("post title");
		post.setDescription("post description");
		post.setContent("post content");

		// Create Comments
		Comment comment1 = new Comment();
		comment1.setText("Great Post!");
		comment1.setPost(post);
		Comment comment2 = new Comment();
		comment2.setText("Really helpful Post. Thanks a lot!");
		comment2.setPost(post);

		// Add comments in the Post
		post.getComments().add(comment1);
		post.getComments().add(comment2);

		// Save Post and Comments via the Post entity
		postRepository.save(post);

		//=========================================
	}

	private void example_2() {
		// Retrieve Post
		Long postId = 1L;
		Optional<Post> post = postRepository.findById(postId);

		// Get all the comments
		Set<Comment> comments;
		if (post.isPresent())
			comments = post.get().getComments();
	}
}
