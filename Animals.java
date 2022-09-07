import java.io.Serializable;

public class Animals implements Serializable {
    String animal_name;
    int animal_age;
    String animal_size;
    String favourite_food;
    String favourite_activity;
    // Room roomClass;

    @Override
    public String toString() {
        return " " +
                "Animal_name= ' " + animal_name + '\'' +
                ", Favourite_food = ' " + favourite_food + '\'' +
                ", Favourite_activity = ' " + favourite_activity + '\'' ;

    }

    public Animals(String name,String food,String activity){
        this.animal_name=name;
        this.favourite_food=food;
        this.favourite_activity=activity;

    }

    public void setAnimal_name(String name){
        this.animal_name=name;
    }
    public String getAnimal_name(){
        return animal_name;
    }
    public void setFavourite_food(String food){
        this.favourite_food=food;
    }
    public String getFavourite_food(){
        return favourite_food;
    }
    public void setFavourite_activity(String activity){
        this.favourite_activity=activity;
    }
    public String getFavourite_activity(){
        return favourite_activity;
    }
    public void setAnimal_age(int age){
        this.animal_age=age;
    }
    public int getAnimal_age(){
        return animal_age;
    }
    public void setAnimal_size(String size){
        this.animal_size=size;
    }
    public String getAnimal_size(){
        return animal_size;
    }
}
