package base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/***
 * 
 * @author sujeet.kumar
 * 
 */
public class FosSqliteOpenHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 2;

	// Database Name
	public static final String DATABASE_NAME = "fosTracker";

	/***
	 * Table
	 */
	public static final String TABLE_CHECKIN_DETAIL = "checkin_detail";

	/***
	 * comman field
	 */
	protected static final String KEY_ID = "_id";
	protected static final String CHECK_IN_STATUS = "checkIn";

	/***
	 * Notification Table Columns names
	 */



	String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CHECKIN_DETAIL + "("
			+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ CHECK_IN_STATUS + " TEXT "+")";



	public FosSqliteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		// db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATIONS);

		// Create tables again
		onCreate(db);
	}

}
