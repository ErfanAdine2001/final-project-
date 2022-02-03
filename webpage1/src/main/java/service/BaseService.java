package service;

import repository.UserRepository;

public interface BaseService<T, ID> {


//    private UserRepository userRepository;
//
//    public BaseService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    T save(T entity);

    T findById(ID id);


}
