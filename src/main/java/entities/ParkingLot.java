package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ParkingLot {
    private int parkId;
    private double parkArea;
    private String parkName;
    private String parkPlace;
    private double parkPrice;
    private String parkStatus;
}
