package fam.sa.simplysqllitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faheem on 28/10/15.
 */
public class TaskDBHelperClass extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME="tasksDB";

    //Table Name
    private final static String TABLE_TASKS="tasksTable";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_task = "task";


    public TaskDBHelperClass(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TASKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_task + " TEXT"+")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        // Drop older table if existed
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        // Create tables again
        onCreate(database);
    }

    // Adding new Task
    public void addTask(String  task) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_task, task); // Contact Name

        // Inserting Row
        db.insert(TABLE_TASKS, null, values);
        db.close();
        // Closing database connection
    }
    // Getting All Contacts
    public List<String> getAllTasks() {
        List<String> taskList = new ArrayList<String>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TASKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
              // There is ID at 0 position
              // contact.setID(Integer.parseInt(cursor.getString(0)));
              // getting tasks for position 1  and Adding tasks to list
                taskList.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // return contact list
        return taskList;
    }

    public int getNoOfTasks() {
        String countQuery = "SELECT  * FROM " + TABLE_TASKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public void deleteTask(String lasTask) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, KEY_task + " = ?",
                new String[] { lasTask });
        db.close();
    }


}

