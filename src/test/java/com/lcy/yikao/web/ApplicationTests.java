package com.lcy.yikao.web;

import com.lcy.yikao.web.Util.m5Password;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {

		System.out.println(m5Password.encrypt("admin","bc97b52aff"));
	}

}
