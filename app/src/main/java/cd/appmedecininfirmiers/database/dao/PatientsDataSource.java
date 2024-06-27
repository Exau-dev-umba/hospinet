package cd.appmedecininfirmiers.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cd.appmedecininfirmiers.database.MySQLiteHelper;
import cd.appmedecininfirmiers.ui.data.model.Patient;

public class PatientsDataSource {
    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NOM_PATIENT,
            MySQLiteHelper.COLUMN_PROFESSION_PATIENT,
            MySQLiteHelper.COLUMN_GENRE_PATIENT,
            MySQLiteHelper.COLUMN_ETATCIVIL_PATIENT,
    };

    public PatientsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Patient createPatient(String name, String etatCivil, String profession, String genre) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NOM_PATIENT, name );
        values.put(MySQLiteHelper.COLUMN_PROFESSION_PATIENT, etatCivil );
        values.put(MySQLiteHelper.COLUMN_PROFESSION_PATIENT, profession );
        values.put(MySQLiteHelper.COLUMN_GENRE_PATIENT, genre );
        long insertId = database.insert(MySQLiteHelper.TABLE_PATIENT, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_PATIENT,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Patient newPatient = cursorToPatient(cursor);
        cursor.close();
        return newPatient;
    }

    public void deletePatient(Patient patient) {
        long id = patient.getId();
        System.out.println("Patient deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_PATIENT, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Patient> getAllPatient() {
        List<Patient> patients = new ArrayList<Patient>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PATIENT,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Patient patient = cursorToPatient(cursor);
            patients.add(patient);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return patients;
    }

    private Patient cursorToPatient(Cursor cursor) {
        Patient patient = new Patient();
        patient.setId( cursor.getLong(0));
        patient.setName(cursor.getString(1));
        patient.setEtatCivil(cursor.getString(2));
        patient.setGenre(cursor.getString(3));
        patient.setProfession(cursor.getString(4));
        patient.setImage(cursor.getString(5));
        return patient;
    }
}
