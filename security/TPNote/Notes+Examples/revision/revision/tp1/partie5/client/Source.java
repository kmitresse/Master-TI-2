import java.lang.*;

public class Source {
  public static void main(String[] args) {
 
    try {
        final String OS_NAME = Source.getProperty("os.name");
        final String JAVA_VERSION = Source.getProperty("java.version");
        final String USER_HOME = Source.getProperty("user.home");
        final String JAVA_HOME = Source.getProperty("java.home");

        System.out.println(
            "os.name : " + OS_NAME + "\n"
            + "java.version : " + JAVA_VERSION + "\n"
            + "user.home : " + USER_HOME + "\n"
            + "java.home : " + JAVA_HOME
        );
    } catch (Exception e) {
        System.err.println("Caught exception " + e.toString());
    }
}

  private static String getProperty(String property_name) {
      final String DEFAULT_VALUE = "not specified";
      return System.getProperty(property_name, DEFAULT_VALUE);
  }
}