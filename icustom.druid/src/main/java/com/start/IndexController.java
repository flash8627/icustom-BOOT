package com.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: IndexController
 * Description:
 *
 * @author kang.wang03
 *         Date 2016/11/8
 */
@RestController
public class IndexController {
    @Autowired
    private JdbcTemplate jdbcTemplateDBCP2;


    @GetMapping("/index")
    public ResponseEntity jdbcTemplateDBCP2() {
        jdbcTemplateDBCP2.update("update tb_p set  a=1");
        return ResponseEntity.ok("ok");
    }


}
