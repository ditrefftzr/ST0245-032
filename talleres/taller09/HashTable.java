import java.util.LinkedList;
import java.util.ArrayList;

public class HashTable<K, V> {

    private static class Pair<K, V> {
	public final K key;
        public final V val;

        public Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private final LinkedList<Pair<K, V>> table[];

    public HashTable() {
        this.table = new LinkedList[10];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public HashTable(int n) {
        this.table = new LinkedList[n];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public V get(K key) {
        for (Pair<K, V> pair : table[hash(key)]) {
            if (pair.key.equals(key)) {
                return pair.val;
            }
        }
        return null;
    }

    public void add(K key, V val) {
        table[hash(key)].add(new Pair<>(key, val));
    }

    public ArrayList<K> getKeys(){
	ArrayList<K> arr = new ArrayList<>();
	for(LinkedList<Pair<K,V>> l: table)
	    if(!l.isEmpty())
		for(Pair<K,V> p: l)
		    arr.add(p.key);
		    
	return arr;
    }
}
