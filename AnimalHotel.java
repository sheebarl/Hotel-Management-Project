import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//In this class AnimalHotel we do room Booking, room Editing,checkin  and checkout details of Animals.
//This class implements the serializable interface to make the class serialized or deserialized while file handling
public class AnimalHotel implements Serializable{

    //This is a constructor of class AnimalHotel.Here we are adding all types of room to RoomArray list.
    public AnimalHotel() {
        RoomArray.add(room1);
        RoomArray.add(room2);
        RoomArray.add(room3);
    }
   //Created arraylist for Room and Booking class
    ArrayList<Room> RoomArray=new ArrayList<Room>();
    ArrayList<Booking> bookingList=new ArrayList<Booking>();

    Animals animals;
    Booking booking=new Booking();

    //Here we are creating room object for 3 different rooms and passing the values for different room types
    Room room1=new LightRoom("LightRoom","R001","100x100",2,true);
    Room room2=new DarkRoom("DarkRoom","R002","150x150",1,true);
    Room room3=new NestedRoom("NestedRoom","R003","100x100",1,true);



    //This method only prints the menu
    public void PrintMenu(){
        System.out.println("Hej ! Welcome to the Animal Hotel");
        System.out.println("**********************************");
        System.out.println("Select the Menu");
        System.out.println("1.Booking");
        System.out.println("2.Edit Booking");
        System.out.println("3.Check_In");
        System.out.println("4.Check_Out");
        System.out.println("5.Filter Booking");
        System.out.println("6.Exit");
        System.out.println("**********************************");
    }

    //In this start() method according to the user choice it goes to switch case and  call the particular method and perform that

    public void start(){

        boolean menuOption=true;
        while(menuOption){
            PrintMenu();
            System.out.print("Enter your Choice > ");
            int menuChoice=getUserInt();
            switch(menuChoice){
                case 1:
                    System.out.println("Hotel Booking");
                    System.out.println("****************************");
                    BookingMethod();
                    break;
                case 2:
                    System.out.println("Edit Booking");
                    System.out.println("*****************************");
                    EditMethod();
                    break;
                case 3:
                    System.out.println("Check_In Details");
                    System.out.println("******************************");
                    CheckInMethod();
                    break;
                case 4:
                    System.out.println("Check_Out Details");
                    System.out.println("*******************************");
                    CancelMethod();
                    break;
                case 5:
                    System.out.println("Filter Bookings");
                    System.out.println("*******************************");
                    FilterBookings();
                    break;
                case 6:
                    System.out.println("Exit from Booking");
                    System.out.println("*******************************");
                    System.out.println("You selected to exit");
                    System.out.println("*** Thanks for Visiting Us! ***");
                    menuOption=false;
                    break;
                default:
                    System.out.println("You entered wrong option ");
                    break;
            }
        }
    }

    //This method is used to get integer input from user
    public int getUserInt(){
        int values=0;
        try {
            Scanner scan = new Scanner(System.in);
             values = scan.nextInt();
        }catch (Exception e){
            System.out.println("Error : " + e);
        }
        return values;
    }

