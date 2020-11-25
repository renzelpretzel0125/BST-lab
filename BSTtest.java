/*
* Main testing class for BST
* @author: USFCACS 245
*/
public class BSTtest
{
    public static void main(String[] args)
    {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        BST<Integer> tree = new BST<Integer>();

        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        for(int i=2; i < args.length; i++)
        {
            tree.insert(Integer.parseInt(args[i]));

        }

        //tree.delete(Integer.parseInt(args[3]));
        System.out.println(tree.find(Integer.parseInt(args[4])));
        tree.print();
        
        System.out.println("Sum of Range: " + tree.rangeSum(L, R));
    }
}
