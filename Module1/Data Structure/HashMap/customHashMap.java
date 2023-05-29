import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomHashMap {

    /*
     * class for creating the hash map link.
     * this class contains a parameterised constructor which takes key and a value as an parameter.
     */
    static class KeyValuePair{
        int key;
        int value;
        KeyValuePair next;
        KeyValuePair(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    /*
     * This class is created for performing basic operation of hash map.
     */
    static class NewHashMap{
        KeyValuePair[] container;
        int size;
        // Conteructor for initialization of container.
        // It takes an argument size and then creates a hashMap of that size.
        NewHashMap(int size){
            this.size = size;
            this.container = new KeyValuePair[size];
            for (int i=0; i<size; i++)this.container[i] = null;
        }

        // Hash fucntion which will provide us the index of the container so that we can store the 
        // store the key value pair there.
        public int hashFunction(int key){
            return key%size;
        }
        /*
         * This function is used for storing/ inserting key, value pair in the hash map.
         * It takes two argument key and value.
         */
        public void insert(int key, int value){
            int indexValue = hashFunction(key);
            KeyValuePair newNode = new KeyValuePair(key, value);
            
            if(container[indexValue] == null){
                container[indexValue] = newNode;
            }
            else{
                KeyValuePair curr = container[indexValue];
                if(curr.key==key){
                    curr.value = value;
                    return ;
                }
                while(curr.next !=null){
                    if(curr.next.key==key){
                        curr.next.value=value;
                        return;
                    }
                    curr = curr.next;
                }
                curr.next = newNode;
            }
        }

        /*
         * This function is used to get data from the hash map.
         * function accepts a key value and search for the value associted with that key.
         */
        public void getData(int key){
            int indexValue = hashFunction(key);
            System.out.print("Your data is:  ");
            try{
                KeyValuePair data = container[indexValue];
                while(data != null){
                    if(data.key == key){
                        System.out.print(data.value);
                        break;
                    }
                    data = data.next;
                }
                System.out.println();

            }catch (Exception e){
                System.out.println("value doex not exists");
            }

        }
        /*
         * This function is used for deleting an element from the hash map
         * function accepts a key and search for the same in the hash map 
         * and then delete that key value pair.
         */
        public boolean delete(int key){
            int indexValue = hashFunction(key);
            KeyValuePair data = container[indexValue];
            if(data.next == null && data.key == key){
                container[indexValue] = null;
                return true;
            }
            else if(data.next == null){
                System.out.println("Unable to find the value for provided key");
                return false;
            }
            else if(data.key == key){
                data.key=data.next.key;
                data.value = data.next.value;
                data.next = data.next.next;
                return true;
            }
            while(data!=null){
                if(data.next.key == key){
                    data.next = data.next.next;
                    return true;
                }

            }
            return false;
            
        }

        // This function is used for displaying the complete hash map
        public void displayHashMap(){
            int index = 0;
            for(KeyValuePair start : container){
                System.out.print(index+" ");
                while(start !=null){
                    System.out.print(" { "+start.key+":"+start.value+" }"+"-->");
                    start = start.next;
                }
                index +=1;
                System.out.println();
            }
        }
        /*
         * This function is used for searching data with the help of value
         * The complexity of this function is o(n).
         * Function takes one argument value and search in the hash map for that value.
         */
        public void searchByValue(int value){
             for(KeyValuePair start: container){
                while(start !=null){
                    if(start.value == value){
                        System.out.println("value found "+start.key + " : "+ start.value);
                        return ;
                    }
                    start=start.next;
                }
             }
             System.out.println("provided value is not present in the hash map.");
             return;
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of hash map.");
        int size = input.nextInt();
	    NewHashMap obj = new NewHashMap(size);
        int option;
        loop:while(true){
        // Menu option for the user.
            System.out.println("1 : Insert ");
            System.out.println("2 : Delete ");
            System.out.println("3 : Get value of the key.");
            System.out.println("4 : Display the Hashmap.");
            System.out.println("5 : Search an element");
            System.out.println("6 : Exit");
            System.out.println("Enter your choice : ");
        
            option = input.nextInt();
            try{
                switch(option){
                    case 1:
                        System.out.print("Enter key : ");
                        int key = input.nextInt();
                        System.out.print("Enter a value: ");
                        int value = input.nextInt();
                        obj.insert(key, value);
                        System.out.println("Data inserted");
                        break;
                    case 2:
                        System.out.println("Enter the key: ");
                        int keys = input.nextInt();
                        boolean resp = obj.delete(keys);
                        if(resp){
                            System.out.println("Element deleted successfully.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter a key: ");
                        int key2 = input.nextInt();
                        obj.getData(key2);
                        break;
                    case 4:
                        obj.displayHashMap();
                        break;
                    case 5:
                        System.out.print("Enter the value: ");
                        int values = input.nextInt();
                        obj.searchByValue(values);
                        break;
                    case 6:
                        break loop;
                    default:
                        System.out.println("Please enter a valid option. ");

                }
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input.");
                input = new Scanner(System.in);
            }
        }
    }
}