package spring.jdbc.tx;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

	@Resource
	private BookShopDao bookShopDao;
	
	
	/**
	 * 添加事务注解
	 * propagation  事物的传播行为
	 */
	@Transactional
	@Override
	public void purchase(String username, String ISBN) {
		//1.更新库存
		bookShopDao.updateBookStock(ISBN);
		//2.更新用户余额
		bookShopDao.updateUserAccount(username, bookShopDao.findBookPriceByISBN(ISBN));
		
		
	}

}
