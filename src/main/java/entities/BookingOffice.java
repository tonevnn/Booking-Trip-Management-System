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
public class BookingOffice {
    private int officeId;
    private Date endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private double officePrice;
    private Date startContractDeadline;
    private int tripId;
}
