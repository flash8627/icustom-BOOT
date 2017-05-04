package com.start;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName: IndexController
 * Description:
 *
 * @author kang.wang03
 *         Date 2016/11/8
 */
@RestController
public class IndexController {
    private static final String path="path";
    @GetMapping("/index")
    public ResponseEntity index(HttpSession httpSession) {
        return ResponseEntity.ok("ok1adasds222");
    }

}
