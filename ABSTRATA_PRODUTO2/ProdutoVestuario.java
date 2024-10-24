import java.sql.Connection;

// Classe que representa um Produto de Vestuário, estende a classe Produto
public class ProdutoVestuario extends Produto {
    private String tamanho;   // Tamanho do produto
    private String cor;       // Cor do produto
    private String material;  // Material do produto

    // Construtor da classe ProdutoVestuario
    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda); // Chama o construtor da classe pai
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    // Método para salvar o produto no banco de dados
    @Override
    public void salvar(Connection conn) throws Exception {
        String sql = "INSERT INTO produtos_vestuario (nome, preco_custo, preco_venda, tamanho, cor, material) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setString(4, tamanho);
            stmt.setString(5, cor);
            stmt.setString(6, material);
            stmt.executeUpdate();
        }
    }

    // Método para deletar o produto do banco de dados pelo ID
    @Override
    public void deletar(Connection conn, int id) throws Exception {
        String sql = "DELETE FROM produtos_vestuario WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Método para atualizar o produto no banco de dados
    @Override
    public void atualizar(Connection conn, int id) throws Exception {
        String sql = "UPDATE produtos_vestuario SET nome = ?, preco_custo = ?, preco_venda = ?, tamanho = ?, cor = ?, material = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setString(4, tamanho);
            stmt.setString(5, cor);
            stmt.setString(6, material);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }
    }
}