package com.company;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {


        public static void main(String[] args) {
//MyArrayList: public void add(T newItem, int index)

            System.out.println("-----------------------Arraylist add-----------------------");
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
            arrlist.add(7);
            arrlist.add(1);
            arrlist.add(3);
            arrlist.add(4);
            arrlist.add(2,2);
            for (Integer list : arrlist) {
                System.out.println("Added = " + list);
            }


//MyArrayList: public int find(T keyItem) – returns index or -1

            System.out.println("-----------------------Arraylist find-----------------------");
            boolean retval = arrlist.contains(7);
            if (retval == true) {
                System.out.println(arrlist.get(0  ));
            } else {
                System.out.println("-1");
            }
//MyArrayList: public T remove(int index) – returns removed element

            System.out.println("-----------------------Arraylist remove-----------------------");
            System.out.println(arrlist.remove(3));

//MyArrayList: public void reverse() – reverses the ArrayList (1,2,3,4 becomes 4,3,2,1)
            System.out.println("-----------------------Arraylist reverse-----------------------");
            reverse(arrlist);

            System.out.println("-----------------------LinkedList add-----------------------");
            LinkedList<String> list1 = new LinkedList<String>();
            list1.add("Geeks");
            list1.add("for");
            list1.add("Geeks");
            list1.add("10");
            list1.add("20");
            System.out.println("1st " + list1);
            list1.add(2,"Hello");
            list1.add(4,"End");
            System.out.println("2nd" + list1);
            System.out.println("-----------------------LinkedList  find-----------------------");
            System.out.println("-----------------------LinkedList  remove-----------------------");
            System.out.println("-----------------------LinkedList  reverse-----------------------");
        }


    public static void reverse(ArrayList<Integer> list) {
        Integer [] reverse = new Integer[list.size()];
        System.out.println(list);
        for (int i=list.size()-1; i>=0; i--){
            reverse[i]= list.get(i);
            System.out.print(reverse[i]+" ");
        }
    }



}
//    public static void add(ArrayList<Integer> arrlist, int index){
//        arrlist.add(0);
//        arrlist.add(1);
//        arrlist.add(3);
//        arrlist.add(4);
//        arrlist.add(index,2);
//        for (Integer list : arrlist) {
//            System.out.println("Added = " + list);
//        }
//    }

