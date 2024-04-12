public class ExceptionTest {
    public static void main(String[] args) {
        int value = 2;
        value = printAndIncrement(value);
        System.out.println("Value in main after try-catch: " + value);
    }

    public static int printAndIncrement(int i){
        try{
            System.out.println("Value in try block before increment and exception: " + i);
            i++;
            System.out.println("Value in try block after increment: " + i);
            throw new Exception("An exception occurred");
        } catch (Exception e) {
            System.out.println("Value in catch block before increment: " + i);
            i++;
            System.out.println("Value in catch block after increment: " + i);
            return i;
        } finally {
            System.out.println("Value in finally block before increment: " + i);
            i++;
            System.out.println("Value in finally block after increment: " + i);
        }
    }
}