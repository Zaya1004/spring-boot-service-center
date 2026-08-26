package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
