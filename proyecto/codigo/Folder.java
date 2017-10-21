/**
 * Folder class is just a File which is used to make the paths, then it's
 * children Files have a reference to its parent Folder, but essentially it's
 * just like any other File, except that for being a parent of any File, it has
 * to be a Folder.
 *
 * @author anietog1
 */
public class Folder extends File {

    /**
     * Builds a new Folder with the given name and inside the given Folder.
     *
     * @param name The name of the Folder.
     * @param parent The Folder inside which this Folder is.
     */
    public Folder(String name, Folder parent) {
        super(name, parent);
    }

    @Override
    public String getPath() {
        return super.getPath() + "/";
    }
}
