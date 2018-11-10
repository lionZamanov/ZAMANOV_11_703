package Repository;

import Models.User;

public interface UsersRepository extends CrudRepository<User>{
    User findOneByEmail(String email);

}
