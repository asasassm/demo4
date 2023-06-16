package com.example.demo2.demo2.Repository;

import com.example.demo2.demo2.Entity.AddTripEntity;
import com.example.demo2.demo2.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddTripRepository extends JpaRepository<AddTripEntity, Long> {
    Optional<AddTripEntity> findBytNum(Long tNum);
//    Optional<AddTripEntity> findBytNameId(String tName);

}
