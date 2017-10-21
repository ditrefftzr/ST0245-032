import java.io.*;
import java.util.Stack;

/**
 * The class Loader is the class which onliest job is to read the file which
 * containes the filestree and make a Folder with the same specifications.
 *
 * @author anietog1, kaparrah
 */
public class Loader {

    private BufferedReader br;
    private int calls;
    private int curr;
    private int currLvl;
    private FileStructure files;

    /**
     * Creates a new Loader which onliest job is to read a file and return a
     * Folder $HOME from it.
     *
     * @param filename The name of the file which contains the data - e.g.
     * ejemplito.txt
     * @throws FileNotFoundException if a file with filename doesn't exist.
     */
    public Loader(String filename) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filename));
        files = new FileStructure();
        calls = 0;
    }

    public FileStructure load() throws IOException {
        if (calls++ > 0) {
            return null;
        }

        jumpBlanks();
        Folder home = new Folder(br.readLine().split("/")[0], null);

        jumpBlanks();
        calcLvl();
        loadTo(home, currLvl);

        return files;
    }

    private boolean isDigit(int a) {
        return a >= '0' && a <= '9';
    }

    private void calcLvl() throws IOException {
        if (curr == '[') {//Si el actual es '[', el nivel ya fue calculado
            return;
        }

        currLvl = 0;
        while ((curr = br.read()) != '[') {
            ++currLvl;
        }
    }

    private void loadTo(Folder fold, int fLvl) throws IOException {
        Stack<File> inners = new Stack<>();

        while (!isDigit(curr)) {
            calcLvl();

            if (currLvl == fLvl) {
                inners.push(makeFor(fold));
                jumpBlanks();
            } else if (currLvl > fLvl) {
                File temp = inners.pop();
                Folder child = new Folder(temp.getName(), temp.getParent());
                loadTo(child, currLvl);
                inners.push(child);
            } else {//<
                break;
            }
        }

        while (!inners.isEmpty()) {
            files.add(inners.pop());
        }
    }

    private void jumpBlanks() throws IOException {
        do {
            br.mark(1);
        } while ((curr = br.read()) == ' ' || curr == '\n' || curr == '\t');
        br.reset();
    }

    private File makeFor(Folder fold) throws IOException {
        while (br.read() != ']');//Can bug if called from "]"
        jumpBlanks();
        return new File(br.readLine(), fold);
    }
}
