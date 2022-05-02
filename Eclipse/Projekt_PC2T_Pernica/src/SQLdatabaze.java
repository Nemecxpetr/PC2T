import java.sql.*;
import java.util.ArrayList;

public class SQLdatabaze {

	private String dbname;
	public SQLdatabaze(String dbname){
		this.dbname = "osoby.db";
		connect();
		createTableUcitele();
		createTableStudenti();
		createTableVztahy();
		
	}
	
	private Connection conn; 
	
	
	public boolean connect() { 
	       conn = null; 
	       try {
	    	   conn = DriverManager.getConnection("jdbc:sqlite:"+dbname);                       
	       } catch (SQLException e) { 
	            System.out.println(e.getMessage());
		    return false;
	      }
	      return true;
	}
	
	public boolean createTableStudenti() {
	     if (conn==null)
	           return false;
	    String sql = "CREATE TABLE IF NOT EXISTS Studenti(" + 
	    				"id integer PRIMARY KEY," + 
	    				"jmeno varchar(255) NOT NULL,"+ 
	    				"prijmeni varchar(255) NOT NULL,"+
	    				"datumnarozeni varchar(255) NOT NULL,"+
	    				"znamky varchar(255)" + ");";
	    try{
	            Statement stmt = conn.createStatement(); 
	            stmt.execute(sql);
	            return true;
	    } 
	    catch (SQLException e) {
	    System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public boolean createTableUcitele() {
	     if (conn==null)
	           return false;
	    String sql = "CREATE TABLE IF NOT EXISTS Ucitele(" + 
	    				"id integer PRIMARY KEY," + 
	    				"jmeno varchar(255) NOT NULL,"+ 
	    				"prijmeni varchar(255) NOT NULL,"+
	    				"datumnarozeni varchar(255) NOT NULL"+");";
	    try{
	            Statement stmt = conn.createStatement(); 
	            stmt.execute(sql);
	            return true;
	    } 
	    catch (SQLException e) {
	    System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public boolean createTableVztahy() {
	     if (conn==null)
	           return false;
	    String sql = "CREATE TABLE IF NOT EXISTS Vztahy(" + 
	    				"ucitelID integer," +
	    				"studentID integer," +
	    				"FOREIGN KEY(ucitelID) REFERENCES Ucitele(id)," +
	    				"FOREIGN KEY(studentID) REFERENCES Studenti(id)" +
	    				");";
	    try{
	            Statement stmt = conn.createStatement(); 
	            stmt.execute(sql);
	            return true;
	    } 
	    catch (SQLException e) {
	    System.out.println(e.getMessage());
	    }
	    return false;
	}

	
	
	public void insertStudent(int id, String jmeno, String prijmeni, String datumnarozeni, ArrayList<Integer> znamky) {
        String sql = "INSERT OR REPLACE INTO Studenti(id,jmeno,prijmeni,datumnarozeni,znamky) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, id);
            pstmt.setString(2, jmeno);
            pstmt.setString(3, prijmeni);
            pstmt.setString(4, datumnarozeni);
            pstmt.setString(5, znamkyToString(znamky));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void insertUcitel(int id, String jmeno, String prijmeni, String datumnarozeni) {
        String sql = "INSERT OR REPLACE INTO Ucitele(id,jmeno,prijmeni,datumnarozeni) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, id);
            pstmt.setString(2, jmeno);
            pstmt.setString(3, prijmeni);
            pstmt.setString(4, datumnarozeni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void insertVztah(int ucitelID, int studentID) {
        String sql = "INSERT OR REPLACE INTO Vztahy(ucitelID,studentID) VALUES(?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, ucitelID);
            pstmt.setInt(2, studentID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	public Student getStudent(int id) throws DatabaseCorruptedException{
	    Student student = null;
	    String jmeno, prijmeni, datumnarozeni, strZnamky;
		String sql = "SELECT id, jmeno, prijmeni, datumnarozeni, znamky FROM studenti where id=?";
	     try {
	           PreparedStatement pstmt  = conn.prepareStatement(sql);
	           pstmt.setInt(1,id);
	           ResultSet rs  = pstmt.executeQuery();

               jmeno = rs.getString("jmeno");
               prijmeni = rs.getString("prijmeni");
               datumnarozeni = rs.getString("datumnarozeni");
               strZnamky = rs.getString("znamky");
               
               student = new Student(id, jmeno, prijmeni, datumnarozeni);
               student.setZnamky(znamkyFromString(strZnamky));
	     } catch (SQLException e) {
	    	 throw new DatabaseCorruptedException("Databaze obsahuje chybna data: "+e.getMessage());
	     } catch (MarkOutOfBoundsException e) {
	    	 throw new DatabaseCorruptedException("Databaze obsahuje chybna data: "+e.toString());
	     }
	     return student;
	}
	
	public Ucitel getUcitel(int id) throws DatabaseCorruptedException{
	    Ucitel ucitel = null;
	    String jmeno, prijmeni, datumnarozeni;
		String sql = "SELECT id, jmeno, prijmeni, datumnarozeni FROM ucitele where id=?";
	     try {
	           PreparedStatement pstmt  = conn.prepareStatement(sql);
	           pstmt.setInt(1,id);
	           ResultSet rs  = pstmt.executeQuery();

               jmeno = rs.getString("jmeno");
               prijmeni = rs.getString("prijmeni");
               datumnarozeni = rs.getString("datumnarozeni");
               
               ucitel = new Ucitel(id, jmeno, prijmeni, datumnarozeni);
	     } catch (SQLException e) {
	    	 throw new DatabaseCorruptedException("Databaze obsahuje chybna data: "+e.getMessage());
	     }
	     return ucitel;
	}

	
	
	
	
	public ArrayList<Ucitel> getUcitele() throws DatabaseCorruptedException{
		ArrayList<Ucitel> ucitele = new ArrayList<Ucitel>();
		Ucitel ucitel;
		int id;
		String jmeno, prijmeni, datumnarozeni;
        String sql = "SELECT id, jmeno, prijmeni, datumnarozeni FROM ucitele";
        try {
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             while (rs.next()) {
            	 id = rs.getInt("id");
            	 jmeno = rs.getString("jmeno");
                 prijmeni = rs.getString("prijmeni");
                 datumnarozeni = rs.getString("datumnarozeni");
                 
                 ucitel = new Ucitel(id, jmeno, prijmeni, datumnarozeni);
                 ucitele.add(ucitel);
            }
        } catch (SQLException e) {
        	 throw new DatabaseCorruptedException("Databaze obsahuje chybna data: "+e.getMessage());
        }
        return ucitele;
}

	public ArrayList<Student> getStudenti() throws DatabaseCorruptedException{
		ArrayList<Student> studenti = new ArrayList<Student>();
		Student student;
		int id;
		String jmeno, prijmeni, datumnarozeni, strZnamky;
        String sql = "SELECT id, jmeno, prijmeni, datumnarozeni, znamky FROM studenti";
        try {
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             while (rs.next()) {
            	 id = rs.getInt("id");
            	 jmeno = rs.getString("jmeno");
                 prijmeni = rs.getString("prijmeni");
                 datumnarozeni = rs.getString("datumnarozeni");
                 strZnamky = rs.getString("znamky");
                 
                 student = new Student(id, jmeno, prijmeni, datumnarozeni);
                 student.setZnamky(znamkyFromString(strZnamky));
                 studenti.add(student);
            }
	     } catch (SQLException e) {
	    	 throw new DatabaseCorruptedException("Databaze obsahuje chybna data: "+e.getMessage());
	     } catch (MarkOutOfBoundsException e) {
	    	 throw new DatabaseCorruptedException("Databaze obsahuje chybna data: "+e.toString());
	     }
        return studenti;
}
	
	
	public static String znamkyToString(ArrayList<Integer> znamky) {
		String string = "";
		if(znamky.size() == 0)
			return "";
		
		for(Integer znamka : znamky) {
			string += znamka.toString() +",";
		}
		string = string.substring(0, string.length() - 1);
		return string;
	}
	
	public static ArrayList<Integer> znamkyFromString(String string){
		ArrayList<Integer> znamky = new ArrayList<Integer>();
		String[] strings = string.split(",");
		for(String str : strings) {
			znamky.add(Integer.parseInt(str));
		}
		return znamky;
	}
	
	public boolean deleteFromStudenti(int id) {
	     if (conn==null)
	           return false;
	    String sql = "DELETE from studenti WHERE id=?);";
	    try{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
	        pstmt.setInt(1,id);
	        pstmt.execute(sql);
	        return true;
	    } 
	    catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public boolean deleteFromUcitele(int id) {
	     if (conn==null)
	           return false;
	    String sql = "DELETE from ucitele WHERE id=?);";
	    try{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
	        pstmt.setInt(1,id);
	        pstmt.execute(sql);
	        return true;
	    } 
	    catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public boolean delete(int id) {
			return deleteFromUcitele(id) || deleteFromStudenti(id);
			
	}
	
	
	public boolean clear() {
	     if (conn==null)
	           return false;
	   String sql1 = "DROP TABLE IF EXISTS ucitele";
	   String sql2 = "DROP TABLE IF EXISTS studenti";
	    try{
	            Statement stmt = conn.createStatement(); 
	            stmt.execute(sql1);
	            stmt.execute(sql2);
	            return true;
	    } 
	    catch (SQLException e) {
	    System.out.println(e.getMessage());
	    }
	    return false;
	}
	
	public void disconnect() { 
		if (conn != null) {
		       try {
		    	   conn.close();
	    	   } catch (SQLException e) {
	    		   System.out.println(e.getMessage());
    		   }
		}
	}

}
