package jports.b3.up2data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Up2DataTable {

	/**
	 * The name of the channel to find files
	 * 
	 * @return
	 */
	public String channel();

	/*
	 * The name of the sub Channel
	 */
	public String subChannel();

	/**
	 * The name prefix for files in the sub channel
	 * 
	 * @return
	 */
	public String prefix();

}
