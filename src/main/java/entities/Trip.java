package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
public class Trip {
    private int tripId;
    private int bookedTicketNumber;
    private String carType;
    private Date departureDate;
    private Date departureTime;
    private String destination;
    private String driver;
    private int maximumOnlineTicketNumber;
}
