package com.countries.countries;


import java.util.concurrent.atomic.AtomicLong;

public class Country
{

	private static final AtomicLong counter = new AtomicLong();

	private long id;
	private String name;
	private long population;
	private long landMass;
	private int medianAge;

	// Default Constructor
	public Country()
	{

	}

	// Full constructor
	public Country(String name, long population, long landMass, int medianAge)
	{

		this.id = counter.incrementAndGet();
		this.name = name;
		this.population = population;
		this.landMass = landMass;
		this.medianAge = medianAge;

	}

	// Recreate copy of Country
	public Country(Country toClone)
	{
		this.id = toClone.getId();
		this.name = toClone.getName();
		this.population = toClone.getPopulation();
		this.landMass = toClone.getLandMass();
		this.medianAge = toClone.getMedianAge();
	}

	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getPopulation()
	{
		return population;
	}

	public void setPopulation(long population)
	{
		this.population = population;
	}

	public long getLandMass()
	{
		return landMass;
	}

	public void setLandMass(long landMass)
	{

		this.landMass = landMass;

	}

	public int getMedianAge()
	{
		return medianAge;
	}

	public void setMedianAge(int medianAge)
	{
		this.medianAge = medianAge;
	}

	@Override
	public String toString()
	{

		return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';

	}

}