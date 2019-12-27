package com.group.javaee;

import com.group.javaee.Mapper.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaeeApplicationTests {
    @Autowired(required = false)
    TeacherMapper teacherMapper;
    @Test
    void contextLoads() {
        System.out.println(teacherMapper.selectClassId(20190001));
    }

}
