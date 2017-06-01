package spring.jdbc.tx;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByISBN(String ISBN) {
		String sql = "select price from book where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, ISBN);
	}

	@Override
	public void updateBookStock(String ISBN) {
		
		//检查书的库存 是否足够，若不够，抛出异常
		String sql1 = "select stock from book_stock where isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql1, Integer.class, ISBN);
		if(stock == 0) {
			throw new BookStockException("库存不足");
		}
		
		String sql = "update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql,ISBN);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		
		//验证余额是否不足
		String sql1 = "select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(sql1, Integer.class, username);
		if(balance < price) {
			throw new UserAccountException("用户余额不足");
		}
		
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}
