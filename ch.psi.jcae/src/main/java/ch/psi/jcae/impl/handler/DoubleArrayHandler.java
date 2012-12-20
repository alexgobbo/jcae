/**
 * Copyright (c) 2012 Paul Scherrer Institute. All rights reserved.
 */

package ch.psi.jcae.impl.handler;

import gov.aps.jca.CAException;
import gov.aps.jca.CAStatusException;
import gov.aps.jca.Channel;
import gov.aps.jca.dbr.DBR;
import gov.aps.jca.dbr.DBRType;
import gov.aps.jca.dbr.DBR_Double;
import gov.aps.jca.event.PutListener;

/**
 * @author ebner
 *
 */
public class DoubleArrayHandler implements Handler<double[]>{

	/* (non-Javadoc)
	 * @see ch.psi.jcae.impl.handler.Handler#setValue(gov.aps.jca.Channel, java.lang.Object, gov.aps.jca.event.PutListener)
	 */
	@Override
	public <E> void setValue(Channel channel, E value, PutListener listener) throws CAException {
		channel.put(((double[]) value), listener);
	}

	/* (non-Javadoc)
	 * @see ch.psi.jcae.impl.handler.Handler#getValue(gov.aps.jca.dbr.DBR)
	 */
	@Override
	public double[] getValue(DBR dbr) throws CAStatusException {
		return ((DBR_Double) dbr.convert(DBR_Double.TYPE)).getDoubleValue();
	}

	/* (non-Javadoc)
	 * @see ch.psi.jcae.impl.handler.Handler#getDBRType()
	 */
	@Override
	public DBRType getDBRType() {
		return DBR_Double.TYPE;
	}

}