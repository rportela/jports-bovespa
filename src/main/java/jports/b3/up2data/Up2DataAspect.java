package jports.b3.up2data;

import jports.data.DataAspect;
import jports.reflection.AspectMemberAccessor;

/**
 * This class is a wrapper of annotated UP2DATA objects; It can easily parse
 * files into these types of objects;
 * 
 * @author rportela
 *
 * @param <T>
 */
public class Up2DataAspect<T> extends DataAspect<T, Up2DataAspectMember<T>> {

	private Up2DataTable table;

	public Up2DataAspect(Class<T> dataType) {
		super(dataType);
	}

	@Override
	protected void intializeDataType(Class<T> dataType) {
		this.table = dataType.getAnnotation(Up2DataTable.class);
		if (table == null) {
			throw new RuntimeException("Please annotate " + dataType + " with @Up2DataTable;");
		}
	}

	public String getChannel() {
		return this.table.channel();
	}

	public String getSubChannel() {
		return this.table.subChannel();
	}

	public String getFilePrefix() {
		return this.table.prefix();
	}

	@Override
	protected Up2DataAspectMember<T> visit(AspectMemberAccessor<T> accessor) {
		Up2DataColumn column = accessor.getAnnotation(Up2DataColumn.class);
		return column == null
				? null
				: new Up2DataAspectMember<>(column, accessor);
	}

}
