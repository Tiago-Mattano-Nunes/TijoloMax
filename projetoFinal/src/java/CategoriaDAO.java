import conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Categorias;
import model.bean.Produtos;

public class CategoriaDAO {

   public List<Categorias> categoria() {
        List<Categorias> passar = new ArrayList();

        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM Categorias");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categorias produtos = new Categorias();
                produtos.setIdCategoria(rs.getInt("idprodutos"));
                produtos.setNome(rs.getString("nome"));
               
                passar.add(produtos);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passar;
    }
}


