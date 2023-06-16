package com.example.demo2.demo2.Dto;

import com.example.demo2.demo2.Entity.TripEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TripDto {
    private Long tripNum;
    private Long userNum;
    private String tripName;
    private String tripAdr;
    private String tripX;
    private String tripY;


    public static TripDto toTripDTO(TripEntity tripEntity){
        TripDto tripDto = new TripDto();
        tripDto.setTripNum(tripEntity.getTripNum());
        tripDto.setTripName(tripEntity.getTripName());
        tripDto.setTripAdr(tripEntity.getTripAdr());
        tripDto.setTripX(tripEntity.getTripX());
        tripDto.setTripY(tripEntity.getTripY());

        return tripDto;
    }

}
