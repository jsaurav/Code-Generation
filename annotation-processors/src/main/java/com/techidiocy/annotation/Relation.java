/**
 * 
 */
package com.techidiocy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author saurabhj
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Relation {

	 Class<?> associatedSourceClass();
}
