package JunitApplication;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringprintTest {
    @Test
    public void TestprintNumber(){
        Stringprint.printNumber("张三");

    }
    @BeforeClass
    public  void Before(){
        System.out.println("输出");
    }
}
