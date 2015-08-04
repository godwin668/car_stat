package test.po;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CityPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml",
		"classpath:servlet.xml" })
public class CityTest {

	@Autowired
	private CityDao cityDao;

	@Test
	public void testSave() {
		CityPo city = new CityPo("201", "北京", "北京", "beijing");
		cityDao.save(city);
		System.out.println("done!");
	}

}