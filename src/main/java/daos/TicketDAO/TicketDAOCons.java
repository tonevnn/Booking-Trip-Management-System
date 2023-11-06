package daos.TicketDAO;

public class TicketDAOCons {
    public static final String TICKET_QUERY_GET_ALL = "SELECT * FROM ticket";
    public static final String TICKET_QUERY_GET_BY_TICKETID = "SELECT * FROM ticket WHERE ticketId = ?";
    public static final String TICKET_QUERY_INSERT = "INSERT INTO ticket(bookingTime,customerName, licensePlate,tripId) VALUES (?,?,?,?)";
    public static final String TICKET_QUERY_UPDATE = "UPDATE ticket set bookingTime = ?,customerName = ?, licensePlate = ?,tripId = ? where ticketId = ?";
    public static final String TICKET_QUERY_REMOVE_BY_TICKETID = "DELETE FROM ticket WHERE ticketId = ?";
    public static final String TICKET_QUERY_GET_ALL_LICENSE_PLATE = "";
    public static final String TICKET_QUERY_GET_TRIPID_BY_TICKETID = "SELECT tripId FROM ticket WHERE ticketId = ?";
    public static final String TICKET_QUERY_GET_TICKETS_BY_CUSTOMERNAME = "SELECT * FROM ticket where customerName like CONCAT('%',?,'%')";
    public static final String TICKET_QUERY_GET_TICKETS_BY_LICENSEPLATE = "SELECT * FROM ticket where licensePlate like CONCAT('%',?,'%')";
    public static final String TICKET_QUERY_GET_TICKETS_BY_BOOKINGTIME = "SELECT * FROM ticket where bookingTime = ?";
    public static final String SUCCESS = "success";
    public static final String FAIL = "failed";
}
