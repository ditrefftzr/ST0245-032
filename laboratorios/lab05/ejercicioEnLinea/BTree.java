public class BTree
{
    public class Node
    {
	public Node left;
	public Node right;
	public int value;
    
	public boolean add(int value) {
	    if (value == this.value)
		return false;
	    else if (value <this.value) {
		if (left == null) {
		    left = new Node(value);
		    return true;
		} else
		    return left.add(value);
	    } else if (value > this.value) {
		if (right == null) {
		    right = new Node(value);
		    return true;
		} else
		    return right.add(value);
	    }
	    return false;
	}

	public Node(int element) {
	    this.value = element;
	}
    }

    public Node root;

    public void printPostOrder(){
        this.printInAux(root);
    }

    public void printInAux(Node curr) {
        if (curr != null) {
            BTree.this.printInAux(curr.left);
            BTree.this.printInAux(curr.right);
            System.out.println(curr.value);
        }
    }

    public boolean add(int value) {
            if (root == null) {
                  root = new Node(value);
                  return true;
            } else
                  return root.add(value);
      }
    
    public void preToPost(int[] array){
        Node root= new Node(array[0]);
        for(int i=1 ; i<array.length ; i++){
            root.add(array[i]);
        }
        printInAux(root) ;
    }
    
    public static void main(String [] args){
        int[] test = {50,30,24,5,28,45,98,52,60} ;
        BTree bTree = new BTree();
        bTree.preToPost(test);
    }
    
    
}
