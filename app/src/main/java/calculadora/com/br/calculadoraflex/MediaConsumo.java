package calculadora.com.br.calculadoraflex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MediaConsumo extends AppCompatActivity {
    EditText edittextm1;
    EditText edittextm2;
    Button buttonm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_consumo);

        edittextm1 = (EditText) findViewById(R.id.editTextM1);
        edittextm2 = (EditText) findViewById(R.id.editTextM2);
        buttonm1 = (Button) findViewById(R.id.buttonM1);
    }

    public void CalcularMedia(View view) {

    }
}
