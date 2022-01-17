package lgs.lviv.ua;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalMapper {
	 static Animal map(ResultSet resultSet) throws Exception {
		String name_animal= resultSet.getString("name_animal");
		String type_animal = resultSet.getString("type_animal");
		return new Animal(name_animal, type_animal);
	}

}
