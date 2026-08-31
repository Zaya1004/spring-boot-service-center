package mn.icode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mn.icode.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
