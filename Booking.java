import java.io.Serializable;

public class Booking  implements Serializable {

    Room room;
    Animals animals;

    //Overriding toString method returns the desired output
    @Override
    public String toString() {
        return "Booking  " + "\n" +
                "Room_details : " + "Room_number : " + room  + " " + "\n" +
                "Animals_details : " + animals ;

    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Animals getAnimals() {
        return animals;
    }

    public void setAnimals(Animals animals) {
        this.animals = animals;
    }



}

