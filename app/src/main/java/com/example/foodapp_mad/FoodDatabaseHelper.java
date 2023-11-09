package com.example.foodapp_mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
// This is the one and only database for the application which will hold all tables for
// food, users and image references
public class FoodDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "FoodApp.db";
    private static final int DATABASE_VERSION = 1;

    private static final String FOOD_TABLE_NAME = "food_table";
    private static final String FOOD_ID = "food_id";
    private static final String FOOD_NAME = "food_name";
    private static final String FOOD_PRICE = "price";
    private static final String FOOD_LOCATION = "food_location";

    public static final String USER_TABLE_NAME = "user_table";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSWORD = "user_password";

    public FoodDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOOD_TABLE = "CREATE TABLE "+ FOOD_TABLE_NAME +
                " (" + FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FOOD_NAME + " TEXT, " +
                FOOD_PRICE + " FLOAT, " +
                FOOD_LOCATION + " TEXT);";

        db.execSQL(CREATE_FOOD_TABLE);

        String CREATE_USER_TABLE = "CREATE TABLE "+ USER_TABLE_NAME +
                " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_NAME + " TEXT, " +
                USER_EMAIL + " TEXT, " +
                USER_PASSWORD + " TEXT);";

        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        onCreate(db);
    }

    void addFoodItem(String name, double price, String restaurant){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FOOD_NAME, name);
        cv.put(FOOD_PRICE, price);
        cv.put(FOOD_LOCATION, restaurant);

        long result = db.insert(FOOD_TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Added Customer", Toast.LENGTH_SHORT).show();
        }
    }
    void addCustomer(String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_NAME, name);
        cv.put(USER_EMAIL, email);
        cv.put(USER_PASSWORD, password);

        long result = db.insert(USER_TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Added Customer", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readDataFromUserTable(){
        Cursor c = null;
        String query = "SELECT * FROM " + USER_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        if(db!=null){
            c= db.rawQuery(query, null);
        }
        return c;
    }

    Cursor readDataFromFoodTable(){
        Cursor c = null;
        String query = "SELECT * FROM " + FOOD_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        if(db!=null){
            c= db.rawQuery(query, null);
        }


        return c;
    }



    void updateUserData(String id, String name, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_NAME, name);
        cv.put(USER_EMAIL, email);
        cv.put(USER_PASSWORD, password);

        long result = db.update(USER_TABLE_NAME, cv, "id=?", new String[]{id});
        if(result==-1){
            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Update Successful", Toast.LENGTH_SHORT).show();
        }
    }

    void updateFoodData(String id, String name, double price, String restaurant){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FOOD_NAME, name);
        cv.put(FOOD_PRICE, price);
        cv.put(FOOD_LOCATION, restaurant);

        long result = db.update(FOOD_TABLE_NAME, cv, "id=?", new String[]{id});
        if(result==-1){
            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Update Successful", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteUserTableRow(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(USER_TABLE_NAME, "id", new String[]{id});
        if(result==-1){
            Toast.makeText(context, "Row Deletion Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Row Deleted Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteFoodTableRow(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(FOOD_TABLE_NAME, "id", new String[]{id});
        if(result==-1){
            Toast.makeText(context, "Row Deletion Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Row Deleted Successfully", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String DELETE_USER_TABLE = ("DELETE FROM " + USER_TABLE_NAME);
        db.execSQL(DELETE_USER_TABLE);
        String DELETE_FOOD_TABLE = ("DELETE FROM " + FOOD_TABLE_NAME);
        db.execSQL(DELETE_FOOD_TABLE);

    }
























    void foodInsertion(){
        addFoodItem("Chicken", 15.6, "KFC");
    }
}
