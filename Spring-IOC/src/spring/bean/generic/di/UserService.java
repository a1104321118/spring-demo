package spring.bean.generic.di;

import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User>{

	public void add() {
		System.out.println("add..");
		System.out.println(repository);
	}
}
