package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Car {
    private String licensePlate;
    private String carColor;
    private String carType;
    private int company;
    private int parkId;
}
