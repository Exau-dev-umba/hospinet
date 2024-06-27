package cd.appmedecininfirmiers.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_PATIENT = "patient";
    public static final String TABLE_NOTE_VOCALE = "note_vocal";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOM_PATIENT = "nom";
    public static final String COLUMN_GENRE_PATIENT = "nom";
    public static final String COLUMN_PROFESSION_PATIENT = "profession";
    public static final String COLUMN_ETATCIVIL_PATIENT = "etatCivil";

    private static final String DATABASE_NAME = "hospinet.db";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_PATIENT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NOM_PATIENT + COLUMN_PROFESSION_PATIENT + COLUMN_ETATCIVIL_PATIENT + COLUMN_GENRE_PATIENT
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENT);
        onCreate(db);
    }
}
