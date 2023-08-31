import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class ItemEstoque {
    private String nome;
    private int quantidade;

    public ItemEstoque(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemEstoque [nome=" + nome + ", quantidade=" + quantidade + "]";
    }
}

class SistemaGerenciamentoEstoque {
    private ArrayList<ItemEstoque> estoque;

    public SistemaGerenciamentoEstoque() {
        estoque = new ArrayList<>();
    }

    public void adicionarItem(String nome, int quantidade) {
        estoque.add(new ItemEstoque(nome, quantidade));
        System.out.println("Item adicionado ao estoque.");
    }

    public void removerItem(String nome) {
        Iterator<ItemEstoque> iterator = estoque.iterator();
        while (iterator.hasNext()) {
            ItemEstoque item = iterator.next();
            if (item.getNome().equals(nome)) {
                iterator.remove();
                System.out.println("Item removido do estoque.");
                return;
            }
        }
        System.out.println("Item não encontrado no estoque.");
    }

    public void atualizarQuantidade(String nome, int quantidade) {
        for (ItemEstoque item : estoque) {
            if (item.getNome().equals(nome)) {
                item.setQuantidade(quantidade);
                System.out.println("Quantidade atualizada.");
                return;
            }
        }
        System.out.println("Item não encontrado no estoque.");
    }

    public void listarItens() {
        System.out.println("Itens em estoque:");
        for (ItemEstoque item : estoque) {
            System.out.println(item);
        }
    }
}

public class sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaGerenciamentoEstoque sistema = new SistemaGerenciamentoEstoque();

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Estoque");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Atualizar quantidade");
            System.out.println("4. Listar itens");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    sistema.adicionarItem(nome, quantidade);
                    break;
                case 2:
                    System.out.print("Nome do item a ser removido: ");
                    nome = scanner.nextLine();
                    sistema.removerItem(nome);
                    break;
                case 3:
                    System.out.print("Nome do item a ter a quantidade atualizada: ");
                    nome = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    quantidade = scanner.nextInt();
                    sistema.atualizarQuantidade(nome, quantidade);
                    break;
                case 4:
                    sistema.listarItens();
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
