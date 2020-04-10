package con.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author harry
 * @create 2020-04-09 17:04
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args){

        SpringApplication.run(PaymentMain8006.class, args);
    }
}
