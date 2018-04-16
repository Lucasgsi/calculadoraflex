package calculadora.com.br.calculadoraflex;

import java.util.Date;

public class Media {
    private Long id;
    private Date datahora = new Date();
    private Long numerokm;
    private Long mediaconsumo;

    public Media() {
    }

    public Media(Long id,Date datahora, Long numerokm, Long mediaconsumo) {
        this.id = id;
        this.datahora = datahora;
        this.numerokm = numerokm;
        this.mediaconsumo = mediaconsumo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Long getNumerokm() {
        return numerokm;
    }

    public void setNumerokm(Long numerokm) {
        this.numerokm = numerokm;
    }

    public Long getMediaconsumo() {
        return mediaconsumo;
    }

    public void setMediaconsumo(Long mediaconsumo) {
        this.mediaconsumo = mediaconsumo;
    }
}
