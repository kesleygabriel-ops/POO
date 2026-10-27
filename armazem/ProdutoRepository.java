import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.List;

public class ProdutoRepository
{
    private Dao<Produto, Integer> dao;

    public ProdutoRepository(Database database)
    {
        try {
            dao = DaoManager.createDao(
                database.getConnection(),
                Produto.class
            );

            TableUtils.createTableIfNotExists(
                database.getConnection(),
                Produto.class
            );
        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao inicializar o repositório: " + e.getMessage()
            );
        }
    }

    public Produto criar(Produto produto)
    {
        try {
            dao.create(produto);
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao cadastrar produto: " + e.getMessage()
            );
        }
    }

    public Produto buscarPorId(int id)
    {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao consultar produto: " + e.getMessage()
            );
        }
    }

    public List<Produto> listarTodos()
    {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao listar produtos: " + e.getMessage()
            );
        }
    }

    public boolean atualizar(Produto produto)
    {
        try {
            return dao.update(produto) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao atualizar produto: " + e.getMessage()
            );
        }
    }

    public boolean excluir(int id)
    {
        try {
            return dao.deleteById(id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(
                "Erro ao excluir produto: " + e.getMessage()
            );
        }
    }
}