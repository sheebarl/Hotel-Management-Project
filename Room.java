import java.io.Serializable;

public class Room implements Serializable {

    String room_number;
    String room_dimension;
    int room_quantity;
    String room_type;
    String room_description;
    boolean RoomChecking;
    Animals animals;

    @Override
    public String toString() {
        return "Room{ " +
                "room_number='" + room_number + '\'' +
                ", room_quantity=" + room_quantity +
                ", room_type='" + room_type + '\'' +
                ", room_description='" + room_description + '\'' +
                ", animals= " + animals +
                '}';
    }

    public Room(String type, String number, String dimension, int quantity, boolean check){
        this.room_type=type;
        this.room_number=number;
        this.room_dimension=dimension;
        this.room_quantity=quantity;
        this.RoomChecking=check;
    }

    //This is description of room which is overridden by all other different room type
    public String describe(){
        room_description="Room for Animals";
        return room_description;
    }

    //This is the setter method of roomchecking attributes which set the values for attributes
    public void setRoomChecking(boolean check){
        this.RoomChecking=check;

    }

    //This is the getter method of getRoomchecking attributes which returns the value of attributes
    public Boolean getRoomChecking() {
        return RoomChecking;
    }

    public String getRoom_description(){
        return room_description;
    }

    public void setRoom_description(String description){
        this.room_description=description;
    }

    public String getRoom_number(){
        return room_number;
    }

    public void setRoom_number(String number){
        this.room_number=number;
    }

    public String getRoom_type(){
        return room_type;
    }

    public void setRoom_type(String type){
        this.room_type=type;
    }

    public int getRoom_quantity(){
        return room_quantity;
    }

    public void setRoom_quantity(int quantity){
        this.room_quantity=quantity;
    }

    public void setAnimals(Animals animals){
        this.animals = animals;
    }

    public boolean isAvailable(){
        //return guest==Null;
        return animals ==null;

    }
    public Animals getAnimals(){
        return animals;
    }
}
