package com.mavenproj;

public class CurrenciesblockforCountries
{
   private String symbol;

    private String code;

    private String name;
    public CurrenciesblockforCountries(String symbol, String code, String name) {
		super();
		this.symbol = symbol;
		this.code = code;
		this.name = name;
	}
    public CurrenciesblockforCountries() {}

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

   
}
			
		
