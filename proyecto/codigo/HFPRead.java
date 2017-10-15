import java.util.*;
import java.io.*;

public class HFPRead {

    private BufferedReader br;
    private int curr;
    private int currLvl;

    HFPRead(String filename) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filename));
    }

    public Folder load() throws IOException {
        jumpBlanks();
        Folder home = new Folder(br.readLine());

        jumpBlanks();
        calcLvl();
        loadTo(home, currLvl);

        return home;
    }

    private boolean isLetter(int a) {
        return (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z');
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
        while (br.read() != ']');//Puede buggearse si se llama desde "]"
        jumpBlanks();
        return new File(br.readLine());
    }
}
