/**
 * @author anietog1, ditrefftzr
 * @param <E> The type of Objects we want our ArrayList to contain.
 */
public class ArrayList<E> {

    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    
    /**
     * Creates a new ArrayList with initial capacity of <code>initial capacity</code>.
     * @param capacity The initial capacity we want our List to have.
     */
    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }
    
    /**
     * Creater a new ArrayList with initial capacity of 10.
     */
    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Indicates the number of elements this list contains.
     * @return The size of the list.
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Adds element at the end of the list.
     * @param element Element to be added.
     */
    public void add(E element) {
        this.add(element, this.size);
    }

    /**
     * Returns the element at index.
     * @param index Index of the element we want to get.
     * @return Element stored at index.
     */
    public E get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)this.elements[index];
    }
    
    /**
     * Adds element at index.
     * @param element Element to be added.
     * @param index Index in which the element is going to be added.
     */
    public void add(E element, int index) {
        this.add(element, index, DEFAULT_CAPACITY);
    }
    
    /**
     * Adds element at index and, if required, expands the array by expansionSize parameter.
     * @param element Element to be added.
     * @param index Index in which the element is going to be added.
     * @param expansionSize Expansion size of the expansion if required: number of spaces to be added if there are not.
     */
    public void add(E element, int index, int expansionSize){
        if(this.size < this.elements.length){
            if(index <= this.size){
                this.makeAHole(index);
                this.elements[index] = element;
                this.size++;
            }
        }else{
            this.expand(expansionSize);
            this.add(element, index);
        }
    }
    
    /**
     * Expands the array that contains the elements.
     * @param n The number of spaces to be expanded.
     */
    private void expand(int n){
        Object[] arr = new Object[this.elements.length + n];
        System.arraycopy(elements, 0, arr, 0, this.elements.length);
        this.elements = arr;
    }
    
    /**
     * Moves everything from index <code> index </code> one space to the right.
     * @param index 
     */
    private void makeAHole(int index){
        for(int i=size; i>index; i--){
            this.elements[i] = this.elements[i-1];
        }
    }
    
    /**
     * Deletes the element at index <code> index </code>.
     * @param index The index of the element to be deleted.
     */
    public void remove(int index){
        fillAHole(index);
        this.size--;
    }
    
    /**
     * Moves everything from index <code> index + 1 </code> one space to the left.
     * @param index 
     */
    private void fillAHole(int index){
        for(int i=index; i<this.size; i++){
            this.elements[i] = this.elements[i+1];
        }
    }
}
