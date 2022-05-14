package restApiclass;

public class Coord {
	public Coord() {}
	public Coord(String lon, String lat) {
		super();
		this.lon = lon;
		this.lat = lat;
	}

	private String lon;

	    private String lat;

	    public String getLon ()
	    {
	        return lon;
	    }

	    public void setLon (String lon)
	    {
	        this.lon = lon;
	    }

	    public String getLat ()
	    {
	        return lat;
	    }

	    public void setLat (String lat)
	    {
	        this.lat = lat;
	    }
}