    //In this method we get String input from user
    public String getUserString(){
        String myString="";
        try {
            Scanner scan = new Scanner(System.in);
            myString = scan.nextLine();
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
        return myString;
    }

    //In this Booking method we get input from user and do booking for particular animal.
    public void BookingMethod(){


        System.out.print("Enter the Animmal_name : ");
        String name=getUserString();
        System.out.print("Enter your Favourite Food : ");
        String food=getUserString();
        System.out.print("Enter your Favourite activity : ");
        String activity=getUserString();
        animals = new Animals(name,food, activity);
        animals.setAnimal_name(name);
        animals.setFavourite_food(food);
        animals.setFavourite_activity(activity);
        RoomAvailabilityMethod();

    }

    //In this method we are checking how many number of rooms are available for the particular room whether it is booked or not.
    public void RoomAvailabilityMethod() {
        int quantity;
        String desc;


        System.out.println("Room Details");
        System.out.println("***********************************************************************");

        for (int i = 0; i < 3; i++) {
            System.out.print(RoomArray.get(i).room_number + " ");
            System.out.print(RoomArray.get(i).room_type + " ");
            System.out.println(RoomArray.get(i).describe());
        }

        System.out.println("***********************************************************************");
        System.out.println("Select the Room Type");
        System.out.println("*************************");
        System.out.println("1.LightRoom");
        System.out.println("2.DarkRoom");
        System.out.println("3.NestedRoom");
        System.out.println("**************************");
        System.out.print("Enter the Room Name : ");
        String roomChoice=getUserString();
        System.out.print("Enter the  Room Number: ");
        String number = getUserString();
        Booking booking;

        boolean validateRoom =false;

        for (int i = 0; i < RoomArray.size(); i++) {

                if (RoomArray.get(i).room_number.equalsIgnoreCase(number)) {
                    validateRoom = true;
                    if (RoomArray.get(i).room_type.equalsIgnoreCase(roomChoice)) {
                            if (RoomArray.get(i).room_quantity > 0) {
                                System.out.println("Rooms are available.You can Book now ");
                                quantity = RoomArray.get(i).room_quantity - 1;
                                RoomArray.get(i).setRoom_quantity(quantity);
                                desc = RoomArray.get(i).describe();
                                booking = new Booking();
                                booking.setRoom(RoomArray.get(i));
                                booking.setAnimals(animals);
                                bookingList.add(booking);

                                //Adding to file
                                writeBooking(bookingList);

                                if(RoomArray.get(i).getRoom_quantity()== 0) {
                                     RoomArray.get(i).setRoomChecking(false);
                                 }

                                System.out.println("Your " + booking.toString());
                                break;
                            } else {
                                System.out.println("You cannot book.Rooms are already booked");


                                break;
                            }
                    } else {
                        System.out.println("Sorry,this Room is not available");
                        break;
                    }
                }

        }
            if (validateRoom== false)
                System.out.println("You entered a wrong room number");

        }


    //In this method we can change the room for animals according to their selected activity
    public void EditMethod() {
        ArrayList<Booking> bookingList = new ArrayList<Booking>();
        //reading the data from file
        bookingList =readBooking();
        System.out.print("Do you want to change any details? > ");
        String s1 = getUserString();

        if (s1.equalsIgnoreCase("Yes")) {
            System.out.print("Enter your room number : ");
            String room_num=getUserString();
            System.out.println("Select an option ");
            System.out.println("1.Name");
            System.out.println("2.Favourite_Food");
            System.out.println("3.Favourite_Activity");
            int choose=getUserInt();
            if(choose==1) {
                System.out.print("Enter the Animal_name : ");
                String name = getUserString();
                for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getRoom().getRoom_number().equalsIgnoreCase(room_num)) {
                        bookingList.get(i).getAnimals().setAnimal_name(name);
                        writeBooking(bookingList);
                    }
                }
            }else if(choose==2){
                    System.out.print("Enter your Favourite Food : ");
                    String food=getUserString();
                    for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getRoom().getRoom_number().equalsIgnoreCase(room_num)) {
                        bookingList.get(i).getAnimals().setFavourite_food(food);
                        writeBooking(bookingList);
                    }
                }
            }else if(choose==3) {

                    System.out.print("Enter your Favourite Activity : ");
                    String activity = getUserString();
                    for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getRoom().getRoom_number().equalsIgnoreCase(room_num)) {
                        bookingList.get(i).getAnimals().setFavourite_activity(activity);
                        writeBooking(bookingList);
                    }
                }
            }
            } else {
                System.out.println("No Changes");
            }
                System.out.println("Updated Booking");
                System.out.println("*********************************");

                for (int i = 0; i < bookingList.size(); i++) {
                System.out.println(bookingList.get(i).getAnimals().toString());
            }

        }

    //This method is used to filter the animal name
    public void FilterBookings(){
        System.out.print("Enter the name to filter : ");
        String s=getUserString();
        for(int i=0;i<bookingList.size();i++){
            if(bookingList.get(i).getAnimals().getAnimal_name().contains(s)){
            System.out.println("Animal name with " + s + ": " + bookingList.get(i).getAnimals().getAnimal_name());
        }
     }

   }

    //This method displays both list of all boookings and individual bookings
    public void CheckInMethod() {
        boolean option = true;
        while (option) {
            System.out.println("Select Booking details");
            System.out.println("***********************");
            System.out.println("1.List of all bookings");
            System.out.println("2.Individual bookings");
            System.out.print("Select the option to display : ");
            int select=getUserInt();
            if(select==1) {

                ArrayList<Booking>bookingArrayList = new ArrayList<Booking>();

                bookingArrayList = readBooking();

                for (int i = 0; i < bookingArrayList.size(); i++){
                    System.out.println("Booking find : Name : " +  bookingArrayList.get(i).getAnimals().animal_name + " " + "Room Number " + bookingArrayList.get(i).getRoom().room_number  );
                }
                option=false;
            }
            else if(select==2){
                System.out.print("Enter the Room number : ");
                String room_number=getUserString();

                ArrayList<Booking>bookingArrayList = new ArrayList<Booking>();

                bookingArrayList = readBooking();


                for (int i = 0; i < bookingArrayList.size(); i++) {
                    if( bookingArrayList.get(i).getRoom().getRoom_number().equalsIgnoreCase(room_number))
                        System.out.println("Please find your booking  "  +bookingArrayList.get(i).toString());;
                }
                option=false;
            }

        }
    }

    //This is a checkout method where we will do the cancellation for the animals who had booked already
    public void CancelMethod(){
        System.out.print("Enter the name : ");
        String name=getUserString();
        System.out.print("Enter the Room number : ");
        String number=getUserString();

        ArrayList<Booking> bookingArray=new ArrayList<Booking>();
        bookingArray=readBooking();

        for(int i=0;i<bookingArray.size();i++){
            if(bookingArray.get(i).getAnimals().getAnimal_name().equalsIgnoreCase(name)){
                bookingArray.remove(i);
                System.out.println("Booking Cancelled ");
            }

        }

        for (int i = 0; i < bookingArray.size(); i++) {
            if (bookingArray.size() != 0)
                System.out.println(bookingArray.get(i).toString());
            else
                System.out.println("No Booking.");
        }
        writeBooking(bookingArray);
    }

    //This is file write method here we create a file and add all data into the file
    public void writeBooking(ArrayList<Booking> bookingList1) {
        try {
            FileWriter myObj = new FileWriter("C:\\assignment\\filename.txt", true);
        } catch (IOException e) {
            System.out.println("An error occured " + e);
        }

        try {
            FileOutputStream saveFile = new FileOutputStream("C:\\assignment\\filename.txt");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(bookingList1);
            save.flush();
            save.close();
        } catch (IOException e) {
            System.out.println("Error : " + e);
            e.printStackTrace();
        }
    }

        //This is a method to read all data from file
        public ArrayList<Booking> readBooking( ){

            ArrayList<Booking> booking2 =new ArrayList<Booking>();
        try{
            FileInputStream readData = new FileInputStream("C:\\assignment\\filename.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);
             booking2 = (ArrayList<Booking>) readStream.readObject();
            readStream.close();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return booking2;
    }

}



