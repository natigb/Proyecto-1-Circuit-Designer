/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;
/**
 * 
 * @author Nati Gonzalez
 */

public class LinkedList{

    private Node head;
    private int size;
    
    class Node{

        private Object data;
        private Node next;

            public Node(Object data){
                this.next= null;
                this.data = data;
                }

            public Object getData(){
                return this.data;

            }

            public void setData(Object data){
                this.data = data;

            }

            public Node getNext(){
                return this.next;

            }

            public void setNext(Node node){
                this.next = node;

            }
    }

    public LinkedList(){
        this.head= null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        return this.size;
    }

    public void insertFirst(Object data){
        if (head==null){
            head = new Node(data);
        }
        else{
          Node temp = head;
          Node newNode = new Node(data);
          newNode.setNext(temp);
          head = newNode;
          
        }
        this.size++;

    }

    public Node deleteFirst(){

        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.getNext();
            this.size--;
            return temp;

        }else{
             return null;

        }
    }
    public int search(Object x){ 
        int amount=0;
        Node current = head;     
        while (current != null){ 
            if (current.data == x) 
                amount++; 
                 
            current = current.next; 
        } 
        return amount;     
    }
      
    public void printList(LinkedList list) { 
        
        Node current = list.head; 
   
        System.out.print("LinkedList: "); 
        while (current != null) { 
            System.out.print(current.data + " "); 
   
            current = current.next; 
        } 
    } 

    }

