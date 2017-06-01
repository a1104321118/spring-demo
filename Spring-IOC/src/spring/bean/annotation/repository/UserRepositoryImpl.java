package spring.bean.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository(value="userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Override
	public void save() {
		System.out.println("UserRepositoryImpl 的  save  方法");
	}

}
