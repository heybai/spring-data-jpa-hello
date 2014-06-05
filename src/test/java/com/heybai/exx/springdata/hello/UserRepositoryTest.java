package com.heybai.exx.springdata.hello;

import com.heybai.ex.springdata.hello.domain.User;
import com.heybai.ex.springdata.hello.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserRepositoryTest extends AbstractTest {

    @Autowired private UserRepository userRepository;

    @Test public void ttt() {
        System.out.println("users: " + userRepository.findAll());
        userRepository.save(new User("Pol"));
        System.out.println("users: " + userRepository.findAll());
    }

    @Test public void ttt2() {
        System.out.println("users: " + userRepository.findAll());
    }

}