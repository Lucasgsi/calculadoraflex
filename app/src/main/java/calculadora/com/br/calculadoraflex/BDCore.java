package calculadora.com.br.calculadoraflex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
    private static final  String NOME="media";
    private static final int VERSAO=1;

   public BDCore(Context context) {
       super(context,NOME,null,VERSAO);
   }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table medias(id integer "+
                "primary key autoincrement,"+
                "numerokm varchar(20),"+
                "abastecimento varchar(20),"+
                "mediaconsumo varchar(10));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table medias;");
        onCreate(db);
    }
}
