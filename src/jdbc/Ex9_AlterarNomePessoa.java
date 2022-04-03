package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex9_AlterarNomePessoa {
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o código da pessoa: ");
		int codigo = entrada.nextInt();
		
		String select = "SELECT * FROM pessoas WHERE codigo = ?";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		Connection conexao = Ex3_FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, codigo);
		ResultSet r = stmt.executeQuery();
		
		if(r.next()) {
			Ex6_Pessoa p = new Ex6_Pessoa(r.getInt(1), r.getString(2));
			
			System.out.println("O nome atual é " + p.getNome());
			entrada.nextLine();
			
			System.out.print("Informe um novo nome: ");
			String novoNome = entrada.nextLine();
			
			stmt.close();
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoNome);
			stmt.setInt(2, codigo);
			stmt.execute();
			
			System.out.println("Pessoa alterada com sucesso!");
		} else {
			System.out.println("Pessoa não encontrada.");
		}
		
		conexao.close();
		entrada.close();
	}
}
