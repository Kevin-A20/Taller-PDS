package co.com.poli.serviceusers.repository;

import co.com.poli.serviceusers.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByname(String name);
}
