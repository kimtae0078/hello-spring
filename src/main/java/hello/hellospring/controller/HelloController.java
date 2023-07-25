package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 응답 바디 부분에 return 값을 직접 넣어서 보내겠다는 뜻.
    public String helloString(@RequestParam("name") String name) {

        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // ctrl + shift + enter를 하면 작성 도중에 전체 완성해줌.
        hello.setName(name);
        return hello; // {"name":"dante"} 의 형태(JSON)로 반환됨. 스프링에서는 객체를 반환할 때에는 JSON 형식으로 반환하도록 함.
    }


    static class  Hello {
        // private 제어자여서 setter 메소드로 접근함. (프로퍼티 방식이라고도 함.)
        private String name; // getter, setter 생성 단축기 => ALT + Insert

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
