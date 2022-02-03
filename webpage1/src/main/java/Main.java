import entity.User;
import service.UserService;

public class Main {
    private static UserService userService = new UserService();

    public static void main(String[] args) {
//
        User user = User.builder().username("erfanadine2001").name("erfan adine").password("123").build();


//        userService.save(user);

        User byId = userService.findById(1);
        System.out.println(byId);

    }
}
