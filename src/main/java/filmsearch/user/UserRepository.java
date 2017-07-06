package filmsearch.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Stas on 28-Nov-16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
