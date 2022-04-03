package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex8_ConsultarPessoas2 {
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);

		Connection conexao = Ex3_FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas WHERE nome like ?";

		System.out.print("Informe o valor pra pesquisa: ");
		String valor = entrada.nextLine();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + valor + "%");
		ResultSet resultado = stmt.executeQuery();

		List<Ex6_Pessoa> pessoas = new ArrayList<>();

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Ex6_Pessoa(codigo, nome));
		}

		for (Ex6_Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " ==> " + p.getNome());
		}

		stmt.close();
		conexao.close();
		entrada.close();
	}
}

// select * from pessoas where nome like '%si%';