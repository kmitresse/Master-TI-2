import java.lang.*;

class GetProps {
 
    public static void main(String[] args) {
 
        try {
            final String OS_NAME = GetProps.getProperty("os.name");
            final String JAVA_VERSION = GetProps.getProperty("java.version");
            final String USER_HOME = GetProps.getProperty("user.home");
            final String JAVA_HOME = GetProps.getProperty("java.home");

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