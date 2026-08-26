package mn.icode.service;

import org.springframework.stereotype.Service;

import mn.icode.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
