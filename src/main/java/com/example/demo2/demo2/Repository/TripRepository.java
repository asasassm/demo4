package com.example.demo2.demo2.Repository;

import com.example.demo2.demo2.Entity.MemberEntity;
import com.example.demo2.demo2.Entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
    Optional<TripEntity> findByTripNum(Long tripNum);
    Optional<MemberEntity> findByTripName(String tripName);


}
