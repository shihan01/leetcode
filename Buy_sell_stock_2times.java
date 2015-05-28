/*
 * 'Cause we can complete 2 transactions, we scan from the front to get the max selling profit and scan from the back to get max buy profits
 * Basically from the front, we're trying to find the current lowest price, then we can calculate the max profit at each price
 * From the back, we are trying to find the current highest price, then calculate the max profit at each price
 * The reason we find best buying in front and find the best selling price in back is that when they meet, we can sell and buy at same time;
 * As for the front, we buy it, So what we are trying to do is to find the selling price(highest)
 * As for the back, we sell it, so what we are trying to do is to find the buying price(lowest)
 * Since we don't know the meeting point(it could be any point), then our loop appears!!
 */
public class Buy_sell_stock_2times {
	public static int get_profit(int[] prices)
	{
		int min_price = prices[0];
		int max_price = prices[prices.length-1];
		int max_left_profit =0;
		int max_right_profit =0;
		int j = prices.length-1;//index for the back part
		int[] left_profit = new int[prices.length];
		int[] right_profit = new int[prices.length];
		
		for(int i =0; i<prices.length; i++)//After they meet, i would > j
		{
		    //As for the front, trying to find the min price, we only know selling price
			min_price = Math.min(min_price, prices[i]);
			int temp_left_profit = prices[i] - min_price;//We are selling it;
			max_left_profit = Math.max(max_left_profit, temp_left_profit);                //As those 2 parts meet, Come On!!! sell and buy!!!
			left_profit[i] = max_left_profit;
			
			//As for the back,trying to find the max price, we only know buying price
			max_price = Math.max(max_price, prices[j]);
			int temp_right_profit = max_price -prices[j];
			max_right_profit = Math.max(max_right_profit,temp_right_profit);
			right_profit[j] = max_right_profit;
			j=j-1;
		}
		int max_profit =0;
		for(int i =0; i<left_profit.length; i++ ){
			max_profit = Math.max(max_profit, left_profit[i]+right_profit[i]);
		}
		return max_profit;
		//OK, let's test it
	}
	public static void main (String[] args)
	{
		int [] tester = {1,2,3,4,10,6,7,8,9,10};//Should return 13
		int res = get_profit(tester);
		System.out.print(res);
		
	}
	

}
