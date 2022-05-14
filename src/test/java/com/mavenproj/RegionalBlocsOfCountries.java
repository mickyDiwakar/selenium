package com.mavenproj;

public class RegionalBlocsOfCountries
{
    private String[] otherNames;
 
	private String acronym;

    private String name;

    private String[] otherAcronyms;
    
    public RegionalBlocsOfCountries(String[] otherNames, String acronym, String name, String[] otherAcronyms) {
  		super();
  		this.otherNames = otherNames;
  		this.acronym = acronym;
  		this.name = name;
  		this.otherAcronyms = otherAcronyms;
  	}
    public RegionalBlocsOfCountries() {}

    public String[] getOtherNames ()
    {
        return otherNames;
    }

    public void setOtherNames (String[] otherNames)
    {
        this.otherNames = otherNames;
    }

    public String getAcronym ()
    {
        return acronym;
    }

    public void setAcronym (String acronym)
    {
        this.acronym = acronym;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getOtherAcronyms ()
    {
        return otherAcronyms;
    }

    public void setOtherAcronyms (String[] otherAcronyms)
    {
        this.otherAcronyms = otherAcronyms;
    }

   
}
			
			