package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		// ATUALIZAR DADOS
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller " +
					"SET BaseSalary =  BaseSalary + ? " +
					"WHERE " +
					"(departmentId = ?)"
					);
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int linhasAfetadas = st.executeUpdate();
			
			System.out.println("PRONTO, foram " + linhasAfetadas + " linhas afetadas");
			
			
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			DB.closeConnection();
		}
		
		
	}

}
