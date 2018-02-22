import java.util.Scanner;
import java.util.Stack;


public class BinarySearchTree {

    private BSTNode BSTRoot;

    public BSTNode insert(BSTNode node, int value){
        if(node == null){
            node = new BSTNode(value);
        }
        else if(value <= node.value){
            node.left = this.insert(node.left, value);
        }
        else{
            node.right = this.insert(node.right, value);
        }
        return node;
    }

    public boolean search(BSTNode node, int value){
        while(node != null) {
            if (value == node.value) {
                return true;
            } else if (value < node.value) {
                node = node.left;
                this.search(node, value);
            } else {
                node = node.right;
                this.search(node, value);
            }
        }
        return false;
    }

    public void inOrder(BSTNode node){
        if(node!=null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    public void preOrder(BSTNode node){
        if(node != null){
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(BSTNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    //Or you can also refer to iterative solution online
    public void inOrderIterative(BSTNode node){
        Stack<BSTNode> stack = new Stack<>();
        this.pushToStack(stack, node);

        while(!stack.isEmpty()){
            BSTNode currNode = stack.pop();
            System.out.println(currNode.value);
            if(currNode.right != null){
                currNode = currNode.right;
                this.pushToStack(stack, currNode);
            }
        }
    }

    public void pushToStack(Stack<BSTNode> stack, BSTNode node){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }

    public void preOrderIterative(BSTNode node){
        Stack<BSTNode> stack = new Stack<>();
        this.pushToStack1(stack, node);

        while(!stack.isEmpty()){
            BSTNode currNode = stack.pop();
            if(currNode.right != null){
                currNode = currNode.right;
                this.pushToStack1(stack, currNode);
            }
        }
    }

    public void pushToStack1(Stack<BSTNode> stack, BSTNode node){
        while(node!=null){
            stack.push(node);
            System.out.println(node.value);
            node = node.left;
        }
    }

    public void postOrderIterative( BSTNode root) {
        if( root == null ) return;

        Stack<BSTNode> stack = new Stack<>( );
        BSTNode current = root;

        while( true ) {

            if( current != null ) {
                if( current.right != null )
                    stack.push( current.right );
                stack.push( current );
                current = current.left;
                continue;
            }

            if( stack.isEmpty( ) )
                return;
            current = stack.pop( );

            if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
                stack.pop( );
                stack.push( current );
                current = current.right;
            } else {
                System.out.println(current.value);
                current = null;
            }
        }
    }

//
//    public void postOrderIterative(BSTNode node){
//        Stack<BSTNode> stack = new Stack<>();
//        stack.push(node);
//
//        BSTNode prev = null;
//        while(!stack.empty()){
//            BSTNode curr = stack.peek();
//
//            // go down the tree.
//            //check if current node is leaf, if so, process it and pop stack,
//            //otherwise, keep going down
//            if(prev == null || prev.left == curr || prev.right == curr){
//                //prev == null is the situation for the root node
//                if(curr.left != null){
//                    stack.push(curr.left);
//                }else if(curr.right != null){
//                    stack.push(curr.right);
//                }else{
//                    stack.pop();
//                    System.out.println(curr.value);
//                }
//
//                //go up the tree from left node
//                //need to check if there is a right child
//                //if yes, push it to stack
//                //otherwise, process parent and pop stack
//            }
//            else if(curr.left == prev){
//                if(curr.right != null){
//                    stack.push(curr.right);
//                }else{
//                    stack.pop();
//                    System.out.println(curr.value);
//                }
//
//                //go up the tree from right node
//                //after coming back from right node, process parent node and pop stack.
//            }
//            else if(curr.right == prev){
//                stack.pop();
//                System.out.println(curr.value);
//            }
//
//            prev = curr;
//        }
//    }


    public BSTNode getRoot(){
        return BSTRoot;
    }

    public void mainMenu(Scanner scanner){
        BSTNode root = null;
        int choice = 0;

        while(choice != 10){
            System.out.println("Enter what you want to do\n 1: Insert in the BST\n 2: Search in the BST\n 3: Inorder Traversal\n 4: Preorder Traversal\n 5: Postorder Traversal\n 6: Inorder Iterative\n 7: Preorder iterative\n 8: Postorder iterative\n 9: Assign root\n 10: Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1: System.out.println("Enter the element you want to insert:");
                        int element = scanner.nextInt();
                        root = this.insert(root, element);
                        break;
                case 2: System.out.println("Enter the element you want to search:");
                        int searchValue = scanner.nextInt();
                        boolean result = this.search(root, searchValue);
                        System.out.println("Result: "+result);
                        break;
                case 3: System.out.println("Inorder Traversal:");
                        this.inOrder(root);
                        break;
                case 4: System.out.println("Preorder Traversal:");
                        this.preOrder(root);
                        break;
                case 5: System.out.println("Postorder Traversal:");
                        this.postOrder(root);
                        break;
                case 6: System.out.println("Inorder iterative");
                        this.inOrderIterative(root);
                        break;
                case 7: System.out.println("Preorder iterative");
                        this.preOrderIterative(root);
                        break;
                case 8: System.out.println("Postorder iterative");
                        this.postOrderIterative(root);
                        break;
                case 9: this.BSTRoot = root;
                        break;
                case 10:System.out.println("Exited");
                        break;
                default: System.out.println("Enter a valid choice");
                        break;
            }
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.mainMenu(scanner);
    }
}
