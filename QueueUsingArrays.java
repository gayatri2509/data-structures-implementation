import java.util.Scanner;

public class QueueUsingArrays {

    private static final int Max = 10;
    private int queue[] = new int[Max];
    private int front, rear;

    public QueueUsingArrays() {
        front = -1;
        rear = -1;
    }


    public void add(int item) throws Exception{
        if (rear >= Max-1) {
            throw new Exception("Queue Overflow!");
        } else {
            rear++;
            if(front == -1){
                front++;
            }
            queue[rear] = item;
        }
    }

    public int remove() throws Exception{
        if (front < 0) {
            throw new Exception("Queue Underflow!");
        }
        int item = queue[front];
        for(int i = front; i<rear; i++){
            queue[i] = queue[i+1];
        }
        queue[rear] = 0;
        rear--;
        if(rear == -1) { front = -1; }
        return item;
    }

    public int peek() throws Exception{
        if(front < 0){
            throw new Exception("Queue is Empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return (front < 0);
    }

    public int[] getQueue(){
        return queue;
    }

    public int getFrontOfQueue(){
        return front;
    }

    public int getRearOfQueue(){
        return rear;
    }

    public void printQueue() {
        System.out.println("Printing Queue from front to rear: ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
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
