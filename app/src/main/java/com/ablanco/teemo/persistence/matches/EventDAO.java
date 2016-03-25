package com.ablanco.teemo.persistence.matches;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ablanco.teemo.model.matches.Event;
import com.ablanco.teemo.model.matches.Frame;
import com.ablanco.teemo.model.matches.Position;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;
import com.ablanco.teemo.persistence.base.DBContext;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class EventDAO extends BaseReferencedDAO<Event, Frame> {

    private final static String PARTICIPANT_IDS = "PARTICIPANT_IDS";

    public EventDAO() {
        super(Event.class);
    }

    public String createTable() {
        String sql = super.createTable();
        return sql.substring(0, sql.length() -2) + ", " + PARTICIPANT_IDS + " TEXT )";
    }

    @Override
    public long save(Event object, Frame parent) {
        long id = -1;
        if (object != null) {

            //update last update date
            object.setLastUpdate(new Date());

            List<Field> fields = new ArrayList<Field>();
            fields = DBHelper.getClassFields(fields, type);
            ContentValues values = new ContentValues();

            for (Field column : fields) {
                String columnType = DBHelper.getColumnType(column);
                if (columnType != null) {
                    DBHelper.addFieldValueToColumn(values, column, object);
                }
            }

            if (object.getAssistingParticipantIds() != null) {
                values.put(PARTICIPANT_IDS, DBHelper.storeDataArray(object.getAssistingParticipantIds()));
            }

            //add fk
            values.put(DBHelper.FK, parent.get_id());

            SQLiteDatabase db = DBContext.getDB();
            if(null != db) {
                id = db.insertWithOnConflict(DBHelper.getTableName(type), null, values,
                        SQLiteDatabase.CONFLICT_REPLACE);
            }
            object.set_id(id);

            if(id > -1){
                PositionDAO positionDAO = new PositionDAO();
                List<Position> positions = positionDAO.findFromParent(object);
                positionDAO.deleteAll(positions);
                positionDAO.save(object.getPosition(), object);
            }

        }
        return id;
    }

    @Override
    public void delete(Event object) {
        PositionDAO positionDAO = new PositionDAO();
        List<Position> positions = positionDAO.findFromParent(object);
        positionDAO.deleteAll(positions);

        super.delete(object);
    }

    @Override
    public Event fromCursor(Cursor c) {
        Event object = super.fromCursor(c);

        if(object != null){
            String value = c.getString(c.getColumnIndex(PARTICIPANT_IDS));
            object.setAssistingParticipantIds(DBHelper.retrieveIntArray(value));

            PositionDAO positionDAO = new PositionDAO();
            Position positions = positionDAO.findFirstFromParent(object);
            object.setPosition(positions);

        }
        return object;
    }
}
