import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import java.util.Scanner;

public class StackUsingArrays {

    private static final int Max = 10;
    private int stack[] = new int[Max];
    private int top;

    public StackUsingArrays() {
        top = -1;
    }


    public void push(int item) throws Exception {
        if (top >= Max-1) {
            throw new Exception("Stack Overflow!");
        } else {
            top++;
            stack[top] = item;
        }
    }

    public int pop() throws  Exception{
        if (top < 0) {
            throw new Exception("Stack Underflow!");
        }
        int value = stack[top];
        stack[top--] = 0;
        return value;
    }

    public int peek() throws Exception{
        if(top<0){
           throw new Exception("Stack is Empty!");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return (top < 0);
    }


    public int[] getStack(){
        return stack;
    }

    public int getTopOfStack(){
        return top;
    }

    public void printStack() {
        System.out.println("Printing Stack from the top: ");
        for (int i=top; i>=0; i--) {
            System.out.println(stack[i]);
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
                        System.out.println("Top of the stack: "+item2);
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
                System.out.println("Exception: "+ exception.getMessage());
            }
        }
    }
}
