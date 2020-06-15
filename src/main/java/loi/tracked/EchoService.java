package loi.tracked;

import loi.test.LogTracked;
import org.springframework.stereotype.Service;

@Service
public class EchoService {

    @LogTracked
    public void echo() {
        System.out.println("Hello I am echo man!!!");
    }

    public void echo1() {
        System.out.println("Hello I am echo 1111 man!!!");
    }
}
