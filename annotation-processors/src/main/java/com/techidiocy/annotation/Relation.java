/**
 * 
 */
package com.techidiocy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author saurabhj
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Relation {

	 Class<?> associatedSourceClass();
}
