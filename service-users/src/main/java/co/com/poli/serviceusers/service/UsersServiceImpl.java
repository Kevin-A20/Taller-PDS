package co.com.poli.serviceusers.service;

import co.com.poli.serviceusers.entities.Users;
import co.com.poli.serviceusers.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Users findById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Users findByname(String name) {
        return usersRepository.findByname(name);
    }
}