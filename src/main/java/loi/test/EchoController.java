package loi.test;

import loi.tracked.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/echo")
public class EchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping
    public void echo() {
        echoService.echo();
    }

    @GetMapping("/1")
    public void echo1() {
        echoService.echo1();
    }
}
