package calculadora.com.br.calculadoraflex;

public class VeiculoModeloPreco {

    private String referencia;
    private String fipe_codigo;
    private String name;
    private String combustivel;
    private String marca;
    private String ano_modelo;
    private String preco;
    private String key;
    private Integer time;
    private String veiculo;
    private String id;

    public VeiculoModeloPreco() {
    }

    public VeiculoModeloPreco(String referencia, String fipe_codigo, String name, String combustivel, String marca, String ano_modelo, String preco, String key, Integer time, String veiculo, String id) {
        this.referencia = referencia;
        this.fipe_codigo = fipe_codigo;
        this.name = name;
        this.combustivel = combustivel;
        this.marca = marca;
        this.ano_modelo = ano_modelo;
        this.preco = preco;
        this.key = key;
        this.time = time;
        this.veiculo = veiculo;
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFipe_codigo() {
        return fipe_codigo;
    }

    public void setFipe_codigo(String fipe_codigo) {
        this.fipe_codigo = fipe_codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(String ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
