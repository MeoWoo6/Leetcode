package ds_hash;

import java.util.Iterator;
import java.util.LinkedList;

// 类似HashSet, 只不过原来的key 变成了现在的(key, value) 但是还是靠key来定位
public class MyHashMap {
    private static final int BASE = 769;
    private LinkedList[] data;
//  Initialize the Pair class
    class Pair{
        private int key;
        private int value;

        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return key;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }
}

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for(int i=0; i<BASE; i++){
            data[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> pairs = data[h].iterator();
        while(pairs.hasNext()){
            Pair element = pairs.next();
            if(element.getKey() == key){
                element.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> pairs = data[h].iterator();
        while(pairs.hasNext()){
            Pair element = pairs.next();
            if(element.getKey() == key){
                return element.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> pairs = data[h].iterator();
        while(pairs.hasNext()){
            Pair element = pairs.next();
            if(element.getKey() == key){
                data[h].remove(element);
                return;
            }
        }
    }

    private static int hash(int key){
        return key % BASE;
    }
}
