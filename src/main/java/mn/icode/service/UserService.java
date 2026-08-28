package mn.icode.service;

import java.util.List;
import java.util.Locale;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mn.icode.dto.UserCreateRequest;
import mn.icode.dto.UserResponse;
import mn.icode.entity.User;
import mn.icode.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public UserResponse createUser(UserCreateRequest request) {
		String email = request.email().trim().toLowerCase(Locale.ROOT);
		
		if(userRepository.existsByEmail(email)) {
		   System.out.println("Email already exists: " + email);
		}
		
		User user = new User();
		user.setFirstName(request.firstName());
		user.setLastName(request.lastName());
		user.setEmail(request.email());
		String encryptedPassword = passwordEncoder.encode(request.password());
		user.setPassword(encryptedPassword);
		user.setPhone(request.phone());
		user.setRole(request.role());
		user.setEnable(true);

		User savedUser = userRepository.save(user);
		return toResponse(savedUser);
	}

	public List<UserResponse>findAllusers(){
		return userRepository.findAll().stream().map(this::toResponse).toList();
	}
	
	private UserResponse toResponse(User user) {
		return new UserResponse(user.getId(), 
				user.getFirstName(),
				user.getLastName(),
				user.getEmail(), 
				user.getPhone(),
				user.getRole(),
				user.isEnable());
	}
}
