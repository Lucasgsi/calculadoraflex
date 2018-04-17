package calculadora.com.br.calculadoraflex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluno on 28/03/18.
 */

public class AdapterListConsumo extends BaseAdapter {

    Context contexto;
    List<Media> medias;

    public AdapterListConsumo(Context contexto, List<Media> medias) {
        this.contexto = contexto;
        this.medias = medias;
    }

    @Override
    public int getCount() {
        return medias.size();
    }

    @Override
    public Object getItem(int position) {
        return medias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return medias.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linhas_media_consumo,parent,false);
        TextView kmRodado = (TextView) viewLinha.findViewById(R.id.textKmRodado);
        TextView abastecido = (TextView) viewLinha.findViewById(R.id.textAbastecer);
        TextView resultado = (TextView) viewLinha.findViewById(R.id.textResultMedia);

        Media media = medias.get(position);
        kmRodado.setText(media.getNumerokm());
        abastecido.setText(media.getAbastecimento());
        resultado.setText(media.getMediaconsumo());

        return viewLinha;
    }
}
