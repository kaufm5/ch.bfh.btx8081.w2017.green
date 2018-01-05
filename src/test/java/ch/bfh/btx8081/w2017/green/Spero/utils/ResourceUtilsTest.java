package ch.bfh.btx8081.w2017.green.Spero.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;

import org.junit.Test;

public class ResourceUtilsTest {
	private static final String FILE_PATH = "setting.properties";
	private static final String RESOURCE_PATH = "testresource.properties";

	@Test
	public void testGetResource() {
		assertNotNull(ResourceUtils.getResource(ResourceUtilsTest.RESOURCE_PATH));
	}

	@Test
	public void testGetNonExistingResource() {
		assertNull(ResourceUtils.getResource("doesnotexist.txt"));
	}

	@Test
	public void testGetExternalFile() throws FileNotFoundException {
		assertNotNull(ResourceUtils.getExternalFile(ResourceUtilsTest.FILE_PATH));
	}

	@Test(expected = FileNotFoundException.class)
	public void testGetNonExistingExternalFile() throws FileNotFoundException {
		ResourceUtils.getExternalFile("doesnotexist.txt");
	}

}
