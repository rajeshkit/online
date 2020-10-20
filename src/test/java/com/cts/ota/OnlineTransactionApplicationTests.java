package com.cts.ota;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.ota.controller.LoginController;
import com.cts.ota.controller.WithdrawController;

@SpringBootTest
class OnlineTransactionApplicationTests {

	@Autowired
	private LoginController loginController;

	@Autowired
	private WithdrawController withdrawController;

	@Test
	void contextLoads() throws Exception {
		assertThat(loginController).isNotNull();
		assertThat(withdrawController).isNotNull();
	}

}
