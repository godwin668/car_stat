package test.po;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.idocv.car.dao.CityDao;
import com.idocv.car.po.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml",
		"classpath:servlet.xml" })
public class CityTest {

	@Autowired
	private CityDao cityDao;

	@Test
	public void testSave() {
		City city = new City("201", "北京", "北京", "beijing");
		cityDao.save(city);
		System.out.println("done!");
	}

}