package companyx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest(classes = XRestApiApplication.class)
class XRestApiApplicationSpec
{

	@Test
	void contextLoads()
	{
		assertTrue(true);
	}

}
