package calculadora.com.br.calculadoraflex;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MediaConsumo extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    EditText edittextm1;
    EditText edittextm2;
    EditText resultadoMedia;
    Button buttonm1;
    Media media = new Media();
    ListView listViewMediasConsumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_consumo);

        edittextm1 = (EditText) findViewById(R.id.editTextM1);
        edittextm2 = (EditText) findViewById(R.id.editTextM2);
        resultadoMedia = (EditText) findViewById(R.id.resultadoMedia);
        buttonm1 = (Button) findViewById(R.id.buttonM1);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey("id")) {
            media = new DAOMediaConsumo(this).buscarId(bundle.getLong("id"));
            edittextm1.setText(media.getNumerokm());
            edittextm2.setText(media.getAbastecimento());
            resultadoMedia.setText(media.getMediaconsumo());
        }

        listViewMediasConsumo = (ListView) findViewById(R.id.listMedias);
        preencherLista();
        listViewMediasConsumo.setOnItemClickListener(this);
        listViewMediasConsumo.setOnItemLongClickListener(this);
    }

    public void preencherLista(){
        List<Media> listaMedias = new ArrayList<>();
        listaMedias = new DAOMediaConsumo(this).buscarTodos();
        AdapterListConsumo adapter = new AdapterListConsumo(this, listaMedias);
        listViewMediasConsumo.setAdapter(adapter);
    }

    public void calcularMedia(View view) {
        Double qtdkm = Double.parseDouble(edittextm1.getText().toString());
        Double qtdlitros = Double.parseDouble(edittextm2.getText().toString());

        Double mediaconsumo = qtdkm / qtdlitros;
        DecimalFormat df = new DecimalFormat("0.##");
        resultadoMedia.setText(df.format(mediaconsumo));
    }

    public void salvarMedia(View view) {
        media.setNumerokm(edittextm1.getText().toString());
        media.setAbastecimento(edittextm2.getText().toString());
        media.setMediaconsumo(resultadoMedia.getText().toString());
        DAOMediaConsumo dao = new DAOMediaConsumo(this);
        if (media.getId() == 0) {
            dao.inserir(media);
        } else {
            dao.alterar(media);
        }
        preencherLista();
        limpaCampo();
    }

    public void limpaCampo(){
        edittextm1.setText("");
        edittextm2.setText("");
        resultadoMedia.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("MainActivity", parent.getItemAtPosition(position).toString());
        final Media media = (Media) parent.getItemAtPosition(position);
        final DAOMediaConsumo dao = new DAOMediaConsumo(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja Excluir a Média?").setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dao.remover(media);
                        preencherLista();
                    }
                }).setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        builder.show();
        return true;
    }
}
