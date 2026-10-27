import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

@DatabaseTable(tableName = "produtos")
public class Produto
{
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private String categoria;

    @DatabaseField
    private double preco;

    @DatabaseField
    private int quantidade;

    public Produto()
    {
    }

    public Produto(String nome, String categoria, double preco, int quantidade)
    {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public String toString()
    {
        return "ID: " + id +
               " | Produto: " + nome +
               " | Categoria: " + categoria +
               " | Preço: R$ " + String.format("%.2f", preco) +
               " | Estoque: " + quantidade;
    }
}