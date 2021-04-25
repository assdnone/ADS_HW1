package com.company;

public class LinkedList<T> {
    private int size;
    private DoublyNode<T> root;

    public void add(T data) {
        if (data == null) {
            return;
        }

        if (root == null) {
            root = new DoublyNode<T>(data);
        } else {
            DoublyNode<T> newNode = new DoublyNode<T>(data);
            DoublyNode<T> lastNode = getLastNode(root);
            lastNode.setNext(newNode);
            newNode.setPrevious(lastNode);
        }
        size++;
    }
    public void addAtFirst(T data) {
        if (data == null) {
            return;
        }
        DoublyNode<T> newNode = new DoublyNode<T>(data);
        if (this.root != null) {
            this.root.setPrevious(newNode);
            newNode.setNext(this.root);
            this.root = newNode;
        } else {
            this.root = newNode;
        }
        size++;
    }
    public void add(T data, int index) throws IndexOutOfBoundsException {
        if (data == null) {
            return;
        }
        // If index=0 , we should add the data at head
        if (index == 0) {
            addAtFirst(data);
            return;
        }
        // If index= size, we should add the data at last
        if (index == this.size) {
            add(data);
        } else if (index < this.size) {
            DoublyNode<T> newNode = new DoublyNode<T>(data);
            // get the node at (index) from linked list and mark as rightNode.
            // get the node at (index-1) from linked list and mark as leftNode.
            // set node of newly created node as right node.
            // set node of left node as newly created Node.
            DoublyNode<T> rightNode = getNode(index);
            DoublyNode<T> leftNode = rightNode.getPrevious();
            leftNode.setNext(newNode);
            newNode.setPrevious(leftNode);
            newNode.setNext(rightNode);
            rightNode.setPrevious(newNode);
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index not available.");
        }
    }
    private DoublyNode<T> getNode(int index) {

        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index not available.");
        }
        // If index=0 , return head
        if (index == 0) {
            return this.root;
        }
        // If index= size, return last node
        if (index == this.size - 1) {
            return getLastNode(this.root);
        }
        int pointer = 0;
        DoublyNode<T> pointerNode = this.root;
        while (pointer <= index) {
            if (pointer == index) {
                return pointerNode;
            } else {
                pointerNode = next(pointerNode);
                pointer++;
            }
        }
        return null;
    }
    private DoublyNode<T> getLastNode(DoublyNode<T> node) {
        if(node !=null) {
            DoublyNode<T> lastNode = node;
            if (lastNode.getNext() != null) {
                return getLastNode(lastNode.getNext());
            } else {
                return lastNode;
            }
        }
        return null;
    }
    private DoublyNode<T> next(DoublyNode<T> node) {
        if (node.getNext() != null) {
            return node.getNext();
        } else {
            return null;
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((root == null) ? 0 : root.hashCode());
        result = prime * result + size;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof LinkedList))
            return false;
        LinkedList other = (LinkedList) obj;
        if (root == null) {
            if (other.root != null)
                return false;
        } else if (!root.equals(other.root))
            return false;
        if (size != other.size)
            return false;
        return true;
    }
    @Override
    public String toString() {
        String represent = "[";
        DoublyNode<T> nextNode = this.root;
        while (nextNode != null) {
            represent = represent + nextNode.toString();
            nextNode = next(nextNode);
            if (nextNode != null) {
                represent = represent + ",";
            }
        }
        represent = represent + "]";
        return represent;
    }
}

