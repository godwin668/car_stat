package test.po;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenum.car.dao.CityDao;
import com.chenum.car.po.CityPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml", "classpath:servlet.xml" })
public class CityTest {

	@Autowired
	private CityDao cityDao;

	@Test
	public void testSave() {

	}

	@Test
	public void testList() {
		List<CityPo> cityList = cityDao.list("");
		System.out.println("city list:");
		for (CityPo city : cityList) {
			System.out.println(city.getName());
		}
	}

}