package com.googlecode.jeneratedata.dates;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.googlecode.jeneratedata.core.Generator;

/**
 * Generates {@link Date} instances between two given dates.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 */
public class DateGenerator implements Generator<Date> {
	/**
	 * {@link Random} instance to generate values within the given period.
	 */
	private Random random;

	/**
	 * The start of the period (as returned by {@link Date#getTime()} that
	 * contains the generated data items.
	 */
	private Long startTime;

	/**
	 * The end of the period (as returned by {@link Date#getTime()} that
	 * contains the generated data items.
	 */
	private Long endTime;
	
	/**
	 * Constructor.
	 * 
	 * @param start The start of the period that contains the generated data
	 * items.
	 * @param end The start of the period that contains the generated data
	 * items.
	 */
	public DateGenerator(Date start, Date end) {
		super();
		this.startTime = start.getTime();
		this.endTime = end.getTime();
		random = new Random();
	}
	
	/**
	 * Constructor.
	 * 
	 * @param start The start of the period that contains the generated data
	 * items.
	 * @param end The start of the period that contains the generated data
	 * items.
	 */
	public DateGenerator(Calendar start, Calendar end) {
		this(start.getTime(), end.getTime());
	}

	/* (non-Javadoc)
	 * @see com.googlecode.jeneratedata.core.Generator#generate()
	 */
	@Override
	public Date generate() {
		return new Date(startTime + ((Double) ((endTime - startTime) * random.nextDouble())).longValue());
	}
}
