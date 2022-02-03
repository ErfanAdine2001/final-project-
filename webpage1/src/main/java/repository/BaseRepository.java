package repository;

import entity.User;

public interface BaseRepository {

    User getUserById(Integer id);

    User saveUser(User b);

    void deleteUser(Integer id);
}
