package zavgorodnyaya.spring_boot.service;

import zavgorodnyaya.spring_boot.dto.SaveDto;
import zavgorodnyaya.spring_boot.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(SaveDto dto);

    void deleteUserById(long id);

    void update(long id, SaveDto dto);

}
