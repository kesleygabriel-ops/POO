import java.util.List;

public class TesteCRUD
{
    public static void executar()
    {
        Database database = new Database("armazem.db");

        try {
            ProdutoRepository repository =
                new ProdutoRepository(database);

            Produto produto = new Produto(
                "Arroz",
                "Alimentos",
                25.90,
                50
            );

            repository.criar(produto);

            System.out.println("1. CREATE");
            System.out.println(produto);

            System.out.println("\n2. READ POR ID");
            System.out.println(repository.buscarPorId(produto.getId()));

            System.out.println("\n3. READ TODOS");
            List<Produto> produtos = repository.listarTodos();

            for (Produto p : produtos) {
                System.out.println(p);
            }

            System.out.println("\n4. UPDATE");
            produto.setPreco(29.90);
            produto.setQuantidade(40);

            repository.atualizar(produto);

            System.out.println(repository.buscarPorId(produto.getId()));

            System.out.println("\n5. DELETE");
            repository.excluir(produto.getId());

            if (repository.buscarPorId(produto.getId()) == null) {
                System.out.println("Produto excluído com sucesso.");
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            database.close();
        }
    }
}