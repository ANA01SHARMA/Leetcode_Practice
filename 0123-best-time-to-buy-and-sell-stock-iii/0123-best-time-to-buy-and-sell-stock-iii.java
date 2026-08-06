class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            // Maximum profit after first buy (or minimum cost to buy)
            firstBuy = Math.max(firstBuy, -price);
            
            // Maximum profit after first sell
            firstSell = Math.max(firstSell, firstBuy + price);
            
            // Maximum profit after second buy
            secondBuy = Math.max(secondBuy, firstSell - price);
            
            // Maximum profit after second sell
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        return secondSell;
    }
}