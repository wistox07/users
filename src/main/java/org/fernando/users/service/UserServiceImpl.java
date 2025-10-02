package org.fernando.users.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fernando.users.exception.ModelNotFoundException;
import org.fernando.users.model.User;
import org.fernando.users.repo.IUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final IUserRepo userRepo;

    @Override
    public User save(User user) throws Exception {
        return userRepo.save(user);
    }

    @Override
    public User update(User user, Integer id) throws Exception {
        user.setIdUser(id);
        return userRepo.save(user);
    }

    @Override
    public List<User> readAll() throws Exception {
        return userRepo.findAll();
    }

    @Override
    public User readById(Integer id) throws Exception {
        return userRepo.findById(id).orElseThrow(()-> new ModelNotFoundException("Id Not Found " +id));
    }

    @Override
    public void delete(Integer id) throws Exception {
        userRepo.deleteById(id);
    }
}
