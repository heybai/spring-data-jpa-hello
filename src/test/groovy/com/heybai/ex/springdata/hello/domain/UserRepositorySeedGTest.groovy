package com.heybai.ex.springdata.hello.domain

import com.heybai.ex.springdata.hello.AbstractSeedGTest
import org.springframework.beans.factory.annotation.Autowired
import spock.unitils.UnitilsSupport
import org.hamcrest.Matchers.*;

import static org.springframework.test.util.ReflectionTestUtils.setField
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals
import static spock.util.matcher.HamcrestSupport.that
import static com.heybai.ex.springdata.hello.Matchers.reflects


/**
 * Created by heybai on 6/10/14.
 */
//@UnitilsSupport
class UserRepositorySeedGTest extends AbstractSeedGTest {

    @Autowired private UserRepository userRepository;

    def "load 2 users"() {
        User u1 = new User('Ivan');
        setField(u1, 'id', 3L);
        User u2 = new User('Drew');
        setField(u2, 'id', 2L)

        given:
        List<User> expected = Arrays.asList(u1, u2)
        List<User> users = userRepository.findAll()

//        expect:
//        assertReflectionEquals(expected, users)

        expect:
        that users, reflects(expected)
    }

}
