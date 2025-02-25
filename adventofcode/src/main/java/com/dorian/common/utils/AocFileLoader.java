package com.dorian.common.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** Misc file loading util. */
public class AocFileLoader {
  private static final ClassLoader classloader = Thread.currentThread().getContextClassLoader();

  public static List<String> readLinesFromResources(String resourceFilePath)
      throws IOException, URISyntaxException {
    URL url = getUrlFromResourceFilePath(resourceFilePath);
    return Files.readAllLines(Paths.get(url.toURI()), Charset.defaultCharset());
  }

  public static String readStringFromResources(String resourceFilePath)
      throws URISyntaxException, IOException {
    URL url = getUrlFromResourceFilePath(resourceFilePath);
    return Files.readString(Paths.get(url.toURI()), Charset.defaultCharset());
  }

  private static URL getUrlFromResourceFilePath(String resourceFilePath) throws IOException {
    URL url = classloader.getResource(resourceFilePath);
    if (url == null) {
      throw new IOException("Malformed url/resource name");
    }

    return url;
  }

  private AocFileLoader() {
    throw new UnsupportedOperationException("Utility class cannot be instantiated");
  }
}
