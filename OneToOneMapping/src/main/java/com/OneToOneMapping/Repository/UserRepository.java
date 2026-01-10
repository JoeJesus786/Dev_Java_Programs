package com.OneToOneMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OneToOneMapping.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
