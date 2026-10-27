import java.sql.SQLException;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

public class Database
{
    private String databaseName;
    private JdbcConnectionSource connection;

    public Database(String databaseName)
    {
        this.databaseName = databaseName;
        this.connection = null;
    }

    public JdbcConnectionSource getConnection() throws SQLException
    {
        if (connection == null) {
            connection = new JdbcConnectionSource(
                "jdbc:sqlite:" + databaseName
            );
        }

        return connection;
    }

    public void close()
    {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}