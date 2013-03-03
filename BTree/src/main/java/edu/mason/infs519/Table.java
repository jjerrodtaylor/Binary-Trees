package edu.mason.infs519; /**
 * Created by IntelliJ IDEA.
 * User: jamaal.taylor
 * Date: 2/28/13
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Table<Key extends Comparable<Key>, Value> {

    /*
    * The purpose of entry is to glue together a key and a value
    *
    * The class that we use for Key has to implement comparable
    * */
    private class Entry<Key extends Comparable<Key>, Value> implements Comparable<Entry>
    {
        Key key;
        Value value;

        public Entry(Key k, Value v)
        {
            key = k;
            value = v;
        }

        public int compareTo(Entry<Key,Value> entry)
        {
            return key.compareTo(entry.key);
        }
    }

    private BST<Table<Key, Value>.Entry<Key, Value>> tree = new BST<Table<Key, Value>.Entry<Key, Value>>();

    //must supply public methods for the three operations

    public Value lookUp(Key key)
    {
        Entry<Key, Value> e = new Entry<Key, Value>(key, null);

        return tree.search(e).value;
    }

    public boolean insert(Key k, Value v)
    {
        return tree.insert(new Entry<Key, Value>(k, v));
    }

    public boolean delete(Key k)
    {
        //we haven't written a delete method for bst yet.
        return tree.delete(new Entry(k, null));
    }

    /*
    * Question: How efficient is a bst anyway?
    * Answer: It depends on the shape of the tree?
    *
    * To be really useful a bst should be reasonably balanced
    * */

}
