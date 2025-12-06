import java.sql.*;

public class Database {
	
	private static Database instance;

    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection conn() throws SQLException {
    	Connection conn = DriverManager.getConnection("jdbc:sqlite:database/GGchess.db");
    	return conn;
    }
	
    public void createTable() throws SQLException {
    	Connection conn = this.conn();
    	Statement stm = conn.createStatement();
    	stm.execute("CREATE TABLE IF NOT EXISTS Players(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT NOT NULL,nbWins INTEGER DEFAULT 0,nbLosses INTEGER DEFAULT 0,nbDraws INTEGER DEFAULT 0)");
    }
    
    public void insertInTable(String name) throws SQLException{
    	Connection conn = this.conn();
    	PreparedStatement preparedstm = conn.prepareStatement("INSERT INTO Players(name) VALUES (?)");
    	preparedstm.setString(1, name);
    	preparedstm.executeUpdate();
    }
    
    public void updateWins(String name) throws SQLException{
    	Connection conn = this.conn();
    	PreparedStatement preparedstm = conn.prepareStatement("UPDATE Players SET nbWins = nbWins + 1 WHERE name = ?");
    	preparedstm.setString(1,name);
    	preparedstm.executeUpdate();
    }
    
    public void updateLosses(String name) throws SQLException{
    	Connection conn = this.conn();
    	PreparedStatement preparedstm = conn.prepareStatement("UPDATE Players SET nbLosses = nbLosses + 1 WHERE name = ?");
    	preparedstm.setString(1,name);
    	preparedstm.executeUpdate();
    }

    public void updateDraws(String name) throws SQLException{
    	Connection conn = this.conn();
    	PreparedStatement preparedstm = conn.prepareStatement("UPDATE Players SET nbDraws = nbDraws + 1 WHERE name = ?");
    	preparedstm.setString(1,name);
    	preparedstm.executeUpdate();
    }
}
