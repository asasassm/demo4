package com.example.demo2.demo2.Entity;

import com.example.demo2.demo2.Dto.MemberDto;
import com.example.demo2.demo2.Dto.TripDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "trip")
public class TripEntity {
    //고객 여행지 리스트(장바구니)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripNum;
    @ManyToOne
    @JoinColumn(name = "userNum")
    private MemberEntity memberEntity;
    @Column(columnDefinition = "varchar(20)")
    private String tripName;
    @Column(columnDefinition = "varchar(30)")
    private String tripAdr;
    @Column(columnDefinition = "varchar(30)")
    private String tripX;
    @Column(columnDefinition = "varchar(30)")
    private String tripY;

    public static TripEntity toTripEntity(TripDto tripDto){
        TripEntity tripEntity = new TripEntity();
        tripEntity.setTripNum(tripDto.getTripNum());
        tripEntity.setTripName(tripDto.getTripName());
        tripEntity.setTripX(tripDto.getTripX());
        tripEntity.setTripY(tripDto.getTripY());

        return tripEntity;
    }


}
