package com.heybai.ex.springdata.hello

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.unitils.reflectionassert.ReflectionComparatorFactory
import org.unitils.reflectionassert.ReflectionComparatorMode
import org.unitils.reflectionassert.difference.Difference
import org.unitils.reflectionassert.report.impl.DefaultDifferenceReport

/**
 * Created by heybai on 6/10/14.
 */
public class ReflectionMatcher<T> extends BaseMatcher<T> {

    T expectedValue;
    ReflectionComparatorMode[] modes = [];
    Difference difference;


    public ReflectionMatcher(T expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public boolean matches(Object actualValue) {
        boolean result = false;
        //todo: @unitils341 issue: unordered lists with duplicated items
        try {
            difference = ReflectionComparatorFactory
                    .createRefectionComparator(modes)
                    .getDifference(expectedValue, actualValue);

            result = null == difference;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void describeTo(Description description) {
        //todo: @unitils341
        if (null != difference) {
            description.appendText("\n Unitils output start {\n"
                    + new DefaultDifferenceReport().createReport(difference)
                    + "\n} Unitils output end");
        } else {
            description.appendText(expectedValue.toString() + " // Unitils Issue, detailed difference was omitted");
        }
    }

    @org.hamcrest.Factory
    public static <T> ReflectionMatcher<T> reflects(T value) {
        return new ReflectionMatcher<>(value);
    }

    public Matcher<T> withMode(ReflectionComparatorMode... modes) {
        this.modes = modes;
        return this;
    }

}
