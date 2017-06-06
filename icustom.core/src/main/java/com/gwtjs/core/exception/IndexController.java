package com.gwtjs.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: IndexController Description:
 *
 */
@RestController
public class IndexController {
	private AtomicInteger atomicInteger = new AtomicInteger();

	@GetMapping("/index")
	public ResponseEntity<?> helloWord() {
		if (atomicInteger.incrementAndGet() % 2 == 0)
			throw new CustomException("error CustomException");
		else
			throw new IllegalArgumentException("error paramaters");

	}
}
