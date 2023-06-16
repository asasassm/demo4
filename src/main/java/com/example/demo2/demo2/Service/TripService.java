package com.example.demo2.demo2.Service;

import com.example.demo2.demo2.Dto.AddTripDto;
import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Dto.TripDto;
import com.example.demo2.demo2.Entity.AddTripEntity;
import com.example.demo2.demo2.Entity.MemberEntity;
import com.example.demo2.demo2.Entity.TripEntity;
import com.example.demo2.demo2.Repository.MemberRepository;
import com.example.demo2.demo2.Repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public void save(TripDto tripDto) {
        TripEntity tripEntity = TripEntity.toTripEntity(tripDto);
        tripRepository.save(tripEntity);
    }


    public List<TripDto> findAllusertrip() {
        List<TripEntity> tripEntityList = tripRepository.findAll();
        List<TripDto> tripDtoList = new ArrayList<>();
        for(TripEntity tripEntity: tripEntityList){
            tripDtoList.add(TripDto.toTripDTO(tripEntity));
        }
        return tripDtoList;
    }

    public void deleteByNum(Long tripNum) {
        tripRepository.deleteById(tripNum);
    }



}
