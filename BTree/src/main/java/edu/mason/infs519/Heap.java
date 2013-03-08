package edu.mason.infs519;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: jamaal.taylor
 * Date: 3/7/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Heap<T extends Comparable<T>> {

    protected T[] a;//holds head values
    protected int length; //number of array elements which for the heap
    protected boolean empty;// has length of 0?
    protected boolean isHeap;//is everything in "heap order"?


    public Heap(T[] arrayList, int heapSize)
    {
        this.a = arrayList;
        this.length = heapSize;
        this.empty = (length == 0);
        this.buildHeap();
        this.isHeap = true;
    }

    public Heap(T[] arrayList)
    {
        this(arrayList, arrayList.length);
    }

    protected void pushDown(int index, int last)
    {
        int left = 2*index+1;
        int right = 2*index+2;
        //find the position of largest value:index, right, left
        int largest = index;
        if( left <= last && a[left].compareTo( a[largest]) > 0)
        {
            largest = left;
        }

        if(right <= largest && a[right].compareTo(a[largest])  > 0)
        {
            largest = right;
        }

        //we are out of order at index
        swap(a[index], a[largest]);

        pushDown(largest, last);
    }

    private void swap(T index, T largest)
    {

    }

    private void buildHeap()
    {
        for(int index = (length/2)-1; index >= 0; index--)
        {
            pushDown(index, length-1);
        }
        isHeap = true;
    }

    public void heapSort()
    {
        for(int last = length-1; last > 0; last--)
        {
            swap(a[0], a[last]);
            pushDown(0,last-1);
        }
        isHeap = false;
    }

}
