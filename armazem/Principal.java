import java.util.List;
import java.util.Scanner;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        Database database = new Database("armazem.db");

        try {
            ProdutoRepository repository =
                new ProdutoRepository(database);

            int opcao = -1;

            while (opcao != 0) {
                System.out.println("\n===== SISTEMA DE ARMAZÉM =====");
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Buscar produto por ID");
                System.out.println("3 - Listar produtos");
                System.out.println("4 - Atualizar produto");
                System.out.println("5 - Excluir produto");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                if (!entrada.hasNextInt()) {
                    System.out.println("Digite uma opção válida.");
                    entrada.nextLine();
                    continue;
                }

                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nome = entrada.nextLine();

                        System.out.print("Categoria: ");
                        String categoria = entrada.nextLine();

                        System.out.print("Preço: ");
                        double preco = entrada.nextDouble();

                        System.out.print("Quantidade em estoque: ");
                        int quantidade = entrada.nextInt();
                        entrada.nextLine();

                        if (preco < 0 || quantidade < 0) {
                            System.out.println(
                                "Preço e quantidade não podem ser negativos."
                            );
                            break;
                        }

                        Produto novo = new Produto(
                            nome,
                            categoria,
                            preco,
                            quantidade
                        );

                        repository.criar(novo);

                        System.out.println(
                            "Produto cadastrado! ID: " + novo.getId()
                        );
                        break;

                    case 2:
                        System.out.print("ID do produto: ");
                        int idBusca = entrada.nextInt();
                        entrada.nextLine();

                        Produto encontrado =
                            repository.buscarPorId(idBusca);

                        if (encontrado != null) {
                            System.out.println(encontrado);
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;

                    case 3:
                        List<Produto> produtos = repository.listarTodos();

                        if (produtos.isEmpty()) {
                            System.out.println("Armazém sem produtos cadastrados.");
                        } else {
                            for (Produto p : produtos) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 4:
                        System.out.print("ID do produto: ");
                        int idAtualizar = entrada.nextInt();
                        entrada.nextLine();

                        Produto produtoAtualizar =
                            repository.buscarPorId(idAtualizar);

                        if (produtoAtualizar == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }

                        System.out.print("Novo nome: ");
                        produtoAtualizar.setNome(entrada.nextLine());

                        System.out.print("Nova categoria: ");
                        produtoAtualizar.setCategoria(entrada.nextLine());

                        System.out.print("Novo preço: ");
                        double novoPreco = entrada.nextDouble();

                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = entrada.nextInt();
                        entrada.nextLine();

                        if (novoPreco < 0 || novaQuantidade < 0) {
                            System.out.println(
                                "Preço e quantidade não podem ser negativos."
                            );
                            break;
                        }

                        produtoAtualizar.setPreco(novoPreco);
                        produtoAtualizar.setQuantidade(novaQuantidade);

                        if (repository.atualizar(produtoAtualizar)) {
                            System.out.println("Produto atualizado.");
                        } else {
                            System.out.println("Não foi possível atualizar.");
                        }
                        break;

                    case 5:
                        System.out.print("ID do produto: ");
                        int idExcluir = entrada.nextInt();
                        entrada.nextLine();

                        if (repository.excluir(idExcluir)) {
                            System.out.println("Produto excluído.");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            database.close();
            entrada.close();
        }
    }
}