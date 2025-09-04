import java.io.FileWriter;
import java.util.Scanner;
public class AreaCalculator {
    public static void main(String[] args) {
        System.out.println("\n-------------Welcome to  Area Calculator portion-------------");
        Scanner input = new Scanner(System.in);
        String choice;
        String history="";
        int count=1;
        do {
            System.out.println("\n-----------------------------------------------");
            System.out.println("Choose a shape to calculate its area:");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Circle");
            System.out.println("5. Pentagon");
            System.out.println("6. Hexagon");
            System.out.println("7. Return to main menu.");
            System.out.println("-----------------------------------------------");
            System.out.print("Enter your choice here: ");
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    while(true){
                        try{
                            System.out.print("Enter the side length of the square: ");
                            double squareSide = input.nextDouble();
                            input.nextLine();
                            double squareArea = squareArea(squareSide);
                            System.out.println("Area of the square: " + squareArea);
                            history="Square.";
                            break;
                        }
                        catch(Exception e){
                            System.out.println(e);
                            input.nextLine();
                        }
                    }
                    break;
                case "2":
                    while (true) {
                        try{
                            System.out.print("Enter the length of the rectangle: ");
                            double rectangleLength = input.nextDouble();
                            input.nextLine();
                            System.out.print("Enter the width of the rectangle: ");
                            double rectangleWidth = input.nextDouble();
                            input.nextLine();
                            double rectangleArea = rectangleArea(rectangleLength, rectangleWidth);
                            System.out.println("Area of the rectangle: " + rectangleArea);
                            history="Rectangle";
                            break;
                        }
                        catch(Exception e){
                            System.out.println(e);
                            input.nextLine();
                        }
                    }
                    break;
                case "3":
                    while(true){
                        try{
                            System.out.print("Enter the base length of the triangle: ");
                            double triangleBase = input.nextDouble();
                            input.nextLine();
                            System.out.print("Enter the height of the triangle: ");
                            double triangleHeight = input.nextDouble();
                            input.nextLine();
                            double triangleArea = triangleArea(triangleBase, triangleHeight);
                            System.out.println("Area of the triangle: " + triangleArea);
                            history="Triangle";
                            break;
                            }
                        catch(Exception e){
                            System.out.println(e);
                            input.nextLine();
                        }
                    }
                    break;
                case "4":
                    while(true){
                        try{
                            System.out.print("Enter the radius of the circle: ");
                            double circleRadius = input.nextDouble();
                            input.nextLine();
                            double circleArea = circleArea(circleRadius);
                            System.out.println("Area of the circle: " + circleArea);
                            history="Circle";
                            break;
                        }
                        catch(Exception e){
                            System.out.println(e);
                            input.nextLine();
                        }
                    }
                    break;
                case "5":
                    while(true){
                        try{
                            System.out.print("Enter the side length of the pentagon: ");
                            double pentagonSide = input.nextDouble();
                            input.nextLine();
                            double pentagonArea = pentagonArea(pentagonSide);
                            System.out.println("Area of the pentagon: " + pentagonArea);
                            history="Pentagon";
                            break;
                            }
                        catch(Exception e){
                            System.out.println(e);
                            input.nextLine();
                        }
                    }
                    break;
                case "6":
                    while(true){
                        try{
                            System.out.print("Enter the side length of the hexagon: ");
                            double hexagonSide = input.nextDouble();
                            input.nextLine();
                            double hexagonArea = hexagonArea(hexagonSide);
                            System.out.println("Area of the hexagon: " + hexagonArea);
                            history="Hexagon";
                            break;
                        }
                        catch(Exception e){
                            System.out.println(e);
                            input.nextLine();
                        }
                    }
                    break;
                case"7":
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    history="Invalid choice";
                    break;
            }
            System.out.println();

            try (FileWriter fileWriter = new FileWriter("History.txt", true)){
                fileWriter.write("\t"+count+"."+history+"\n");
            }
            catch(Exception e){
                System.out.println(e);
            }
            count++;
        } while (!choice .equals( "7"));
    }

    public static double squareArea(double side) {
        return side * side;
    }

    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double pentagonArea(double side) {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

    public static double hexagonArea(double side) {
        return (3 * Math.sqrt(3) * side * side) / 2;
    }
}
