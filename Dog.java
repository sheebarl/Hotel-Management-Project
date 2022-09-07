import java.io.Serializable;

public class Dog extends Animals implements Serializable {
    String favourite_Food;
    String favourite_Activity;

    public Dog(String name,String food,String activity){
        super(name,food,activity);
        this.favourite_Food=food;
        this.favourite_Activity=activity;
    }

    public void setFavourite_Food(String food){
        this.favourite_Food=food;
    }

    public String getFavourite_Food(){
        return favourite_Food;
    }

    public void setFavourite_Activity(String activity){
        this.favourite_Food=activity;
    }

    public String getFavourite_Activity(){
        return favourite_Activity;
    }
}
