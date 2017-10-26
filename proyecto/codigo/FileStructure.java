import java.util.TreeMap;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeSet;

/**
 * FileStructure class allows to insert Files and search them by name, size,
 * extension, user and parent Folder with a O(log(n)) complexity. Searches are
 * always made from HOME, but as it's O(log(n)), even if there are 10^24 (1
 * billion squared) Files, finding one in the given categories would just take
 * 80-82 operations.
 *
 * @author anietog1, ditrefftzr
 */
public class FileStructure {

    private final TreeMap<String, LinkedList<File>> byName;
    private final TreeMap<Long, LinkedList<File>> bySize;
    private final TreeMap<String, LinkedList<File>> byExt;
    private final TreeMap<String, LinkedList<File>> byUser;
    private final TreeMap<String, TreeSet<File>> byFolder;
    private long size;

    /**
     * Builds a new FileStructure.
     */
    public FileStructure() {
        byName = new TreeMap<>();
        bySize = new TreeMap<>();
        byExt = new TreeMap<>();
        byUser = new TreeMap<>();
        byFolder = new TreeMap<>();
        size = 0;
    }

    /**
     * Searches for all Files with the given name.
     *
     * @param name The name of the Files searched.
     * @return A LinkedList with all the Files with the given name, null if not
     * a File with that name.
     */
    public LinkedList<File> getByName(String name) {
        return byName.get(name);
    }

    /**
     * Searches for all Files with the given size.
     *
     * @param size The searched size.
     * @return A LinkedList
     */
    public LinkedList<File> getBySize(Long size) {
        return bySize.get(size);
    }

    /**
     * Returns a SortedMap representing the part of the Tree with size less than
     * or equal to the given one.
     *
     * @param size The max size of File searched.
     * @return A SortedMap with all the Files with sizes equal to or less than
     * the given one.
     *
     * For more information, see SortedMap.headMap(K, bool)
     */
    public SortedMap<Long, LinkedList<File>> getLessThan(Long size) {
        return bySize.headMap(size, true);
    }

    /**
     * Returns a SortedMap representing the part of the Tree with size higher
     * than or equal to the given one.
     *
     * @param size The minimun size of File searched.
     * @return A SortedMap with all the Files with sizes equal to or higher than
     * the given one.
     *
     * For more information, see SortedMap.tailMap(K, bool)
     */
    public SortedMap<Long, LinkedList<File>> getHigherThan(Long size) {
        return bySize.tailMap(size, true);
    }

    /**
     * Searches for all the Files with the given extension, the extension has to
     * be without the dot, and its found in Files as: [filename].[ext].
     *
     * @param ext The extension of the searched Files.
     * @return A LinkedList with all Files with extension ext, null if there's
     * not a File with that extension.
     */
    public LinkedList<File> getByExt(String ext) {
        return byExt.get(ext);
    }

    /**
     * Searches for all Files with the given username.
     *
     * @param user The user of the Files.
     * @return All the Files with the given user, null if not such user.
     */
    public LinkedList<File> getByUser(String user) {
        return byUser.get(user);
    }

    /**
     * Searches all the Files inside the Folder with the given path. The grammar
     * for paths is HOME/[foldername/...]
     *
     * @param folder The searched Folder.
     * @return All the files with the given Folder as it's parent, null if
     * there's no File with the given Folder as its parent or the given Folder
     * doesn't exists.
     */
    public TreeSet<File> getByFolder(Folder folder) {
        return getByFolder(folder.getPath());
    }

    /**
     * Searches all the Files inside the Folder with the given path. The grammar
     * for paths is HOME/[foldername/...]
     *
     * @param path The path of the searched Folder.
     * @return All the files in the Folder with the given path, null if there's
     * not such Folder.
     */
    public TreeSet<File> getByFolder(String path) {
        return byFolder.get(path);
    }

    /**
     * Adds the given File if not repeated to all the trees in this class,
     * allowing to search it with complexity O(log(n)) (n being the number of
     * Files in the FileStructure) by name, size, extension, user and its parent
     * folder's path.
     *
     * @param file The File to be added.
     * @return true if file added else false.
     */
    public boolean add(File file) {
        if (file == null
                || file.getName() == null
                || file.getParent() == null
                || file.getUser() == null
                || file.getSize() < 0L
                || !addByFolder(file)) {
            //if any invalid field or already in Structure, return false
            return false;
        }

        addByName(file);
        addBySize(file);
        addByExt(file);
        addByUser(file);
        ++size;
        return true;
    }

    private boolean addByFolder(File file) {
        String path = file.getParent().getPath();
        TreeSet<File> curr = getByFolder(path);

        if (curr == null) {
            curr = new TreeSet<>((File o1, File o2) -> o1.getName().compareTo(o2.getName()));

            byFolder.put(path, curr);
        }

        return curr.add(file);
    }

    private void addByUser(File file) {
        LinkedList<File> curr = getByUser(file.getUser());

        if (curr == null) {
            curr = new LinkedList<>();
            byUser.put(file.getUser(), curr);
        }

        curr.add(file);
    }

    private void addByName(File file) {
        LinkedList<File> curr = getByName(file.getName());

        if (curr == null) {
            curr = new LinkedList<>();
            byName.put(file.getName(), curr);
        }

        curr.add(file);
    }

    private void addByExt(File file) {
        String ext = "";
        String name = file.getName();

        for (int i = name.length() - 1; i >= 0; --i) {//obtain the ext
            if (name.charAt(i) == '.') {
                ext = name.substring(i + 1);//ext is saved without .
                break;
            }
        }

        LinkedList<File> curr = getByExt(ext);

        if (curr == null) {
            curr = new LinkedList<>();
            byExt.put(ext, curr);
        }

        curr.add(file);
    }

    private void addBySize(File file) {
        LinkedList<File> curr = getBySize(file.getSize());

        if (curr == null) {
            curr = new LinkedList<>();
            bySize.put(file.getSize(), curr);
        }

        curr.add(file);
    }

    /**
     *
     * @return The number of Files in this FileStructure.
     */
    public long getSize() {
        return size;
    }
}
