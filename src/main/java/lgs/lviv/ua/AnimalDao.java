package lgs.lviv.ua;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
	final static String READ_BY_ALL 			= "SELECT * FROM animal";
	final static String CREATE_BY				= "INSERT INTO animal(name_animal,type_animal) VALUES (?,?)";
	final static String READ_BY_ID 				= "SELECT * FROM animal WHERE id = ?";
	final static String UPDATE_BY_ID 			= "UPDATE animal SET name_animal=?,type_animal =? WHERE id = ?";
	final static String DELETE_BY_ID 			= "DELETE FROM animal WHERE  id = ?";
	final static String READ_BY_NAME_ANIMAL 	= "SELECT name_animal FROM animal";
	final static String READ_BY_TYPE_ANIMAL 	= "SELECT type_animal FROM animal";
	final static String DROP_TABLE 				= "DROP TABLE IF EXISTS animal";
	final static String CREATE_TABLE			= "CREATE TABLE animal(\n"
			+ "    id int(3) primary key AUTO_INCREMENT,\n"
			+ "    name_animal VARCHAR(11) NOT NULL,\n"
			+ "    type_animal VARCHAR(11) NOT NULL\n"
			+ ")";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public AnimalDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public List<Animal> readAll() throws Exception {
		List<Animal> animal = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_BY_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		while(resultSet.next()) {
			animal.add(AnimalMapper.map(resultSet));
		}
		return animal;
	}
	public void createTable() throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE_TABLE);
		preparedStatement.executeUpdate();
	}
	public void dropTableIfExists() throws SQLException {
		preparedStatement = connection.prepareStatement(DROP_TABLE);
		preparedStatement.executeUpdate();
	}
	
	public void insert(Animal animal) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE_BY);
		preparedStatement.setString(1,animal.getName_animal());
		preparedStatement.setString(2,animal.getType_animal());
		preparedStatement.executeUpdate();
	}
	public void readById(Animal animal) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1,animal.getId());
		preparedStatement.executeQuery();
	}
	
	public void updateById(Animal animal,int id) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1,animal.getName_animal());
		preparedStatement.setString(2,animal.getType_animal());
		preparedStatement.setInt(3,id);
		preparedStatement.executeUpdate();
	}
	
	public void deleteById(int i) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1,i);
		preparedStatement.executeUpdate();
	}
	
	//Only for READ_BY_NAME_ANIMAL and READ_BY_TYPE_ANIMAL
	public void readerOnlyForBothQeurry(String equrment) throws SQLException {
		if		(equrment.equals("name_animal")) {
			
			preparedStatement = connection.prepareStatement(READ_BY_NAME_ANIMAL);
			preparedStatement.executeQuery();
			
		}
		else if(equrment.equals("type_animal")){
			
			preparedStatement = connection.prepareStatement(READ_BY_TYPE_ANIMAL);
			preparedStatement.executeQuery();
			
		}
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}
}
