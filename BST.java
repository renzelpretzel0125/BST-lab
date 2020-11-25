/*
* Binary search tree data structure
* @author : 
*/


public class BST<T extends Comparable<T>>
{
    /*
    * The root of the BST
    */
    Node<T> root;

    /*
    * Node class for a BST
    */
    private class Node<T extends Comparable<T>>
    {
        T data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(T item)
        {
            data = item;
            instance = 1;
        }
    }

    public BST()
    {
        root = null;
    }

    /*
    * Find function that finds an item in the BST
    * @param item to be found
    * @return boolean if the item was found
    */
    public boolean find(T item)
    {
        return find(item, root);
    }

    /*
    * Function override of the find function
    * @param item to be found
    * @param node the current node you are at
    * @return boolean if the item was found
    */
    private boolean find(T item , Node<T> node)
    {
        //TODO FILL IN FUNCITON
        if(node == null){
            return false;
        }
        if(item.compareTo(node.data)==0){//if item is similar to node.data return true
            return true;
        }else if(item.compareTo(node.data)<0){//if item is less that node.data, will go through left node else right node
            return find(item,node.left);
        }else{
            return find(item,node.right);
        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    * Insert an item to the tree
    * @param item to insert
    */
    public void insert(T item)
    {
        root = insert(item, root);
    }

    /*
    * Helper function for insert
    * @param item to add
    * @param node you are at
    * @return node you traverse to
    */
    private Node<T> insert(T item, Node<T> node)
    {
        //TODO FILL IN FUNCITON
        if (node == null){
            return new Node(item);
        }
        if (item.compareTo(node.data) < 0){ //item is less than the node.data, insert item to the left node recursively,  else to the right recursively
            node.left = insert(item, node.left);
        }else{
            node.right = insert(item, node.right);
        }
        return node;

        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    * Function for deletion of a node
    * @param item to delete
    */
    public void delete(T item)
    {
        root = delete(item, root);
    }

    /*
    * Helper function for deletion of a node
    * @param item to delete
    * @param node you are at
    * @return node you traverse to
    */
    private Node<T> delete(T item, Node<T> node)
    {
        //TODO FILL IN FUNCITON
        if (node == null){

            return null;
        
        }
        if (node.data.compareTo(item) < 0){ // if node.data is less than item, delete the right node

            node.right = delete(item,node.right);
            return node;

        }else if(node.data.compareTo(item) > 0){// if node.data is greater than item delete left node

            node.left = delete(item,node.left);
            return node;

        }else{ 

            if(node.left == null){

                return node.right;

            }else if(node.right == null){

                return node.left;

            }else{

                if (node.right.left == null){

                    node.data = node.right.data;
                    node.right = node.right.right;

                }
                
                return node;
            }
        }  
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    * Function to find the range sum of the binary tree
    * @param L the left bound
    * @param R the right bound
    * @return The sum of the range in the binary tree
    */
    public int rangeSum(Node node, int L, int R)//l is lower, r upper
    {
        if(node == null){

            return 0;

        }
        else if( L <= (int)node.data && (int)node.data <= R){

            return rangeSum(node.left, L, R) + rangeSum(node.right, L, R) + (int)node.data;
        
        }
        else if(L > (int)node.data){
            
            return rangeSum(node.right, L, R);
        
        }else{
            
            return rangeSum(node.left, L, R);
        
        }
        
    }
    public int rangeSum(int L, int R){
        
        return rangeSum(this.root,L,R);
    

        //return sum;
        //while bst comparing given node with its range
            //from left to right 
            //at any given node take sum of children
            //keep until a child that has no other children
            // if a parent node not within range compare with ewhere it is in range
            //if number is greater than range left
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    * Function to print the Binary tree
    */
    public void print()
    {
        print(root);
    }

    /*
    * Helper Function to print the Binary tree
    * @param root the root of the tree
    */
    private void print(Node<T> root)
    {
        if (root != null) {
            print(root.left);
            System.out.println("We are at root: " + root.data);
            print(root.right);
        
        } 
        
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}