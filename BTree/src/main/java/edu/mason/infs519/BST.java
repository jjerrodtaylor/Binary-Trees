package edu.mason.infs519; /**
 * Created by IntelliJ IDEA.
 * User: jamaal.taylor
 * Date: 2/21/13
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class BST<T extends Comparable<T> >{

    /*
    * Cases for deleting from a tree
    *
    * 1)Search for it. If you can't find it, there is nothing to delete
    *
    * 2) If the item that you want to delete is in a leaf the just set the
    *    parent connection that points to it to null.
    *
    * 3)If the item that you want to delete has one child then bypass
    *
    * Uses of BST's
    * You can use binary search trees to implement a table.
    * This is an abstract data type used for storing key/value pairs.
    * Keys must be unique
    *
    * Operations:
    * boolean insert(key, value) makes a new entry in the table. return true if successful
    *
    * value lookup(key) returns value from key/value pair (null if not in table)
    *
    * boolean delete(key) removes key/value pair- return whether successful
    *
    * You can use lots of data types to implement a table.
    * Even though you can use a linked list, I BST is a lot more effecient.
    *
    * We want to be able to take 2 different type in entry eg. (Entr<key, value> to store Entry as T in BST. BST extends
    * comparable
    *
    * Entry needs a compareTo method which must depend only on key field
    *
    * Table will have a private inner class
    *
    * */


    //you don't have to write getter/setter methods for this class
    //since it an inner class of BST, the BST class automatically has
    //access to everything in the inner class even though the fields are
    //declared private
    private class BSTNode<T>
    {
        private T data;
        private BSTNode<T> left, right;

        //remember, when you write a constructor for a parameterized type
        //you don't include the angle brackets
        public BSTNode(T data)
        {
            this.data = data;
        }

        public BSTNode(T data, BSTNode<T> left, BSTNode<T> right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public T getData()
        {
            return this.data;
        }

        public void setLeft(BSTNode<T> left)
        {
            this.left = left;
        }

        public BSTNode<T> getLeft()
        {
            return this.left;
        }

        public void setRight(BSTNode<T> right)
        {
            this.right = right;
        }

        public BSTNode<T> getRight()
        {
            return this.right;
        }

        public boolean isLeaf()
        {
            return (left == null) && (right == null);
        }
    }

    private BSTNode<T> root;

    public boolean isEmpty()
    {
        return root == null;
    }

    //you pass in the root of the tree
    private T search(T target, BSTNode<T> ptr)
    {
        if(ptr == null)
        {
            //target isn't in the tree
            return null;
        }

        //we're constraining our class to an interface that implemented comparable
        //we're assuming that compareTo was written correctly
        int compare = target.compareTo(ptr.data);

        if(compare == 0)
        {
            //we found what we're looking for
            return ptr.data;
        }

        //target preceeds compare
        //we have to continue our search in the left sub-tree
        if(compare < 0)
        {
            return search(target, ptr.left);
        }

        return search(target, ptr.right);
    }

    public T search(T target)
    {
        //return null if target not in tree
        return search(target, root);
    }

    //insert value in a child of ptr return false if duplicate found
    //Precondition: ptr must NOT be null
    private boolean insert(T value, BSTNode<T> ptr)
    {
        int compare = value.compareTo(ptr.data);

        if(compare == 0)
        {
            //we have a duplicate value
            return false;
        }

        if(compare < 0)
        {
            if(ptr.left == null)
            {
                //we found an insertion point
                ptr.left = new BSTNode<T>(value);// insert value in a new node
                return true;
            }
            else
            {
                return insert(value, ptr.left);//continue recursively down the left sub-tree
            }
        }


        if(ptr.right == null)
        {
            //we found an insertion point
            ptr.right = new BSTNode<T>(value);
            return true;
        }
            else
            {
                return insert(value, ptr.right);//continue recursively down the right sub-tree
            }


        //what is the final return statement???
    }

    public boolean insert(T value)
    {
        if(root.data == null)
        {
            root = new BSTNode<T>(value);
            return true;
        }
        else
        {
            return insert(value, root);
        }
    }

    /*
    * visit is a generic term for do work.
    * Imaging replaceing visit with any function like compare or something
    * */
    public void preorder(BSTNode<T> n)
    {
        if(n != null)
        {
             //visit(n);
             preorder(n.left);
             preorder(n.right);
        }
    }

    /*
    * visit is a generic term for do work.
    * Imaging replaceing visit with any function like compare or something
    * */
    public void postorder(BSTNode<T> n)
    {
        if(n != null)
        {
            postorder(n.left);
            postorder(n.right);
            //visit(n);
        }
    }

    /*
    * visit is a generic term for do work.
    * Imaging replaceing visit with any function like compare or something
    * */
    public void inorder(BSTNode<T> ptr)
    {
        if(ptr != null)
        {
             inorder(ptr.left);
             //visit(ptr);
             inorder(ptr.right);
        }
    }

    public T getLeftmostData(BSTNode<T> ptr)
    {
        if(ptr.left == null)
        {
            return ptr.data;
        }
        else
        {
            return this.getLeftmostData(ptr.left);
        }
    }

    //returns the right most data from a node in a tree
    public T getRightmostData(BSTNode<T> ptr)
    {
        if(ptr.right == null)
        {
            return ptr.data;
        }
        else
        {
            return this.getRightmostData(ptr.right);
        }
    }

    /*
    * There are several types of balanced BST's.
     * The most popular are AVL trees and Red/Black trees
    * */

}
