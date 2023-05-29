import java.util.Scanner;
import java.util.InputMismatchException;

class Node{
    int data;
    Node next;
    /*
     * This is a parametrised constructor.
     * It will get invoced automatically when we will create an object of this class.
     */
    Node(int data){
        this.data = data;
        this.next = null;
    }
}


class CreateQueue{
    Node head;

    /* This function is used for adding new element in the queue.
    function will accept an integer value and will add that value in the end.
     */
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next !=null){
            temp = temp.next;
        }
        temp.next = newNode; 
    }
/*
 * This function will delete an value at the end of the queue.
 */
    public void delete(){
        if(head == null){
            return;
        }
        head = head.next;
    }


    /*
     * This function will accept an index number and will update the value of that index.
     * This function will accept an index number and a new value. 
     * And then it will replace the  index value with the new value.
     */
    public void update(int index, int newValue){
        Node temp = head;
        int count = 0;
        while(temp != null){
            if(count==index)break;
            temp = temp.next;
            count +=1;
            
        }
        temp.data = newValue;
    }
/*
 * This method is used for displaying each element of queue list.
 * This method does not receive any argument as well as it does not return anything.
 */
    public void displayData(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+ " --> ");
            curr = curr.next;
        }
        System.out.println();

    }

/*
 * This method is used for searching any element present in the queue.
 */
    public void search(int data){
        Node curr = head;
        int counter = 0;
        while(curr != null){
            if (curr.data == data){
                System.out.println("Element Found at: "+counter);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Element not present in the queue.");
    }
}

public class Queue{
    public static void main(String[] args) {
        /*
         * Creating an object of createQueue class so that we can use it to access the methods 
         * of that class.
         */
        CreateQueue obj = new CreateQueue();

        /*
         * Creating an object of scanner class so that we can use them to take input from user.
         * System.in is used for taking input from keyboard.
         */
        Scanner input = new Scanner(System.in);

        /*
         * Providing multiple options for users so that they can perforrm various functions.
         * Like add, delete, update and show data.
         */
        System.out.println("Enter 1 for adding new value.");
        System.out.println("Enter 2 for updating a value.");
        System.out.println("Enter 3 for deleting a value.");
        System.out.println("Enter 4 for displaying a value.");
        System.out.println("Enter 5 for searching.");
        System.out.println("Enter 6 to exit.");
        loop:while(true){
            try{
                
                int option;
                option = input.nextInt();
                switch (option) {
                    case 1:
                            
                        System.out.print("Enter an element. ");
                        int value = input.nextInt();
                        obj.add(value);
                        System.out.println("Element added");
                        break;
                
                    case 2:
                        System.out.println("Enter a index value. ");
                        int index = input.nextInt();
                        System.out.println("Enter new value. ");
                        int newValue = input.nextInt();
                        obj.update(index, newValue);
                        System.out.println("Element updated.");
                        break;


                    case 3:
                        obj.delete();
                        System.out.println("Your data deleted successfully.");
                        break;
                    case 4:
                        obj.displayData();
                        break;
                    case 5:
                    
                    case 6:
                        break loop;
                    default:
                        System.out.println("Enter a valid option.");
                
                }
            }catch(InputMismatchException ex){
                System.out.println("Invalid input");
                input = new Scanner(System.in);
            }
        }
    
    }
}