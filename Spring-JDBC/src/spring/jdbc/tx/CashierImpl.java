package spring.jdbc.tx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier{

	@Resource
	private BookShopService bookShopService;
	
	
	/**
	 * @Transactional 注解的属性
	 * 
	 * 1.传播行为:
	 * 
	 * 1.1.propagation=Propagation.REQUIRED(默认)
	 * 就是利用现有的事务，不用新开事务，当出错的时候，全部回滚 
	 * 1.2.propagation=Propagation.REQUIRED_NEW
	 * 自己新开一个事务，假如自己本身没有出错，但是整个包裹在外面的事务出错了
	 * 则自己本身的事务会被提交，外面的事务则会被回滚
	 * 
	 * 2.隔离级别:
	 * isolation=Isolation.READ_COMMITTED（最常用）
	 * 
	 * 3.回滚设置：
	 * rollbackFor  默认情况下对 所有异常进行回滚
	 * 
	 * 4.只读属性
	 * readOnly 默认 false 在只进行读操作的时候才能为 true
	 * 
	 * 5.超时属性：
	 * timeout= 1   单位为 Seconds
	 * 若超出时间则强制回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public void checkout(String username, List<String> ISBNs) {
		
		for(int i=0; i<ISBNs.size(); i++) {
			bookShopService.purchase(username, ISBNs.get(i));
		}
		
	}

}
