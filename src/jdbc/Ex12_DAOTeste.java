package jdbc;

public class Ex12_DAOTeste {
	
	public static void main(String[] args) {
		Ex11_DAO dao = new Ex11_DAO();
		
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";
		System.out.println(dao.incluir(sql, "Roberto Silveira", 1000));
		System.out.println(dao.incluir(sql, "Julia Henrique", 1001));
		System.out.println(dao.incluir(sql, "Diego Ferreira", 1002));
		
		dao.close();
	}
}
