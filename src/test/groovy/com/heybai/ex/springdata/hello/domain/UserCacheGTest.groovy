package com.heybai.ex.springdata.hello.domain

import com.heybai.ex.springdata.hello.AbstractGTest
import com.heybai.ex.springdata.hello.AbstractSeedGTest
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by heybai on 6/15/14.
 */
class UserCacheGTest extends AbstractGTest {

    @Autowired private UserRepository userRepository;

    def "one user"() {
        given:
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
