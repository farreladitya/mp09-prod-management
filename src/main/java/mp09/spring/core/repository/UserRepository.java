package mp09.spring.core.repository;

import mp09.spring.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Long countById(Integer id);
}
