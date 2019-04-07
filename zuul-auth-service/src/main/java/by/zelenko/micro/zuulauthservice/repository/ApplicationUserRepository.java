package by.zelenko.micro.zuulauthservice.repository;

import by.zelenko.micro.zuulauthservice.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository <ApplicationUser,Long> {

    public ApplicationUser findByUserName(String userName);
}
