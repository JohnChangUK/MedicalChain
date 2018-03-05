package EhCacheSpring.Loader;

import EhCacheSpring.Model.Users;
import EhCacheSpring.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loader {

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    public void load() {
        List<Users> usersList = getList();
        usersRepository.save(usersList);
    }

    public List<Users> getList() {
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users("Jay", "Marge", 123L));
        usersList.add(new Users("Teagan", "Marshall", 456L));
        return usersList;
    }
}
