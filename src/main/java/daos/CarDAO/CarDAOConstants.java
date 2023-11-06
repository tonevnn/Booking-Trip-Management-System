package daos.CarDAO;

public class CarDAOConstants {
    public static final int PAGE_SIZE_CAR = 10;
    public static final String CAR_GET_ALL = "SELECT * FROM car";
    public static final String CAR_ADD = "INSERT INTO car VALUES (?,?,?,?,?)";
    public static final String CAR_UPDATE = "UPDATE car\n" +
            "SET carColor = ?,\n" +
            "carType = ?,\n" +
            "company = ?,\n" +
            "parkId = ? \n" +
            "WHERE licensePlate = ?";
    public static final String CAR_DELETE = "DELETE FROM car WHERE licensePlate = ?";
    public static final String CAR_SELECT_BY_LICENSE_PLATE = "SELECT * FROM car WHERE licensePlate = ?";
    public static final String GET_ALL_PARK_ID = "SELECT * FROM parkinglot WHERE parkStatus = 'Blank' ORDER BY parkId asc";
    public static final String GET_BY_LICENSE_PLATE = "SELECT * FROM car WHERE licensePlate like '%'+?+'%'";
    public static final String GET_BY_CAR_COLOR = "SELECT * FROM car WHERE carColor like '%'+?+'%'";
    public static final String GET_BY_CAR_TYPE = "SELECT * FROM car WHERE carType like '%'+?+'%'";
    public static final String GET_NUMBER_OF_CARS = "SELECT count(licensePlate) FROM car";
    public static final String PAGING_CAR = "SELECT * FROM car ORDER BY licensePlate OFFSET ? ROWS FETCH NEXT " + PAGE_SIZE_CAR + " ROW ONLY;";
    public static final String CAR_QUERY_GET_ALL_LICENSEPLATE = "SELECT DISTINCT licensePlate FROM car";
}
