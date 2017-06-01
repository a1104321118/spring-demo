package spring.jdbc.tx;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用前先把 spring.jdbc.sql 中的数据库导入
 * @author dell
 *
 */
public class SpringTransactionTest {

	private ApplicationContext ctx;
	BookShopDao bookShopDao;
	BookShopService bookShopService;
	Cashier cashier;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
		bookShopService = (BookShopService) ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	
	/**
	 * 测试    @Transactional 的  Propagation(传播方式) 属性
	 * 默认为 requied ： 就是利用现有的事务，不用新开事务，当出错的时候，全部回滚 
	 */
	@Test
	public void testTransactionPropagation() {
		List<String> ISBNs = new ArrayList<>();
		ISBNs.add("1001");
		ISBNs.add("1002");
		cashier.checkout("HR", ISBNs);
	}

	/**
	 * 测试  BookShopServicePurchase()  验证事物 
	 * 其中 Purchase() 使用 @Transactional 声明
	 */
	@Test
	public void testBookShopServicePurchase() {
		bookShopService.purchase("HR", "1001");
	}
	
	
	/**
	 * 下面三个方法是测试BookShopDao 的三个方法的
	 */
	@Test
	public void testBookShopDaoUpdateUserAccount() {
//		bookShopDao.updateUserAccount("HR",1000);
		bookShopDao.updateUserAccount("HR",10);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1002");
	}
	
	@Test
	public void testBookShopDaoFindPriceByISBN() {
		System.out.println(bookShopDao.findBookPriceByISBN("1002"));
	}
}
