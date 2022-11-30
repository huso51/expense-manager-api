package tr.com.huseyinaydin.expensetrackerapi.service;

import tr.com.huseyinaydin.expensetrackerapi.entity.User;
import tr.com.huseyinaydin.expensetrackerapi.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel user);
	
	User readUser();
	
	User updateUser(UserModel user);
	
	void deleteUser();
	
	User getLoggedInUser();
}
