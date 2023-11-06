package daos.ParkingLotDAO;

public class ParkingLotDAOCons {
    public static final String PARKING_LOT_QUERY_GET_ALL = "SELECT * FROM parkinglot";
    public static final String PARKING_LOT_QUERY_GET_BY_ID = "SELECT * FROM parkinglot WHERE parkId = ?";
    public static final String PARKING_LOT_QUERY_ADD = "INSERT INTO [dbo].[parkinglot]([parkArea],[parkName],[parkPlace],[parkPrice],[parkStatus])" +
            "     VALUES" +
            "           (?,?,?,?,'Blank')";

    public static final String PARKING_LOT_QUERY_DELETE_BY_ID = "DELETE FROM parkinglot WHERE parkId = ?";
    public static final String PARKING_LOT_QUERY_EDIT_BY_ID = "UPDATE [dbo].[parkinglot]\n" +
            "   SET [parkArea] = ?\n" +
            "      ,[parkName] = ?\n" +
            "      ,[parkPlace] = ?\n" +
            "      ,[parkPrice] = ?\n" +
            "      ,[parkStatus] = ?\n" +
            " WHERE parkId = ?";

    public static final String PARKING_LOT_QUERY_BY_PARKING_STATUS = "SELECT * FROM parkinglot WHERE parkStatus = ? ";
    public static final String PARKING_LOT_QUERY_PLACE = "SELECT distinct [parkPlace] FROM [parkinglot] ORDER BY parkPlace asc ";

    public static final String PARKING_LOT_QUERY_BY_PARKING_NAME = "SELECT * FROM parkinglot WHERE parkName like '%'+?+'%'";
    public static final String PARKING_LOT_QUERY_BY_PARKING_PLACE = "SELECT * FROM parkinglot WHERE parkPlace like '%'+?+'%'";
    public static final String PARKING_LOT_QUERY_BY_PARKING_AREA = "SELECT * FROM parkinglot WHERE parkArea like '%'+?+'%'";
    public static final String PARKING_LOT_QUERY_BY_PARKING_PRICE = "SELECT * FROM parkinglot WHERE parkPrice like '%'+?+'%'";
    public static final String PARKING_LOT_QUERY_EDIT_BY_ID_CONTAINS = "SELECT * FROM parkinglot WHERE parkId like '%'+?+'%'";
}
