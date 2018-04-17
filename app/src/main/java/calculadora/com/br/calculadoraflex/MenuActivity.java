package calculadora.com.br.calculadoraflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {

    private ListView listViewFipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void viewContarFipe(View view) {
        Intent intent = new Intent(this, ConsultarTabelaFipe.class);
        startActivity(intent);
    }

    public void viewCalculadoraFlex(View view) {
        Intent intent = new Intent(this, Calculadoraflex.class);
        startActivity(intent);
    }

    public void viewMediaConsumo(View view) {
        Intent intent = new Intent(this, MediaConsumo.class);
        startActivity(intent);
    }

}