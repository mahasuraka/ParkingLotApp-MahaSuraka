package cli;

import service.ParkingLotService;
import model.VehicleType;
import java.util.Scanner;

public class ParkingLotCLI {

    private ParkingLotService service = new ParkingLotService();

    public void start() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total parking slots:");
        int total = Integer.parseInt(sc.nextLine());
        service.createParkingLot(total);

        System.out.println("Commands:");
        System.out.println("PARK <plate> <SMALL|LARGE|OVERSIZE>");
        System.out.println("EXIT <plate>");
        System.out.println("STATUS");
        System.out.println("QUIT");

        while(true) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");

            if(parts[0].equalsIgnoreCase("PARK")) {
                service.parkVehicle(parts[1], VehicleType.valueOf(parts[2].toUpperCase()));
            } else if(parts[0].equalsIgnoreCase("EXIT")) {
                service.exitVehicle(parts[1]);
            } else if(parts[0].equalsIgnoreCase("STATUS")) {
                service.displayStatus();
            } else if(parts[0].equalsIgnoreCase("QUIT")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}
