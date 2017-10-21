/**
 * New aproach for making a File, this time every File knows in which Folder it
 * is, and it's name, because for making search by name it's unnecessary to save
 * the other data.
 *
 * @author agusn
 */
public class File {

    private final String name;
    private final Folder parent;

    /**
     * Builds a new File with the given name and the given folder.
     *
     * @param name The name of the file.
     * @param parent The folder inside which this file is.
     */
    public File(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    /**
     * Indicates the path from home of the current File, home must be the
     * onliest Folder without a parent.
     *
     * @return The path from home of the current File.
     */
    public String getPath() {
        if (parent == null) {
            return name;
        }

        return parent.getPath() + name;
    }

    /**
     * The given name of the File.
     *
     * @return The name of the File.
     */
    public String getName() {
        return name;
    }

    /**
     * Indicates in which Folder this File is in.
     *
     * @return The parent of the File.
     */
    public Folder getParent() {
        return parent;
    }
}
