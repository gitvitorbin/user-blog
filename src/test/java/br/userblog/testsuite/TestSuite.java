package br.userblog.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.userblog.tests.UserBlogBasicTest;
import br.userblog.tests.UserBlogFlowTest;

@RunWith(Suite.class)
@SuiteClasses({
	UserBlogBasicTest.class,
	UserBlogFlowTest.class
})

public class TestSuite {

}
