package spring.jdbc.tx;

public interface BookShopDao {

	//根据书号获取单价
	public int findBookPriceByISBN(String ISBN);
	
	//更新书的库存,使书号对应的库存 -1
	public void updateBookStock(String ISBN);
	
	//更新用户的账户余额: 使用户的 balance - price
	public void updateUserAccount(String username, int price);
	
}
