package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Milan.Stojiljkovic on 7/20/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyController {
    String urlPath();
}
