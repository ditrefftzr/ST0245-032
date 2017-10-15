/**
 * Class specifying the most important aspects of a File.
 *
 * @author anietog1, ditrefftzr
 */
public class File {

    private String name;

    /**
     * Makes a new File with the given parameters (specifications).
     *
     * @param name The name this File is going to have.
     */
    public File(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this File.
     *
     * @return The name field of this File.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Changes the <code>name</code> attribute of this File.
     *
     * @param name The new name this File is going to have.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
