package com.OneToOneMapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OneToOneMapping.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
