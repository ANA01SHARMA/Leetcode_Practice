class Solution {
    public boolean checkDivisibility(int n) {
        
        int ans=solve(n);
        
        if(n%ans==0){
            return true;
        } else {
            return false;
        }
        
    }
    public int solve(int n){
        int sum=0;
        int product=1;
        while(n!=0){
            int rem=n%10;
            sum=sum+rem;
            product=product*rem;
            n=n/10;
        }
        return sum+product;
    }
}