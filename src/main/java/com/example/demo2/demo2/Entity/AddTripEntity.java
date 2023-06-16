package com.example.demo2.demo2.Entity;

import com.example.demo2.demo2.Dto.AddTripDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "adminTrip")
public class AddTripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tNum;
    @Column(columnDefinition = "varchar(20)")
    private String tName;
    @Column(columnDefinition = "varchar(30)")
    private String tRocate;
    @Column(columnDefinition = "varchar(30)")
    private String tX;
    @Column(columnDefinition = "varchar(30)")
    private String tY;


    public static AddTripEntity toAddTripEntity(AddTripDto addTripDto){
        AddTripEntity addTripEntity = new AddTripEntity();
        addTripEntity.setTNum(addTripEntity.getTNum());
        addTripEntity.setTName(addTripDto.getTName());
        addTripEntity.setTRocate(addTripDto.getTRocate());
        addTripEntity.setTX(addTripDto.getTX());
        addTripEntity.setTY(addTripDto.getTY());

        return addTripEntity;
    }


}
