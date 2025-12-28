import java.util.Scanner;
// Generic Functional Interface
@FunctionalInterface
interface DataProcessor<T, R> 
{
 	R process(T t);
}
public class EcommerceDataProcessing {
public static void main(String[] args) {
              		Scanner sc = new Scanner(System.in);
        		int choice;
        		do {
            			System.out.println("\n------- E-commerce Data Processing -------");
            			System.out.println("1. Find Maximum of Two Product Quantities");
            			System.out.println("2. Apply Discount on Product Price");
            			System.out.println("3. Concatenate Customer Names");
            			System.out.println("4. Count Words in a Customer Review");
           		 	System.out.println("5. Exit");
            			System.out.print("Enter your choice: ");
            			choice = sc.nextInt();
           	 		sc.nextLine(); // consume newline
            			switch (choice) {
                			case 1:
                    			  	System.out.print("Enter first quantity: ");
                    				int q1 = sc.nextInt();
                    				System.out.print("Enter second quantity: ");
                    				int q2 = sc.nextInt();
                    			DataProcessor<int[], Integer> maxProcessor = (nums) -> 
                                                                                            (nums[0] > nums[1]) ? nums[0] : nums[1];
                    				System.out.println("Maximum Quantity: " + maxProcessor.process
(new int[]{q1, q2}));
                    				break;
                			case 2:
                    				System.out.print("Enter product price: ");
                    				double price = sc.nextDouble();
                    				System.out.print("Enter discount percentage: ");
                    				double discount = sc.nextDouble();
                    				DataProcessor<double[], Double> discountProcessor = (values) -> 
values[0] - (values[0] * values[1] / 100);
                    				System.out.println("Final Price after Discount: " + discountProcessor.process
(new double[]{price, discount}));
                    				break;
                			case 3:
                    				System.out.print("Enter first name: ");
                    				String firstName = sc.nextLine();
                    				System.out.print("Enter last name: ");
                   	 			String lastName = sc.nextLine();
                    				DataProcessor<String[], String> nameProcessor = (names) ->
 names[0] + " " + names[1];
                    				System.out.println("Full Name: " + nameProcessor.process
(new String[]{firstName, lastName}));
                    				break;
                			case 4:
                    				System.out.print("Enter customer review: ");
                   	 			String review = sc.nextLine();
                    				DataProcessor<String, Integer> wordCountProcessor = 
(text) -> text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
                    				System.out.println("Number of words in review: " 
+ wordCountProcessor.process(review));
                    				break;
                			case 5:
                    				System.out.println("Exiting... Thank you!");
                    				break;
                			default:
                    				System.out.println("Invalid choice! Please try again.");
            			}

        		} while (choice != 5);
        		sc.close();
    	}
}
