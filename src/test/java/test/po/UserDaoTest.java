package test.po;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.idocv.demo.dao.UserDao;
import com.idocv.demo.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml", "classpath:servlet.xml" })
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSave() {
		User user = userDao.get(1);
		System.out.println("user: " + user);
	}

}