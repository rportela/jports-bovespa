package jports.b3.up2data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jports.adapters.Adapter;
import jports.adapters.VoidAdapter;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Up2DataColumn {

	/**
	 * The name of the column as it appears on the CSV file;
	 * 
	 * @return
	 */
	public String name();

	/**
	 * A format pattern to be used on dates and/or decimal parsing;
	 * 
	 * @return
	 */
	public String format() default "";

	/**
	 * An adapter to use when parsing specific values;
	 * 
	 * @return
	 */
	public Class<? extends Adapter<?>> adapter() default VoidAdapter.class;

}
