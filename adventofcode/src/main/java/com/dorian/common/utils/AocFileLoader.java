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

  public static List<String> readFromResources(String resourceFile)
      throws IOException, URISyntaxException {
    URL url = classloader.getResource(resourceFile);
    if (url == null) {
      throw new IOException("Malformed url/resource name");
    }

    return Files.readAllLines(Paths.get(url.toURI()), Charset.defaultCharset());
  }

  private AocFileLoader() {
    throw new UnsupportedOperationException("Utility class cannot be instantiated");
  }
}
