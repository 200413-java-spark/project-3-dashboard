package com.github.dashboard;

import org.springframework.test.context.junit4.SpringRunner;

public @interface RunWithTest {

	Class<SpringRunner> value();

}
