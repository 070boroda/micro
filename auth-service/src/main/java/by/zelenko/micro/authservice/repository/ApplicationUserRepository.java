package by.zelenko.micro.authservice.repository;

import by.zelenko.micro.authservice.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository <ApplicationUser,Long> {

    public ApplicationUser findByUserName(String userName);
}
