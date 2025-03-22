import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room implements IRoom{
    Scanner input = new Scanner(System.in);

    List<Entities> roomFourList = new ArrayList<>();
    List<Entities> roomThreeList = new ArrayList<>();
    List<Entities> roomTwoList = new ArrayList<>();

    final double fourStayersPrice = 1234.50;
    final double threeStayersPrice = 1350.00;
    final double twoStayersPrice = 1520.25;



    public void information(){
        System.out.println("----------------");
        System.out.println("------ROOMS-----");
        System.out.println("----------------");


        System.out.println("4 STAYERS ROOM 1234.50 DOLLARS");
        System.out.println("3 STAYERS ROOM 1350.00 DOLLARS");
        System.out.println("2 STAYERS ROOM 1520.50 DOLLARS");

    }



    public void separator(List<Entities> entitiesList){
        System.out.println("-------------------");
        System.out.println("-----SEPARATOR-----");
        System.out.println("-------------------");

        System.out.println("ARE YOU SURE('Y' FOR ENTER SYSTEM / PRESS ANY KEY FOR QUIT)");
        String line  = input.nextLine();
        while (line.equalsIgnoreCase("y")) {

            for (Entities entities : entitiesList) {
                System.out.println("NAME: " + entities.getFirstName() + " " + entities.getLastName());
                System.out.println("SURNAME: " + entities.getSurname());
                System.out.println("ID: " + entities.getId());
                System.out.println("---------------------");
                System.out.println(" ");
            }
            System.out.println("ENTER AN ID FOR SEPARATES: ");
            int id = input.nextInt();


            Entities entitiesForSeparates = entitiesList.get(id-1);
            if (entitiesForSeparates == null) {
                System.out.println("THAT CAN NOT BE HAPPENS BROTHER ENTER A VALID ID...");
                continue;
            } else {
                System.out.println("WHICH ROOM HE/SHE STAY");
                System.out.println("('4' for 4 stayers room)/('3' for 3 stayers room)/('2' for 2 stayers room)");
                int asker = input.nextInt();
                switch (asker){
                    case 4:
                        System.out.println("4 STAYERS ROOM"); fourStayersRoom(entitiesForSeparates); break;
                    case 3:
                        System.out.println("3 STAYERS ROOM"); threeStayersRoom(entitiesForSeparates); break;
                    case 2:
                        System.out.println("2 STAYERS ROOM"); twoStayersRoom(entitiesForSeparates); break;
                }
            }
        }





    }



    @Override
    public List<Entities> fourStayersRoom(Entities roomEntities) {
        roomFourList.add(roomEntities);
        return roomThreeList;
    }

    @Override
    public List<Entities> threeStayersRoom(Entities roomEntities) {
        roomThreeList.add(roomEntities);
        return roomThreeList;
    }

    @Override
    public List<Entities> twoStayersRoom(Entities roomEntities) {
        roomTwoList.add(roomEntities);
        return roomTwoList;
    }
}
