package calculadora.com.br.calculadoraflex;

import java.util.Date;

public class Media {
    private long id;
    private String numerokm;
    private String abastecimento;
    private String mediaconsumo;

    public Media() {
    }

    public Media(long id, String numerokm, String mediaconsumo) {
        this.id = id;
        this.numerokm = numerokm;
        this.mediaconsumo = mediaconsumo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumerokm() {
        return numerokm;
    }

    public void setNumerokm(String numerokm) {
        this.numerokm = numerokm;
    }

    public String getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(String abastecimento) {
        this.abastecimento = abastecimento;
    }

    public String getMediaconsumo() {
        return mediaconsumo;
    }

    public void setMediaconsumo(String mediaconsumo) {
        this.mediaconsumo = mediaconsumo;
    }
}
