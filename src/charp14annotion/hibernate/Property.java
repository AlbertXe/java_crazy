package charp14annotion.hibernate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.SOURCE)
public @interface Property {
	String column();
	String type();
}
