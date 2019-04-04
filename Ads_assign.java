package ads_assign;
import java.util.ArrayList; 
import java.util.Scanner;

/**
 *
 * @author Nayan
 */
public class Ads_assign {

    int cnt[];
    int count=0;
    public static void main(String agrs[])
    {
        System.out.println("Finding Total No. of Subtree");
        //Adjacency maatrix for tree with no. of nodes 6
        
//                             (0)
//                            /   \     
//                          (1)   (3)
//                               /   \
//                             (2)   (4)
//                                    /
//                                  (5)
            int n=6;
            int adjmat[][]={{0,1,0,1,0,0},
                            {1,0,0,0,0,0},
                            {0,0,0,1,0,0},
                            {1,0,1,0,1,0},
                            {0,0,0,1,0,1},
                            {0,0,0,0,1,0}
            };

        
        int countnode[]=new int[n]; //for storing count of corresponding node
        int visited[]=new int[n];    
        int visited_node[]=new int[n];   
        Tree temp;
     

//FINDING THE ORDERED LIST        
        Tree t=new Tree(0);//giving the root of tree as 0
        ArrayList<Tree> arr=new ArrayList<>();
        ArrayList<Tree> ordered=new ArrayList<>();
        arr.add(t);
        for(int i=0;i<n;i++)
            visited[i]=-1;
        
        int count=0;
        
        //concept of bfs        
        while(!arr.isEmpty())
        {
            temp=arr.remove(0); //implementing Queue 
            ordered.add(temp);
            count=count+1;
            //System.out.println("values are: "+temp.data);
            for(int j=0;j<n;j++){
                if(adjmat[temp.data][j]==1 && adjmat[j][temp.data]==1 && visited[j]!=1 && visited_node[j]!=1){
                    arr.add(new Tree(j));
                }
            }
            visited[temp.data]=1;
        }
       
        
        System.out.println("ordered list: "+ordered+"\n");
 

//FOR CALCULATING NO. OF NODES
    for(int p=0;p<ordered.size();p++){
      
        Tree temproot=ordered.get(p);
                
        arr.add(temproot);
        //getting the root and calculating descendant node
        int root=temproot.data;
        System.out.println("Root is:- \n" +root);
                
        for(int i=0;i<n;i++)
            visited[i]=-1;
        
        count=0;
                
        
        while(!arr.isEmpty())
        {
            temp=arr.remove(0);
            count=count+1;
            System.out.println("Nodes are: "+temp.data);
            for(int j=0;j<n;j++){
                if(adjmat[temp.data][j]==1 && adjmat[j][temp.data]==1 && visited[j]!=1 && visited_node[j]!=1){
                    arr.add(new Tree(j));
                }
            }
            visited[temp.data]=1;
            
        }
        System.out.println("\ncount is: "+count);
        //storing count of each node
        countnode[root]=count;
        visited_node[root]=1; //marking that node as visited
        System.out.println("*****************");
    }
        
    
    //finding nodes with descendant nodes greater than four
    int total=0;
    for(int i=0;i<n;i++){
        if(countnode[i]>=4){
            System.out.println("Root of subtree with nodes>=4: "+i);
            total++;
        }
    }
    
    //TOTAL NO OF SUBTREE
    System.out.println("TOTAL SUBTREE ARE: "+total);    

    
    }        
}
    
    

class Tree
{
    int data;
    Tree left,right; //if want to maintain the actual nodes placement
    
    Tree(int v){
            this.data=v;
            this.right=null;
            this.left=null;
    }

    @Override
    public String toString() {
        return ""+data; 
    }

 }