package ch.bfh.btx8081.w2017.green.Spero.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Utils class for Resources.
 *
 * @author guillaume.fricker
 */
public abstract class ResourceUtils {

    public static InputStream getResource(final String path) {
	final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream inputStream = classLoader.getResourceAsStream("/" + path);
	if (inputStream == null) {
	    inputStream = classLoader.getResourceAsStream(path);
	}
	return inputStream;
    }

    public static InputStream getExternalFile(final String path) throws FileNotFoundException {
	final File file = new File(path);
	final FileInputStream fileInputStream = new FileInputStream(file);
	return fileInputStream;
    }

}
