package org.example;

import java.util.List;

class ListManager{
    public void addElement(List<Integer> list, int element){
        list.add(element) ;
    }

    public boolean removeElement(List<Integer> list, Integer element){
        list.remove(element) ;
        return list.contains(element) ;
    }

    public int getSize(List<Integer> list){
        return list.size() ;
    }
}