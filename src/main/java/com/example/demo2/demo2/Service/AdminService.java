package com.example.demo2.demo2.Service;

import com.example.demo2.demo2.Dto.AddTripDto;
import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Entity.AddTripEntity;
import com.example.demo2.demo2.Entity.MemberEntity;
import com.example.demo2.demo2.Repository.AddTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
  private final AddTripRepository addTripRepository;
    public void save(AddTripDto addTripDto) {
        AddTripEntity addTripEntity = AddTripEntity.toAddTripEntity(addTripDto);
        addTripRepository.save(addTripEntity);
        }

    public List<AddTripDto> findAlltrip() {
        List<AddTripEntity> addTripEntityList = addTripRepository.findAll();
        List<AddTripDto> addTripDtoList = new ArrayList<>();
        for(AddTripEntity addTripEntity: addTripEntityList){
            addTripDtoList.add(AddTripDto.toAddTripDTO(addTripEntity));
        }
        return addTripDtoList;
    }

    public void deleteBytNum(Long tNum) {
        addTripRepository.deleteById(tNum);
    }

    public AddTripDto findBytNum(Long tNum) {
        Optional<AddTripEntity> optionalAddTripEntity = addTripRepository.findBytNum(tNum);
        if(optionalAddTripEntity.isPresent()){
            return AddTripDto.toAddTripDTO(optionalAddTripEntity.get());
        }else return null;
    }

}
