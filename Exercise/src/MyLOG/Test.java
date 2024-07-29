package MyLOG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test {
    public static final Logger LOG = LoggerFactory.getLogger("TestLOG");
    public static void main(String[] args) {
        LOG.info("程序开始运行");
        int result = divedied(5,0);

    }
    public static int divedied(int a,int b) {
        int result  = 0;
        try {
            LOG.info("除法开始");
            LOG.debug("a = " + a);
            LOG.debug("b = " + b);
            result = a / b;
            LOG.info("程序运行成功结果为："+result);
        }catch(Exception e){
            LOG.error("程序运行出错");
        }
        return result;
    }

}
