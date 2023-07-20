package springDeneme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springDeneme.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
