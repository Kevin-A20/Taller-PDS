package co.com.poli.serviceusers.service;

import co.com.poli.serviceusers.entities.Users;

import java.util.List;

public interface UsersService {

    void save(Users users);
    void delete(Users users);
    List<Users> findAll();
    Users findById(Long id);
    Users findByname(String users);

}
