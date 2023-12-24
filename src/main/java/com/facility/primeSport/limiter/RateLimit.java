package com.facility.primeSport.limiter;

import java.lang.annotation.*;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RateLimit {
    /**
     * A group of rate limits to count together
     */
    String value();
    /**
     * What key to use
     */
    String key();
    /**
     * Simple rates are of the form X/Yu where X is a number of requests, Y is number of units and u is a unit from this list:
     s - second
     m - minute
     h - hour
     d - day
     (For example, you can read 5/s as “five per second.”)
     Defaults to 1/s
     */
    String rate() default "1/s";
}
