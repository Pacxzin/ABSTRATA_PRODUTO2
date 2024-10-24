import java.sql.Connection;

// Classe que representa um Produto Alimentício, estende a classe Produto
public class ProdutoAlimenticio extends Produto {
    private String dataValidade;           // Data de validade do produto
    private String informacoesNutricionais; // Informações nutricionais do produto

    // Construtor da classe ProdutoAlimenticio
    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String informacoesNutricionais) {
        super(nome, precoCusto, precoVenda); // Chama o construtor da classe pai
        this.dataValidade = dataValidade;
        this.informacoesNutricionais = informacoesNutricionais;
    }

    // Método para salvar o produto no banco de dados
    @Override
    public void salvar(Connection conn) throws Exception {
        String sql = "INSERT INTO produtos_alimenticios (nome, preco_custo, preco_venda, data_validade, informacoes_nutricionais) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) { // Usa try-with-resources para garantir o fechamento do PreparedStatement
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setString(4, dataValidade);
            stmt.setString(5, informacoesNutricionais);
            stmt.executeUpdate(); // Executa a atualização no banco
        }
    }

    // Método para deletar o produto do banco de dados pelo ID
    @Override
    public void deletar(Connection conn, int id) throws Exception {
        String sql = "DELETE FROM produtos_alimenticios WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para atualizar o produto no banco de dados
    @Override
    public void atualizar(Connection conn, int id) throws Exception {
        String sql = "UPDATE produtos_alimenticios SET nome = ?, preco_custo = ?, preco_venda = ?, data_validade = ?, informacoes_nutricionais = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setString(4, dataValidade);
            stmt.setString(5, informacoesNutricionais);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }
}