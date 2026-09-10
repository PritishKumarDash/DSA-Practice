class Solution {   
    int ans = 0;   
    int i = 0;   
    int val = 0;  
   
    public int averageOfSubtree(TreeNode root) {   
        if(root == null) return 0;   
          
        avg(root);  
   
        return ans;   
    }   
   
    void avg(TreeNode root) {   
        if(root == null) {  
            val = 0;  
            i = 0;  
            return;  
        }  
   
        avg(root.left);  
        int leftVal = val;  
        int leftI = i;  
   
        avg(root.right);  
        int rightVal = val;  
        int rightI = i;  
   
        val = root.val + leftVal + rightVal;  
        i = 1 + leftI + rightI;  
   
        int aver = val / i;   
   
        if(aver == root.val)   
            ans++;   
    }   
}