import java.sql.Connection;

// Classe abstrata que representa um Produto
public abstract class Produto {
    private String nome;          // Nome do produto
    private double precoCusto;   // Preço de custo do produto
    private double precoVenda;    // Preço de venda do produto

    // Construtor da classe Produto
    public Produto(String nome, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // Método que calcula o lucro com base no preço de venda e custo
    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    // Métodos abstratos para operações de CRUD (salvar, deletar, atualizar)
    public abstract void salvar(Connection conn) throws Exception;
    public abstract void deletar(Connection conn, int id) throws Exception;
    public abstract void atualizar(Connection conn, int id) throws Exception;
}