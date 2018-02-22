import java.util.Scanner;


public class QueueUsingDoublyLL {
    private DoublyNode front = null;
    private DoublyNode rear = null;
    private int count =0;
    private int Max = 10;


    public void add(int data) throws Exception{
        if(this.count == this.Max){
            throw new Exception("Queue Overflow!");
        }
        DoublyNode newNode = new DoublyNode(data);

        if(this.front == null){
            this.front = newNode;
        }

        if(this.rear!=null){
            this.rear.next = newNode;
            newNode.prev = this.rear;
        }
        this.rear = newNode;
        this.count++;
    }


    public int remove() throws Exception{
        if(this.front == null){
            throw new Exception("Queue Underflow!");
        }

        int value = this.front.value;
        DoublyNode doublyNode = this.front;
        this.front = this.front.next;
        doublyNode = null;

//        if(this.top!=null){
//            this.top.next = null;
//        }
        this.count--;
        return value;
    }

    public int peek() throws Exception{
        if(this.front == null){
            throw new Exception("Queue is Empty!");
        }
        return this.front.value;
    }

    public boolean isEmpty(){
        return this.front==null;
    }

    public DoublyNode getFrontOfQueue(){
        return front;
    }

    public DoublyNode getRearOfQueue(){
        return rear;
    }

    public void printQueue(){
        System.out.println("Printing Queue from front to rear: ");
        DoublyNode current = this.front;
        while(current!=null){
            System.out.print(current.value+" ");
            current = current.next;
        }
    }


    public void mainMenu(Scanner scanner) {
        int operationNumber = 0;
        while (operationNumber != 5) {
            System.out.println("\nChoose what you want to do:\n  1: Add an item to the queue\n  2: Remove an item from the queue\n  3: Get front of the queue\n  4: Check if queue is empty\n  5: Exit");
            operationNumber = scanner.nextInt();
            try {
                switch (operationNumber) {
                    case 1:
                        System.out.println("Enter a value to add: ");
                        int item = scanner.nextInt();
                        this.add(item);
                        System.out.println(item + " added to the queue!");
                        this.printQueue();
                        break;
                    case 2:
                        int item1 = this.remove();
                        System.out.println(item1+" removed from the queue!");
                        this.printQueue();
                        break;
                    case 3:
                        int item2 = this.peek();
                        System.out.println("Front of the queue: "+ item2);
                        this.printQueue();
                        break;
                    case 4:
                        System.out.println("Result: " + this.isEmpty());
                        this.printQueue();
                        break;
                    case 5:
                        System.out.println("Exited");
                        break;
                    default:
                        System.out.println("Give a valid input");
                        break;
                }
            }
            catch (Exception exception){
                System.out.println("Exception: "+ exception.getMessage());
            }
        }
    }

}

