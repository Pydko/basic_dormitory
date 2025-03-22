import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            //THERE IS RUNNER MENU


            Entered entered = new Entered();
            Id id = new Id();
            Update update = new Update();
            DeleteStudent deleteStudent = new DeleteStudent();
            PrivateNotes privateNotes = new PrivateNotes();
            Room room = new Room();
            RoomsFree roomsFree = new RoomsFree();
            Saver saver = new Saver();


            System.out.println("------------------------------");
            System.out.println(" ");
            System.out.println("WELCOME TO THE PYD DORM SYSTEM");
            System.out.println(" ");
            System.out.println("------------------------------");

            System.out.println("DO YOU WANT TO CONTINUE");
            String join = input.nextLine();

            while(!join.isEmpty()) {

                    System.out.println("('1') PRESS FOR SEE THE ENTITIES");
                    System.out.println("('2') PRESS FOR SAVE ENTITIES");
                    System.out.println("('3') PRESS FOR UPDATE ENTITIES");
                    System.out.println("('4') PRESS FOR DELETE ENTITIES");
                    System.out.println("('5') PRESS FOR SAVE / SEE / DELETE THE PRIVATE NOTES");
                    System.out.println("('6') PRESS FOR SEE ROOMS ");
                    System.out.println("('7') PRESS FOR SEE THE HOW MANY ROOMS AVAILABLE");
                    System.out.println("('8') PRESS FOR EXİT");

                    int press = input.nextInt();

                    switch(press){
                            case 1: saver.entitiesGetter();
                            break;

                            case 2: entered.registerHuman();
                            break;

                            case 3: update.updateEntities(entered.entitiesList);
                            break;

                            case 4: deleteStudent.deleteEntitites(entered.entitiesList);
                            break;

                            case 5: privateNotes.noteAsker(entered.entitiesList);
                            break;

                            case 6: room.separator(entered.entitiesList);
                            break;

                            case 7: roomsFree.roomsAvailable();
                            break;

                            case 8: System.out.println("EXITING...");
                            return;

                            default:
                                    System.out.println("SOMETHIN WENT WRONG");
                    }
            }






    }
}