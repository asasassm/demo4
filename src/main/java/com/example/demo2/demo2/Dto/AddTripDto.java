package com.example.demo2.demo2.Dto;

import com.example.demo2.demo2.Entity.AddTripEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddTripDto {

    private Long tNum;
    private String tName;
    private String tRocate;
    private String tX;
    private String tY;



    public static AddTripDto toAddTripDTO(AddTripEntity addTripEntity){
        AddTripDto addTripDto = new AddTripDto();
        addTripDto.setTNum(addTripDto.getTNum());
        addTripDto.setTName(addTripEntity.getTName());
        addTripDto.setTRocate(addTripEntity.getTRocate());
        addTripDto.setTX(addTripEntity.getTX());
        addTripDto.setTY(addTripEntity.getTY());

        return addTripDto;

    }


}
