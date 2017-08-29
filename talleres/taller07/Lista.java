class Lista {

    private Node start;

    private class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Lista() {
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
    
    public void print(int index){
        Node temp = start;
        while(index > 0){
            temp = temp.next;
            index--;
        }
        System.out.println(temp.data);
    }
    
    public void print() {
        Node temp = this.start;
        StringBuilder sb = new StringBuilder("[");
        while (temp != null) {
            sb.append(temp.data + ",");
            temp = temp.next;
        }
        sb.append(']');
        System.out.println(sb);
    }
    
    
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.agregarInicio(1);
        lista.agregarInicio(2);
        lista.agregarFinal(0);
        lista.agregarFinal(123);
        lista.print(0);
        lista.eliminarPrimer();
        lista.print();
        lista.eliminarUltimo();
        lista.print();
    }
}
