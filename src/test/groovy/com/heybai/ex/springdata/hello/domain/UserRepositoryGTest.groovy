package com.heybai.ex.springdata.hello.domain

import com.heybai.ex.springdata.hello.AbstractGTest
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by heybai on 6/10/14.
 */
class UserRepositoryGTest extends AbstractGTest {

    @Autowired private UserRepository userRepository;

    def "save one user"() {
        given:
        User saved = userRepository.save(new User('Pol'))

        expect:
        saved.id != null
        saved.name == 'Pol'
    }

}
