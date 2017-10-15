package hardcorefp;

import java.io.*;
import java.util.*;

public class Tests {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FPRead b = new FPRead("C:\\Users\\agusn\\Desktop/juegos.txt");
        Folder home = b.load();
        Tests a = new Tests();
//        System.out.println(home.getName());
//        a.tree(home, "|");
        home.find("Mario Power Tennis (2009) [Wii][PAL][MULTi5][WwW.ZoNaTorrent.CoM].iso");
    }
    
    /**
     * Recursively prints all the Files inside the given Folder.
     * @param start
     * @param bars 
     */
    public void tree(Folder start, String bars) {
        LinkedList<File> list = start.getAll();

        list.forEach((f) -> {
            System.out.println(bars + f.getName());
            if (f instanceof Folder) {
                tree((Folder) f, bars + "|");
            }
        });
    }
}
