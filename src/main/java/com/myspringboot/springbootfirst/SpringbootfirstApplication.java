package com.myspringboot.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// import com.myspringboot.springbootfirst.dao.UserRepository;
// import com.myspringboot.springbootfirst.entities.Book;
// import com.myspringboot.springbootfirst.entities.User;
import com.myspringboot.springbootfirst.services.BookService;

@SpringBootApplication
public class SpringbootfirstApplication {

	public static void main(String[] applicationArguments) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootfirstApplication.class,
				applicationArguments);

		System.out.println("Application is running...");

		// UserRepository uRepo = context.getBean(UserRepository.class);
		BookService bService = context.getBean(BookService.class);

		// Syntax to save Single user
		// User user = new User("Utkarsh", "utkarsh@gmail.com", "lucknow", "active");

		// User resultUser = uRepo.save(user);

		// User user1 = new User("Ankit", "ankit@gmail.com", "lucknow", "active");
		// User user2 = new User("Devish", "devish@gmail.com", "noida", "active");
		// User user3 = new User("Abhishek", "abhishek@gmail.com", "lucknow", "absent");
		// User user4 = new User("Vishal", "vishal@gmail.com", "lucknow", "active");
		// Used to insert multiple objects at once
		// Iterable<User> resultUsers = uRepo.saveAll(List.of(user1, user2, user3,
		// user4));
		// resultUsers.forEach(user -> System.out.println(user));

		// Updating one single object with ID 2

		// Optional<User> user = uRepo.findById(2L);
		// User resultUser = user.get();

		// OR

		// Simple and easy way to get one object
		// User user = uRepo.findById(2L).get();
		// System.out.println("Old Object:" + user);
		// user.setCity("Mumbai");
		// user.setEmail("ankitshukla32@gmail.com");
		// uRepo.save(user);
		// System.out.println("New Object:" + user);

		// Deleting one single User with ID 52
		// uRepo.deleteById(52L);
		// uRepo.deleteById(53L);
		// uRepo.deleteById(54L);
		// uRepo.deleteById(55L);

		// Fetching all users
		// Iterable<User> resultUsers = uRepo.findAll();
		// resultUsers.forEach(user -> System.out.println(user));

		// List<User> userList = uRepo.findByStatus("active");

		// userList.forEach(user -> System.out.println(user));

		// Book book = new Book(101, "My Book", "John Doe");

		// System.out.println(bService.getAllBooks());

		// Book resultBook = bService.saveBook(book);
		// Book result = bService.getBookById(1);
		// System.out.println(result);

		// System.out.println(resultBook);

	}

}