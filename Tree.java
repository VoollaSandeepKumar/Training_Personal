import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tree implements Cloneable {
	
	Tree left;
	Tree right;
	int data;
	public static int count = 0;
	public static int min = 0;
	public static boolean visit1 = false, visit2 = false;
	Tree(int data)
	{
		this.data = data;
		this.right = null;
		this.left = null;
	}
	public static int max_depth(Tree root)
	{
		if(root == null)
			return 0;
		return max(max_depth(root.left)+1,max_depth(root.right)+1);
	}
	
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i<=j)
			return j;
		else
			return i;
	}
	public static int count(Tree root)
	{
		if(root != null)
			count++;
		else
			return 0;
		
		count(root.left);
		count(root.right);
		return count;
	}
	public static int findMin(Tree root)
	{
		if(root != null)
		{
			if(min>root.data)
				min = root.data;
		}
		else
		{
			return 0;
		}
		
		findMin(root.left);
		findMin(root.right);
		return min;
	}
	public static void print_zigZag(Tree root)
	{
		Stack<Tree> stack = new Stack<Tree>();
		boolean directionFlag = false;
		if(root != null)
		{
			stack.push(root);
		}
		while(!stack.isEmpty())
		{
			Stack<Tree> tempStack = new Stack<Tree>(); 
			while(!stack.isEmpty())
			{
				Tree temp = stack.peek();
				System.out.print(temp.data+" ");
				stack.pop();
				if(!directionFlag)
				{
					if(temp.left != null)
						tempStack.push(temp.left);
					if(temp.right != null)
						tempStack.push(temp.right);
				}
				else
				{
					if(temp.right != null)
						tempStack.push(temp.right);
					if(temp.left != null)
						tempStack.push(temp.left);
				}
			}
			
			directionFlag = !directionFlag;
			stack = tempStack;
			System.out.println();
		}
	}
	
	public static void print_levelOrder(Tree root)
	{

		Queue<Tree> stack = new LinkedList<Tree>();
		if(root != null)
		{
			stack.add(root);
		}
		while(!stack.isEmpty())
		{
			Tree temp = stack.peek();
				System.out.print(temp.data+" ");
				stack.remove();
				if(temp.left != null)
						stack.add(temp.left);
					if(temp.right != null)
						stack.add(temp.right);

			
			//directionFlag = !directionFlag;
					}
	
		
	}
	
	public static boolean lookUp(Tree root, int target)
	{
		if(root == null)
		{
			return false;
		}
		if(target == root.data)
		{
			return true;
		}
		
		if(target<=root.data)
			return lookUp(root.left, target);
		else
			return lookUp(root.right,target);
		
	}
	
	public static void swap(char[] arr,int start,int end)
	{
		while(start < end)
		{
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public static void printTree(Tree root)
	{
		if(root == null)
		{
			return;
		}
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
	}
	public static void printPostTree(Tree root)
	{
		if(root == null)
		{
			return;
		}
		printPostTree(root.left);
		printPostTree(root.right);
		System.out.print(root.data+" ");
	}
	public static void printPreTree(Tree root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data+" ");
		printPreTree(root.left);
		printPreTree(root.right);
	}
	public static void stringReverse1(String str) {
		
		int localIndex=0;
		String result = "";
		while(str.indexOf(" ") != -1)
		{
			result = str.substring(localIndex, str.indexOf(" "))+" "+result;
			localIndex = str.indexOf(" ");
			str = str.replaceFirst(" ", "/");
		}
		result = str.substring(localIndex, str.length())+" "+result;
		result = result.replace("/", "");
		System.out.println(result);
	}

	public static void stringReverse(String str) {
		  
		int begin = 0;
		int temp = 0;
		int start = 0;
		
		char[] arr = str.toCharArray();
		while(temp !=  str.length()-1)
		{
			temp++;
			if(temp == str.length()-1)
				swap(arr,begin,temp);
			else if(arr[temp] == ' ')
			{
				swap(arr,begin,temp-1);
				begin = temp+1;
			}	
		}
		swap(arr,start,temp);
		System.out.println(String.valueOf(arr));
		  //return String.valueOf(arr);
	}
	public static void hasPath(Tree node, int [] a, int pathLen)
	{
		if(node == null)
		{
			return;
		}
		else
		{
			a[pathLen] = node.data;
			pathLen++;
		}
		if(node.left == null && node.right == null)
		{
			printArray(a,pathLen);
		}
		hasPath(node.left, a,pathLen);
		hasPath(node.right, a,pathLen);
		
	}
	public static int countWays(int numKeys)
	{
		if(numKeys <= 1)
			return 1;
		int sum =0;
		int left, right,root;
		for(root =1;root<=numKeys;root++)
		{
			left = countWays(root -1);
			right = countWays(numKeys-root);
			sum += right*left;
		}
		return sum;
	}
	private static void printArray(int[] a, int pathLen) {
		// TODO Auto-generated method stub
		for(int i=0;i<pathLen;i++)
		System.out.print(a[i]+" ");
		System.out.println();
	}
	public static Tree insert(Tree rootNode,int target)
	{
	  	if(rootNode == null)
	  	{
	  		return new Tree(target);
	  	}
	  	
	  	if(target <= rootNode.data )
	  	{
	  		rootNode.left = insert(rootNode.left, target);
	  	}
	  	else
	  	{
	  		rootNode.right = insert(rootNode.right, target);
	  	}
	  	
	  	return rootNode;
	}
	public static boolean hasSum(Tree root,int sum)
	{
		if(root == null)
		{
			return (sum == 0);
		}
		sum -= root.data;
		
		return (hasSum(root.left,sum) ||hasSum(root.right,sum));
	}
	public static void mirror(Tree root)
	{
		if(root == null)
		{
			return;
		}
		Tree node = root.left;
		root.left = root.right;
		root.right =node;
		mirror(root.left);
		mirror(root.right);
	}
	public static void doubleTree(Tree root)
	{
		if(root == null)
		{
			return;
		}
		doubleTree(root.left);
		Tree dup = new Tree(root.data);
		dup.left = root.left;
		root.left= dup;
		doubleTree(root.right);
	}
	
	public static void main(String[] args) {
		Tree root =new Tree(40); 
		//Tree root = root;
		Tree node20=new Tree(20);  
		Tree node10=new Tree(10);  
		  Tree node30=new Tree(30);  
		  Tree node60=new Tree(60);  
		  Tree node50=new Tree(50);  
		  Tree node70=new Tree(70);  
		  Tree node5=new Tree(5);  
		  Tree node55=new Tree(55);  
		    
		  root.left=node20;  
		  root.right=node60;  
		    
		  node20.left=node10;  
		  node20.right=node30;  
		    
		  node60.left=node50;  
		  node60.right=node70;  
		  node10.left=node5;  
		  node50.right=node55;  
		   Tree.print_zigZag(root);
		   System.out.println("level order");
		   Tree.print_levelOrder(root);
		   boolean found = lookUp(root, 5);
		   System.out.println("\n"+found);
		   System.out.println(max_depth(root));
		   System.out.println(count(root));
		   count = 0;
		  // insert(root,100);
		  // insert(root,110);
		   System.out.println(max_depth(root));
		   found= lookUp(root, 1001);
		   System.out.println("\n"+found);
		   System.out.println(count(root));
		   min = root.data;
		   if(root!=null)
		   {
		   if(root.left!= null)
		   min = findMin(root.left);
		   else
			   min = root.data;
		   }
		   System.out.println(min);
		   stringReverse1("I am software engineer");
		   printTree(root);
		   System.out.println();
		   printPostTree(root);
		   System.out.println();
		   printPreTree(root);
		   int []a = new int [1000];
		   System.out.println();
		   hasPath(root,a,0);
		   System.out.println(hasSum(root, 76));
		   System.out.println();
		   Tree root1 = null;;
		   try {
			root1 = (Tree) root.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //doubleTree(root);
		   printTree(root);
		   System.out.println();
		   System.out.println(sameTree(root,root1));
		   System.out.println();
		   System.out.println(countWays(5));
		   System.out.println();
		   System.out.println(isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE));
		   System.out.println();
		   System.out.println(isBST(root1,Integer.MAX_VALUE,Integer.MIN_VALUE));
		   System.out.println();
		   System.out.println(findLCA(root1, 55, 70).data);
		   visit1 = false;
		   visit2 = false;
		   Tree node = findLCA(root1, 5, 100);
		   if(null != node)
		   System.out.println(node.data);
		   else
			   System.out.println("did not find you");
		   

		   //System.out.println(output);
	}
	public static Tree findLCA(Tree root,int n1, int n2)
	{
		Tree lca = findLCAUntill(root,n1,n2);
		
		if(visit1&&visit2|| visit2 && find(lca,n1) || visit1 && find(lca,n2))
		{
			return lca;
		}
		return null;
	}
	private static boolean find(Tree lca, int n1) {
		if(lca == null)
		return false;
		
		if(lca.data == n1 || find(lca.left, n1) || find(lca.right, n1))
		{
			return true;
		}
		return false;
	}
	private static Tree findLCAUntill(Tree root, int n1, int n2) {
		// TODO Auto-generated method stub
		if(root == null)
		{
			return null;
		}
		if(root.data ==n1)
		{
			visit1 = true;
			return root;
		}
		if(root.data == n2)
		{
			visit2 = true;
			return root;
		}
		Tree llca =  findLCAUntill(root.left, n1, n2);
		Tree rlca =  findLCAUntill(root.right, n1, n2);
		
		if(llca!=null && rlca != null )
		{
			return root;
		}
		return (llca!=null) ? llca:rlca;
	}
	private static boolean sameTree(Tree root, Tree root1) {
		// TODO Auto-generated method stub
		if(root == null && root1 == null)
		{
			return true;
		}
		if(root.data != root1.data)
		{
			return false;
		}
		return(sameTree(root.left, root1.left) && sameTree(root.right, root1.right));
	}
	private static boolean isBST(Tree root, int max, int minValue)
	{
		if(root == null)
		{
			return true;
		}
		if(root.data>max||root.data<minValue)
		{
			return false;
		}
		return (isBST(root.left,root.data-1,minValue)&&isBST(root.right,max,root.data+1));
	}

}
