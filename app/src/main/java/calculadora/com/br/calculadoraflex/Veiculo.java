package calculadora.com.br.calculadoraflex;

public class Veiculo {
   private String fipe_marca;
   private String name;
   private String marca;
   private String key;
   private Integer id;
   private String fipe_name;

    public Veiculo() {
    }

    public Veiculo(String fipe_marca, String name, String marca, String key, Integer id, String fipe_name) {
        this.fipe_marca = fipe_marca;
        this.name = name;
        this.marca = marca;
        this.key = key;
        this.id = id;
        this.fipe_name = fipe_name;
    }

    public String getFipe_marca() {
        return fipe_marca;
    }

    public void setFipe_marca(String fipe_marca) {
        this.fipe_marca = fipe_marca;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFipe_name() {
        return fipe_name;
    }

    public void setFipe_name(String fipe_name) {
        this.fipe_name = fipe_name;
    }
}
