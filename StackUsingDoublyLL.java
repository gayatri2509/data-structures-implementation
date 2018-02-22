import java.util.Scanner;


public class StackUsingDoublyLL {
    private DoublyNode top = null;
    private int count =0;
    private int Max = 10;

    public void push(int data) throws Exception{
        if(this.count == this.Max){
            throw new Exception("Stack Overflow!");
        }
        DoublyNode newNode = new DoublyNode(data);

        if(this.top!=null){
            this.top.next = newNode;
            newNode.prev = this.top;
        }
        this.top = newNode;
        this.count++;
    }


    public int pop() throws Exception{
        if(this.top == null){
            throw new Exception("Stack Underflow!");
        }

        int value = this.top.value;
        DoublyNode doublyNode = this.top;
        this.top = this.top.prev;
        doublyNode = null;

//        if(this.top!=null){
//            this.top.next = null;
//        }
        this.count--;
        return value;
    }

    public int peek() throws Exception{
        if(this.top == null){
            throw new Exception("Stack is Empty");
        }
        return this.top.value;
    }

    public boolean isEmpty(){
       return this.top==null;
    }

    public DoublyNode getTopOfStack(){
        return top;
    }

    public void printStack(){
        System.out.println("Printing stack from the top:");
        DoublyNode current = this.top;
        while(current!=null){
            System.out.println(current.value);
            current = current.prev;
        }
    }


    public void mainMenu(Scanner scanner) {
        int operationNumber = 0;
        while (operationNumber != 5) {
            System.out.println("\nChoose what you want to do:\n  1: Push an item to the stack\n  2: Pop an item from the stack\n  3: Get top of the stack\n  4: Check if stack is empty\n  5: Exit");
            operationNumber = scanner.nextInt();
            try {
                switch (operationNumber) {
                    case 1:
                        System.out.println("Enter a value to add: ");
                        int item = scanner.nextInt();
                        this.push(item);
                        System.out.println(item + " pushed to the stack!");
                        this.printStack();
                        break;
                    case 2:
                        int item1 = this.pop();
                        System.out.println(item1+" popped from the stack!");
                        this.printStack();
                        break;
                    case 3:
                        int item2 =  this.peek();
                        System.out.println("Top of the stack: "+ item2);
                        this.printStack();
                        break;
                    case 4:
                        System.out.println("Result: " + this.isEmpty());
                        this.printStack();
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
                System.out.println("Exception: "+exception.getMessage());
            }
        }
    }

}

