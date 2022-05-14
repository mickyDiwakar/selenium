package restApiclass;

public class Sys {
	private String country;
public Sys() {
	
}
    public Sys(String country, String sunrise, String sunset, String id, String type, String message) {
		super();
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.id = id;
		this.type = type;
		this.message = message;
	}

	private String sunrise;

    private String sunset;

    private String id;

    private String type;

    private String message;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getSunrise ()
    {
        return sunrise;
    }

    public void setSunrise (String sunrise)
    {
        this.sunrise = sunrise;
    }

    public String getSunset ()
    {
        return sunset;
    }

    public void setSunset (String sunset)
    {
        this.sunset = sunset;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }
}
