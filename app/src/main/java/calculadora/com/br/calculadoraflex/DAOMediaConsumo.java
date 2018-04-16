package calculadora.com.br.calculadoraflex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOMediaConsumo {
    SQLiteDatabase db;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public DAOMediaConsumo(Context context) {
        db = new BDCore(context).getWritableDatabase();
    }

    public void inserir(Media media) {
        ContentValues values = new ContentValues();
        values.put("datahora",sdf.format(media.getDatahora()));
        values.put("numerokm",media.getNumerokm());
        values.put("mediaconsumo", media.getMediaconsumo());
        db.insert("medias",null,values);
    }

    public void alterar(Media media){
        ContentValues values = new ContentValues();
        values.put("datahora", sdf.format(media.getDatahora()));
        values.put("numerokm", media.getNumerokm());
        values.put("mediaconsumo",media.getMediaconsumo());
        db.update("medias", values,"id="+media.getId(),null);
    }

    public void remover(Media media) {
        db.delete("medias","id="+media.getId(),null);
    }

    public List<Media> buscarTodos() {
        List<Media> medias = new ArrayList<>();
        String[] colunas = {"id","datahora","numerokm","mediaconsumo"};
        Cursor cursor = db.query("medias",colunas,null,
                null,null,null,null);
        cursor.moveToFirst();
        for(int i=0;i < cursor.getCount();i++) {
            Media media = new Media();
            media.setId(cursor.getLong(0));
            media.setDatahora(cursor.getString(1));
            media.setNumerokm(cursor.getLong(2));
            media.setMediaconsumo(cursor.getLong(3));
            medias.add(media);
            cursor.moveToNext();
        }
        return medias;
    }

    public Media buscarId(Long id){
        String[] colunas = {"id","datahora","numerokm","mediaconsumo"};
        Cursor cursor = db.query("medias", colunas,"id="+id,
                null, null, null, null);
        cursor.moveToFirst();
        Media media = new Media();
        if(cursor.getCount()>0) {
            media.setId(cursor.getLong(0));
            media.setDatahora(cursor.getString(1));
            media.setNumerokm(cursor.getLong(2));
            media.setMediaconsumo(cursor.getLong(3));
        }
        return media;
    }
}
