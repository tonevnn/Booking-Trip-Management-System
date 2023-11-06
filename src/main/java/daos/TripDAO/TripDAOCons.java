package daos.TripDAO;

public class TripDAOCons {
    public static final String TRIP_QUERY_GET_ALL = "SELECT * FROM trip";
    public static final String TRIP_QUERY_GET_ALL_VALID = "SELECT * FROM trip WHERE bookedTicketNumber < maximumOnlineTicketNumber";
    public static final String TRIP_QUERY_GET_BY_TRIPID = "SELECT * FROM trip WHERE tripId = ?";
    public static final String TRIP_QUERY_INSERT = "INSERT INTO trip(carType,departureDate,departureTime,destination,driver,maximumOnlineTicketNumber,bookedTicketNumber) VALUES (?,?,?,?,?,?,0)";
    public static final String TRIP_QUERY_UPDATE = "UPDATE trip SET carType = ?,departureDate = ?,departureTime = ?,destination = ?,driver = ?,maximumOnlineTicketNumber = ? WHERE tripId = ?";
    public static final String TRIP_QUERY_REMOVE_BY_TRIPID = "DELETE FROM trip WHERE tripId = ?";
    public static final String TRIP_QUERY_GET_DESTINATION_BY_TRIPID = "SELECT destination FROM trip WHERE tripId = ?";
    public static final String TRIP_QUERY_UPDATE_BOOKEDTICKETNUMBER_BY_TRIPID_INCREASE = "UPDATE trip set bookedTicketNumber = (SELECT bookedTicketNumber FROM trip WHERE tripId = ?) + 1 WHERE tripId = ?";
    public static final String TRIP_QUERY_UPDATE_BOOKEDTICKETNUMBER_BY_TRIPID_DECREASE = "UPDATE trip set bookedTicketNumber = (SELECT bookedTicketNumber FROM trip WHERE tripId = ?) - 1 WHERE tripId = ?";
    public static final String TRIP_QUERY_GET_MIN_AND_MAX_YEAR = "SELECT MIN(YEAR(departureDate)) AS 'min', MAX(YEAR(departureDate)) AS 'max' FROM trip";
    public static final String TRIP_QUERY_GET_TRIPS_BY_DESTINATION = "SELECT * FROM trip WHERE destination like CONCAT('%',?,'%')";
    public static final String TRIP_QUERY_GET_TRIPS_BY_TEXT_SEARCH = "SELECT * FROM trip WHERE departureDate >= CONCAT(?,'-',?,'-',?) AND carType LIKE CONCAT('%',?,'%') OR destination LIKE CONCAT('%',?,'%') OR driver LIKE CONCAT('%',?,'%')";
    public static final String TRIP_QUERY_GET_TRIPS_BY_DEPARTURE_DATE = "SELECT * FROM trip WHERE departureDate >= CONCAT(?,'-',?,'-',?)";
    public static final String SUCCESS = "success";
    public static final String FAIL = "failed";
}
