public class BTree{
    public Node root;
    
    public void printInorder(){
        this.printInAux(root);
    }
    
    public void printInAux(Node curr) {
        if (curr != null) {
            BTree.this.printInAux(curr.left);
	    System.out.print(curr.element);
            BTree.this.printInAux(curr.right);
        }
    }
    
    public void printGraphviz(){
        System.out.println("digraph G {");
        printGvAux(root);
        System.out.println("}");
    }
    
    public String quoted(String str){
        return "\"" + str + "\"";
    }
    
    public void printGvAux(Node root){
        if(root != null){
            if(root.left != null){
                System.out.println(quoted(root.element) + "->" + quoted(root.left.element));
                printGvAux(root.left);
            }
            
            if(root.right != null){
                System.out.println(quoted(root.element) + "->" + quoted(root.right.element));
                printGvAux(root.right);
            }
        }
    }
    
    public static void main(String[] args) {
        Node wilkenson = new Node("Wilkenson"),
	    joaquina = new Node("Joaquina"),
	    eustaquia = new Node("Eustaquia"),
	    eustaquio = new Node("Eustaquio"),
	    jovin = new Node("Jovin"),
	    florinda = new Node("Florinda"),
	    sufranio = new Node("Sufranio"),
	    piolina = new Node("Piolina"),
	    piolin = new Node("Piolin"),
	    wilberta = new Node("Wilberta"),
	    usnavy = new Node("Usnavy");
        wilkenson.left = joaquina;
        wilkenson.right = sufranio;
        joaquina.left = eustaquia;
        joaquina.right = eustaquio;
        eustaquia.left = florinda;
        eustaquio.right = jovin;
        
        sufranio.left = piolina;
        sufranio.right = piolin;
        piolina.left = wilberta;
        piolin.right = usnavy;
        
        BTree tr = new BTree();
        tr.root = wilkenson;
        tr.printInorder();
        System.out.println();
        tr.printGraphviz();
    }
}
