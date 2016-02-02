package co.infinum.heat.air.db;

import android.database.Cursor;
import android.provider.ContactsContract;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.Insert;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hEAT- on 2.2.2016..
 */
@Table(database = ItemsDatabase.class)
public class Items extends BaseModel {

    void Items(String _title, String _message){
        this.title = _title;
        this.message = _message;
    }

    @PrimaryKey(autoincrement = true)
    private long id;

    @Column(length = 15)
    private String title;

    @Column()
    private String message;
    /*
    private void InsertItems(){
        Cursor cursor  = db.rawQuery("INSERT INTO Items VALUES", title, message);
        final List<Items> lista= new ArrayList<Items>();
        Items items;

        if(cursor.moveToFirst()){
            do{
                items = new Items();
                items.setId(cursor.getLong(cursor.getColumnIndex("id")));
                items.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                items.setMessage(cursor.getString(cursor.getColumnIndex("message")));
                lista.add(items);
            }
            while(cursor.moveToNext());
        }
    }*/

    public void insertWrapper(){
        //Insert<Items> insert = SQLite.insert(Items.class).orFail().columnValues()
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
