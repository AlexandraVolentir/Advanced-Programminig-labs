package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom Test annotation for the DemoClass
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
