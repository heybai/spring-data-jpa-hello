package com.heybai.ex.springdata.hello

/**
 * Created by heybai on 6/10/14.
 */
public class Matchers extends org.hamcrest.Matchers {
    public static <T> ReflectionMatcher<T> reflects(T expected) {
        return ReflectionMatcher.reflects(expected);
    }
}
