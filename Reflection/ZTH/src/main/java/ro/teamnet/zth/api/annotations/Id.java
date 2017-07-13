package ro.teamnet.zth.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Milan on 12-Jul-17.
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Id {
    String name() default "id";
}
