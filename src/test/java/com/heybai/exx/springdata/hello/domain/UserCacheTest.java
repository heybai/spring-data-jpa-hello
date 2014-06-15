package com.heybai.exx.springdata.hello.domain;

import com.heybai.ex.springdata.hello.domain.User;
import com.heybai.ex.springdata.hello.domain.UserRepository;
import com.heybai.exx.springdata.hello.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class UserCacheTest extends AbstractTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void ttt3() {
        User u0 = new User("Bob");
        User u1 = new User("Tim");

        u0 = userRepository.save(u0);
        System.out.println("--saved: " + u0);
        u1 = userRepository.save(u1);
        System.out.println("--saved: " + u1);

        User u2 = userRepository.findOne(u0.getId());
        System.out.println("--loaded: " + u2);
        u2 = userRepository.findOne(u1.getId());
        System.out.println("--loaded: " + u2);
        u2 = userRepository.findOne(u0.getId());
        System.out.println("--loaded again: " + u2);
        u2 = userRepository.findOne(u1.getId());
        System.out.println("--loaded again: " + u2);

        userRepository.delete(u0.getId());
        userRepository.delete(u1.getId());
        System.out.println("--deleted");

        User u3 = userRepository.findOne(u0.getId());
        System.out.println("--loaded after delition: " + u3);
        u3 = userRepository.findOne(u1.getId());
        System.out.println("--loaded after delition: " + u3);
        userRepository.findAll();
    }

}
