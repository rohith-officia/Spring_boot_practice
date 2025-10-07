package com.example.Spring_Boot_Practice.Repository;

import com.example.Spring_Boot_Practice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity , Long > {//"JPA"

}
