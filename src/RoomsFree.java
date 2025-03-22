import java.sql.SQLOutput;
import java.util.Scanner;

public class RoomsFree {


    Scanner input = new Scanner(System.in);
    private Room room;

    public void roomsAvailable(){

        room = new Room();

        System.out.println("---------------");
        System.out.println("AVAİLABLE ROOMS");
        System.out.println("---------------");

        System.out.println("DO YOU WANT TO SEE AVAİLABLE ROOMS? ('Y' FOR THE ENTER THE SYSTEM/PRESS ANY KEY FOR QUIT)");
        String line = input.nextLine();

        while(line.equalsIgnoreCase("y")){

            System.out.println("------------------------------------------------------");
            System.out.println(10-room.roomFourList.size()+"4 STAYERS ROOM AVAILABLE");
            System.out.println(6- room.roomThreeList.size()+"3 STAYERS ROOM AVAILABLE");
            System.out.println(7-room.roomTwoList.size()+"2 STAYERS ROOM AVAILABLE");
            System.out.println("------------------------------------------------------");


            System.out.println("DO YOU WANT TO SEE AVAİLABLE ROOMS? ('Y' FOR THE ENTER THE SYSTEM/PRESS ANY KEY FOR QUIT)");
            line = input.nextLine();
        }


    }

}
