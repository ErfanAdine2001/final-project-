package service;

import entity.User;
import lombok.NoArgsConstructor;
import repository.UserRepository;

import javax.transaction.Transactional;

@NoArgsConstructor
public class UserService implements BaseService<User,Integer> {
   private static UserRepository userRepository= new UserRepository();


   @Override
   public User save(User entity) {

      return userRepository.saveUser(entity);
   }


   @Override
  public User findById(Integer id) {
      return userRepository.getUserById(id);
   }
}
