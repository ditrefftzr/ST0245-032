public class LinkedList<E> {
    private Node start;

    private class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        this.start = null;
    }

    public void agregarInicio(int n) {
        Node added = new Node(n);
        if (start != null) {
            added.next = start;
            start = added;
        } else {
            start = added;
        }
    }

    public void agregarFinal(int n){
        Node temp = this.start;
        if(temp == null){
            temp = new Node(n);
        }else{
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(n);
        }
    }

    public void eliminarPrimer(){
        if(start != null)
           start = start.next;
    }

    //Hay un problemita si el tamaño es menor a dos
    public void eliminarUltimo(){
        Node temp = start;
        if(temp != null){
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }
}
