import java.util.*;

public class FileStructure {

    private final TreeMap<String, LinkedList<File>> byName;

    public FileStructure() {
        byName = new TreeMap<>();
    }

    public LinkedList<File> get(String name) {
        return byName.get(name);
    }

    public void add(File file) {
        LinkedList<File> curr = get(file.getName());

        if (curr == null) {
            curr = new LinkedList<>();
            byName.put(file.getName(), curr);
        }

        curr.add(file);
    }
}
