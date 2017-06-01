package spring.bean.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

	//实现自动注入其实现类 UserRepository
	@Autowired
	protected BaseRepository<T> repository;
	
	
	
	
	
}
