package com.gfg.jatin.minor.SpringBootBackendService.service;

import com.gfg.jatin.minor.SpringBootBackendService.model.User;
import com.gfg.jatin.minor.SpringBootBackendService.repository.RepositoryJpa;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ServiceLayer {

    /*
    1. List<User> findAllUsers()
	2. User findUserById(Long id)
	3. User createUser(User user)
	4. User updateUser(User user)
	5. void deleteUser(Long id)
     */

    @Autowired
    RepositoryJpa userrepo;
    public List<User> findAllUsers(){
        return userrepo.findAll();
    }

    public User findUserById(Long id){
        Optional<User> optionalUser = userrepo.findById(id);
        if(optionalUser.isPresent()) {
            log.debug("User with id {} is {}", id, optionalUser.get());
        } else {
            throw new IllegalIdentifierException("Id not found!");
        }
        return optionalUser.get();
    }

    public User createUser(User user){
        userrepo.save(user);
        return user;
    }

    public User updateUser(User user){
        if (userrepo.findById(user.getId()) == null)
            return null;

        userrepo.save(user);
        return user;

    }



    public User deleteUser(Long id) {
        User user = findUserById(id);
        userrepo.delete(user);
        return user;
    }

}
