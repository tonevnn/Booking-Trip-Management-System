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
public class Ticket {
    private int ticketId;
    private Date bookingTime;
    private String customerName;
    private String licensePlate;
    private int tripId;
}
