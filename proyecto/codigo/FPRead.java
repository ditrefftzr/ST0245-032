import java.util.*;
import java.io.*;

/**
 * The class FPRead is the Final Project Reader class which onliest job is to
 * read the file which containes the filestree and make a Folder with the same
 * specifications.
 *
 * @author anietog1, kaparrah
 */
public class FPRead {

    private BufferedReader br;
    private int calls;
    private int curr;
    private int currLvl;

    /**
     * Creates a new Final Project Reader which onliest job is to read a file
     * and return a Folder $HOME from it.
     *
     * @param filename The name of the file which contains the data - e.g.
     * ejemplito.txt
     * @throws FileNotFoundException if a file with filename doesn't exist.
     */
    public FPRead(String filename) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filename));
        calls = 0;
    }

    /**
     * Makes a Folder $HOME from the given filename in the constructor, remember
     * this method will only work once and the grammar of the filetree has to be
     * the same shown in ejemplito.txt/juegos.txt, found at:
     *
     * https://github.com/mauriciotoro/ST0245-Eafit/tree/master/proyecto/DataSets
     *
     * @return @throws IOException
     */
    public Folder load() throws IOException {
        if (calls++ > 0) {
            return null;
        }

        jumpBlanks();
        Folder home = new Folder(br.readLine());

        jumpBlanks();
        calcLvl();
        loadTo(home, currLvl);

        return home;
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
        Stack<File> files = new Stack<>();

        while (!isDigit(curr)) {
            calcLvl();

            if (currLvl == fLvl) {
                files.push(make());
                jumpBlanks();
            } else if (currLvl > fLvl) {
                File temp = files.pop();
                Folder child = new Folder(temp.getName());
                loadTo(child, currLvl);
                files.push(child);
            } else {//<
                break;
            }
        }

        while (!files.isEmpty()) {
            fold.add(files.pop());
        }
    }

    private void jumpBlanks() throws IOException {
        do {
            br.mark(1);
        } while ((curr = br.read()) == ' ' || curr == '\n' || curr == '\t');
        br.reset();
    }

    private File make() throws IOException {
        while (br.read() != ']');//Can bug if called from "]"
        jumpBlanks();
        return new File(br.readLine());
    }
}
