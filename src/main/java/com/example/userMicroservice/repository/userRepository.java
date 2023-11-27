package com.example.userMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.userMicroservice.domain.user;
import com.example.userMicroservice.enums.centerOfInterest;

import java.util.List;

@Repository()
public interface userRepository extends JpaRepository<user,Long> {
    public user findByEmail(String email);
    public List<user> findByCenterOfInterestAndActivateNotifications(centerOfInterest centerOfInterest,Boolean isActivated);
    //public List<user> findByCenterOfInterest();
}
