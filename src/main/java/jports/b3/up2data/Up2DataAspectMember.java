package jports.b3.up2data;

import jports.ShowStopper;
import jports.adapters.Adapter;
import jports.adapters.AdapterFactory;
import jports.data.ColumnType;
import jports.data.DataAspectMember;
import jports.reflection.AspectMemberAccessor;

public class Up2DataAspectMember<T> extends DataAspectMember<T> {

	private final Adapter<?> adapter;

	public Up2DataAspectMember(Up2DataColumn column, AspectMemberAccessor<T> accessor) {
		super(accessor, ColumnType.REGULAR, column.name());
		this.adapter = AdapterFactory.createAdapter(accessor, column.adapter(), column.format());
	}

	@Override
	public void setValue(T target, Object value) {
		try {
			Object nvalue = adapter.convert(value);
			super.setValue(target, nvalue);
		} catch (Exception e) {
			throw new ShowStopper("Unable to set value of " +
					this.getName() +
					" to " +
					value +
					" (" +
					value.getClass() +
					") because: " +
					e.getMessage(), e);
		}
	}

}
