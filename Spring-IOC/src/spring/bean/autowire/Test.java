package spring.bean.autowire;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

	@Autowired
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
