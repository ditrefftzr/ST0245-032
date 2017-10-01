/**
 * Class specifying the most important aspects of a File.
 *
 * @author anietog1, ditrefftzr
 */
public class File {

    private String name;
    private long size;

    /**
     * Builds a new File with name <code>name</code> and size <code>size</code>.
     *
     * @param name The name of the File.
     * @param size The size of the File.
     * @throws java.lang.Exception if tried to make a file with a negative size.
     */
    public File(String name, long size) throws Exception {
        if(size < 0) throw new Exception("File with negative size " + size);
        this.name = name;
        this.size = (size<=0)? 0:size;
    }
    
    /**
     * Builds a new File with name <code>name</code> and an initial size of 0.
     *
     * @param name The name of the File.
     */
    public File(String name){
        this.name = name;
        this.size = 0;
    }

    /**
     * Returns the name of this File.
     *
     * @return The name of this File.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returs the size of this File.
     *
     * @return The size of this File.
     */
    public long getSize() {
        return this.size;
    }

    /**
     * Changes the <code>name</code> attribute of this File.
     *
     * @param name The new name this File is going to have.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes the <code>size</code> attribut of this File by a given amount.
     *
     * @param amount How much the size of this size changed, it can also be
     * negative values.
     */
    public void changeSize(long amount) {
        this.size += amount;
    }

    @Override
    public String toString() {
        return this.name + " [" + this.size + "bytes]";
    }
}
