package lgs.lviv.ua;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aplication {
	static AnimalDao getAnimalDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		AnimalDao animalDao = new AnimalDao(ConectionUNIT.connectionUtil());
		return  animalDao;
	}
	public static void main(String[] args) throws Exception {
		getAnimalDao().dropTableIfExists();
		getAnimalDao().createTable();
		List<Animal> animalOfList = new ArrayList<Animal>();
		List<Animal> animalcopy;
		animalOfList.add(new Animal("Ref", 		"Dog"));
		animalOfList.add(new Animal("Chedr", 	"Dog"));
		animalOfList.add(new Animal("Roman", 	"Dog"));
		animalOfList.add(new Animal("Geter", 	"Dog"));
		animalOfList.add(new Animal("Leder", 	"Dog"));
		animalOfList.add(new Animal("Hury", 	"Dog"));
		animalOfList.add(new Animal("Burret", 	"Dog"));
		animalOfList.forEach(x->{
			try {
				getAnimalDao().insert(x);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		getAnimalDao().deleteById(1);
		getAnimalDao().readerOnlyForBothQeurry("name_animal"); 
		getAnimalDao().readerOnlyForBothQeurry("type_animal");
		getAnimalDao().updateById(new Animal("rererererer", "Cat"), 4);
		getAnimalDao().readAll().forEach(x->System.out.println(x));
		
	}

}
