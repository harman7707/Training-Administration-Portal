package project.demo.dao;

import project.demo.entities.User;

public interface UserDao {
	int registerUser(User user);

	User isUserRegistered(String username, String password);

}
