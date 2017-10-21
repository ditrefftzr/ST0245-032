import java.util.*;
import java.io.*;

public class Tests {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Loader loader = new Loader("C:\\Users\\agusn\\Desktop/juegos.txt");
        FileStructure a = loader.load();

        LinkedList<File> b = a.get("dolphin-emu.mo");
        b.forEach((x) -> {
            System.out.println(x.getPath());
        });
    }
}
