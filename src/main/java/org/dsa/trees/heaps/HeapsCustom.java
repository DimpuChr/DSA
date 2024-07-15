package org.dsa.trees.heaps;

import java.util.ArrayList;
import java.util.List;

public class HeapsCustom <T extends Comparable<T>> {

    public ArrayList<T> list;

    public HeapsCustom(){
        list = new ArrayList<>();
    }

    public HeapsCustom(List<T> unsortedList) {
        list = new ArrayList<>(unsortedList);
        buildMaxHeap();
    }


    private void swap (int first, int second){
        T temp = list.get(first);
        list.set(first ,list.get(second));
        list.set(second, temp);
    }

    private int getParent(int index){
        return (index - 1) /2;
    }

    private int getLeft(int index){
        return  (index * 2) + 1;
    }

    private int getRight(int index){
        return  (index * 2) + 2;
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() -1);
    }

    private void upheap(int index) {
        if(index == 0){
            return;
        }
        int parent = getParent(index);
        if(list.get(index).compareTo(list.get(parent)) <0){
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap!!");
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = getLeft(min);
        int right = getRight(min);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min != index){
            swap(min , index);
            downheap(min);
        }
    }
    private void downheapMax(int index) {
        int max = index;
        int left = getLeft(max);
        int right = getRight(max);

        if (left < list.size() && list.get(max).compareTo(list.get(left)) < 0) {
            max = left;
        }
        if (right < list.size() && list.get(max).compareTo(list.get(right)) < 0) {
            max = right;
        }

        if (max != index) {
            swap(max, index);
            downheapMax(max);
        }
    }
    public void buildMaxHeap() {
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            downheapMax(i);
        }
    }


    public List<T> heapSort() throws Exception {

        List<T> result = new ArrayList<>();
        while (!list.isEmpty()){
            result.add(this.remove());
        }
        return result;
    }
}
