/**
 * Folder class is just a File which is used to make the paths, then it's
 * children Files have a reference to its parent Folder, but essentially it's
 * just like any other File, except that for being a parent of any File, it has
 * to be a Folder.
 *
 * @author agusn
 */
public class Folder extends File {

    /**
     * Folders always have same size of 4K in the given datasets.
     */
    private static final long FOLD_SIZE = 4L * 1024;

    /**
     * Builds a new Folder with the given name and inside the given Folder.
     *
     * @param name The name of the Folder.
     * @param parent The Folder inside which this Folder is.
     * @param user The Folder's user.
     */
    public Folder(String name, Folder parent, String user) {
        super(name, parent, FOLD_SIZE, user);
    }

    @Override
    public String getPath() {
        return super.getPath() + "/";
    }
}
