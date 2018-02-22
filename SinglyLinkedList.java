import java.util.Scanner;

class Node{
    int value;
    Node next;  //by default null   OR  you can write next = null;

    public Node(int x){
        value = x;
    }

}

public class SinglyLinkedList {
    private Node head = null;
    private Node previousNode = null;

    //createNode, addNewNode, DeleteNode, searchInList, getNode
    public Node getHead(){
        return this.head;
    }

    public Node createNode(int data){
        return new Node(data);
    }

    //Efficient way to add node
    public void addNewNode(int data){
        Node newNode = this.createNode(data);

        if(this.previousNode!=null){
            this.previousNode.next = newNode;
        }
        if(this.head==null){
            this.head = newNode;
        }

        this.previousNode = newNode;
    }

    public boolean searchInNode(int searchValue){
        Node current = this.head;
        while(current!=null){
            if(current.value == searchValue){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void deleteNodeByValue(int deleteValue){
        if(this.head == null){
            System.out.println("The list is empty");
            return;
        }

        Node current = this.head;
        Node prev = null;
        while(current!=null){
            if(current.value == deleteValue){
                if(current==this.head){
                    this.head = current.next;
                }else if(current.next!=null){
                    prev.next = current.next;
                }else{
                    prev.next = null;
                    this.previousNode = prev;
                }
                current = null;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void deleteNodeByNumber(int nodeNumberToDelete){
        if(this.head == null){
            System.out.println("The list is empty");
            return;
        }

        int count =1;
        Node current = this.head;
        Node prev = null;
        if(nodeNumberToDelete == 1){
            this.head = current.next;
            current = null;
            return;
        }
        while(count!=nodeNumberToDelete && current!=null){
            prev = current;
            current = current.next;
            count++;
        }

        if(current == null){
            return;
        }
        prev.next = current.next;
        current = null;

        if(prev.next==null){
            this.previousNode = prev;
        }
    }

    public Node getNode(int nodeNumberToGetValue){
        Node current = this.head;
        int count=1;
        while(count!=nodeNumberToGetValue && current!=null){
            current = current.next;
            count++;
        }
        return current;
    }

    public void mainMenu(Scanner scanner){
        int operationNumber =0;
        while(operationNumber!=6){
            System.out.println("\nChoose what you want to do:\n  1: Add node to the list\n  2: Delete node from the list with a value\n  3: Remove ith node from the list\n  4: Get ith node from the list\n  5: Search a value in the list\n  6: Exit");
            operationNumber = scanner.nextInt();
            switch (operationNumber){
                case 1: System.out.println("Enter a value to add: ");
                    int data = scanner.nextInt();
                    this.addNewNode(data);
                    this.printList();
                    break;
                case 2: System.out.println("Enter the value to delete: ");
                    int deleteValue = scanner.nextInt();
                    this.deleteNodeByValue(deleteValue);
                    this.printList();
                    break;
                case 3: System.out.println("Enter the node number to remove/delete: ");
                    int nodeNumberToDelete = scanner.nextInt();
                    this.deleteNodeByNumber(nodeNumberToDelete);
                    this.printList();
                    break;
                case 4: System.out.println("Enter the node number to get its value: ");
                    int nodeNumberToGetValue = scanner.nextInt();
                    Node returnedNode = this.getNode(nodeNumberToGetValue);
                    int value = returnedNode!=null ? returnedNode.value : -1;
                    System.out.println("Node value: "+value);
                    break;
                case 5: System.out.println("Enter a value to search: ");
                    int searchValue = scanner.nextInt();
                    boolean isPresent = this.searchInNode(searchValue);
                    String result = isPresent ? "Value is present in the list" : "Value is absent in the list";
                    System.out.println("Result: "+result);
                    break;
                case 6: System.out.println("Exited");
                    break;
                default:System.out.println("Give a valid input");
                    break;
            }
        }
    }

    public void printList(){
        System.out.println("List:");
        Node current = this.head;
        while(current!=null){
            System.out.print(current.value+" ");
            current = current.next;
        }
    }

}
