package org.fernando.users.service;


import org.fernando.users.model.User;
import java.util.List;


public interface IUserService {

        public User save(User user) throws Exception;

        public User update(User user , Integer id ) throws Exception;

        public List<User> readAll() throws Exception;

        public User readById(Integer id) throws Exception;

        public void delete(Integer id) throws Exception;



}
