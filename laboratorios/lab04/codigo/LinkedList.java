/**
 * This implementation of a singly linked LinkedList provides insertion time at
 * first O(1) and deletion time at first O(1), at cost of search, insertion and
 * deletion anywhere with cost O(n).
 *
 * @author anietog1, ditrefftzr
 * @param <E> The element type this LinkedList is going to contain.
 */
public class LinkedList<E> {

    private static class Node<E> {

        public E element;
        public Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<E> start;
    private int size;

    /**
     * Creates an empty LinkedList with an initial size of 0.
     */
    public LinkedList() {
        this.start = null;
        this.size = 0;
    }

    /**
     * Adds an element <code>element</code> to the LinkedList at index
     * <code>idx</code>.
     *
     * @param index The index where the element is going to be added. Take care,
     * the index can't be bigger than the size of the LinkedList, but it could
     * be equal, then is like appending to the LinkedList.
     * @param element The element to be added.
     */
    public void add(int index, E element) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.size == 0) {
            this.start = new Node<>(element, null);
        } else if (index == 0) {
            Node<E> curr = new Node<>(element, this.start);
            this.start = curr;
        } else {
            Node<E> current = this.start;
            while (index > 1) {
                current = current.next;
                --index;
            }
            Node<E> newNode = new Node<>(element, current.next);
            current.next = newNode;
        }
        ++this.size;
    }

    /**
     * Removes the element in the LinkedList at index <code>idx</code>.
     *
     * @param index The index of the element to be removed. Index cant be equal to
     * the LinkedList's size: remember 0-indexing.
     */
    public void remove(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (this.size == 1) {
            this.start = null;
        } else if (index == 0) {
            this.start = this.start.next;
        } else {
            Node<E> curr = this.start;
            for (int i = 0; i < index - 1; ++i) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
        }

        --this.size;
    }

    /**
     * Returns the element inside the LinkedList at index <code>idx</code>.
     *
     * @param index The desired index.
     * @return The element in the LinkedList at index <code>idx</code>.
     */
    public E get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> curr = this.start;
        while (index > 0) {
            curr = curr.next;
            --index;
        }

        return curr.element;

    }

    /**
     * Indicates if this LinkedList contains the element <code>element</code>.
     *
     * @param element The element to be searched in the LinkedList.
     * @return true if the LinkedList contains the element, false otherwise.
     */
    public boolean contains(E element) {
        if (this.size != 0) {
            if (element == null) {
                Node<E> curr = this.start;

                while (curr.next != null) {
                    if (curr.element == null) {
                        return true;
                    }

                    curr = curr.next;
                }

            } else {
                Node<E> curr = this.start;

                while (curr.next != null) {
                    if (element.equals(curr.element)) {
                        return true;
                    }

                    curr = curr.next;
                }
            }
        }

        return false;
    }

    /**
     * Indicates the current size of the LinkedList.
     *
     * @return The size of the LinkedList. 0 if no element is inside it.
     */
    public int getSize() {
        return this.size;
    }
}
