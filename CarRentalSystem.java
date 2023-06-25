import java.util.Scanner;

public class CarRentalSystem {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cars = {"Honda", "Toyota", "Ford"};
        boolean[] availability = {true, true, true};
        double[] prices = {50.0, 60.0, 55.0};

        while (true) {
            System.out.println("Car Rental System");
            System.out.println("-----------------");
            System.out.println("1. Check available cars");
            System.out.println("2. Reserve a car");
            System.out.println("3. Return a car");
            System.out.println("4. Display rented cars");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Cars:");
                    boolean allCarsUnavailable = true;
                    for (int i = 0; i < cars.length; i++) {
                        if (availability[i]) {
                            System.out.println((i + 1) + ". " + cars[i]);
                            allCarsUnavailable = false;
                        }
                    }
                    if (allCarsUnavailable) {
                        System.out.println("No cars currently available.");
                    }
                    break;
                case 2:
                    System.out.println("\nAvailable Cars:");
                    boolean allCarsRented = true;
                    for (int i = 0; i < cars.length; i++) {
                        if (availability[i]) {
                            System.out.println((i + 1) + ". " + cars[i]);
                            allCarsRented = false;
                        }
                    }
                    if (allCarsRented) {
                        System.out.println("No cars currently available for rental.");
                        break;
                    }
                    System.out.print("Enter the car number to reserve: ");
                    int carNumber = scanner.nextInt();
                    if (carNumber >= 1 && carNumber <= cars.length && availability[carNumber - 1]) {
                        System.out.print("Enter the number of days for rental: ");
                        int numDays = scanner.nextInt();
                        double totalCost = prices[carNumber - 1] * numDays;
                        System.out.println("Car reserved successfully!");
                        System.out.println("Total rental cost: $" + totalCost);
                        availability[carNumber - 1] = false;
                    } else {
                        System.out.println("Invalid car number or car is not available for rental.");
                    }
                    break;
                case 3:
                    System.out.println("\nRented Cars:");
                    boolean allCarsReturned = true;
                    for (int i = 0; i < cars.length; i++) {
                        if (!availability[i]) {
                            System.out.println((i + 1) + ". " + cars[i]);
                            allCarsReturned = false;
                        }
                    }
                    if (allCarsReturned) {
                        System.out.println("No cars currently rented.");
                    } else {
                        System.out.print("Enter the car number to return: ");
                        int returnCarNumber = scanner.nextInt();
                        if (returnCarNumber >= 1 && returnCarNumber <= cars.length && !availability[returnCarNumber - 1]) {
                            availability[returnCarNumber - 1] = true;
                            System.out.println("Car returned successfully!");
                        } else {
                            System.out.println("Invalid car number or car is already available.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nRented Cars:");
                    boolean noCarsRented = true;
                    for (int i = 0; i < cars.length; i++) {
                        if (!availability[i]) {
                            System.out.println(cars[i]);
                            noCarsRented = false;
                        }
                    }
                    if (noCarsRented) {
                        System.out.println("No cars currently rented.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    
}
