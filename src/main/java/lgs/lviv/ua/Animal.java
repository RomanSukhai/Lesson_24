package lgs.lviv.ua;

import java.util.ArrayList;
import java.util.List;

public class Animal {
	private int id;
	private String name_animal;
	private String type_animal;
	
	public static List<String> typeAnimal =  new ArrayList<>();
	
	public static List<String> getTypeAnimal() {
		return typeAnimal;
	}




	public static void setTypeAnimal(List<String> typeAnimal) {
		Animal.typeAnimal = typeAnimal;
	}




	public static void checkType(List<String> tyList){
		 tyList.add("Dog");
		 tyList.add("Cat");
		 tyList.add("Lion");
		 tyList.add("Bird");
		 tyList.add("Spider");
		 tyList.add("Pet");
		 tyList.add("Reptiles");
	}
	
		
	
	
	public Animal(String name_animal, String type_animal) throws Exception {
		checkType(typeAnimal);
		boolean checkTypeAnimal = type_animal.equalsIgnoreCase(getTypeAnimal().get(0)) || 
				type_animal.equalsIgnoreCase(getTypeAnimal().get(1)) || 
				type_animal.equalsIgnoreCase(getTypeAnimal().get(2)) || 
				type_animal.equalsIgnoreCase(getTypeAnimal().get(3)) || 
				type_animal.equalsIgnoreCase(getTypeAnimal().get(4)) || 
				type_animal.equalsIgnoreCase(getTypeAnimal().get(5)) || 
				type_animal.equalsIgnoreCase(getTypeAnimal().get(6)) ;
		if(checkTypeAnimal){
			this.name_animal = name_animal;
			this.type_animal = type_animal;
		}else {
			throw new Exception("Not such type animal");
		}
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_animal() {
		return name_animal;
	}
	public void setName_animal(String name_animal) {
		this.name_animal = name_animal;
	}
	public String getType_animal() {
		return type_animal;
	}
	public void setType_animal(String type_animal) {
		this.type_animal = type_animal;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name_animal=" + name_animal + ", type_animal=" + type_animal + "]";
	}
	
	
}
