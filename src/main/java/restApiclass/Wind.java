package restApiclass;

public class Wind {
	private String deg;
public Wind() {}
    public Wind(String deg, String speed) {
		super();
		this.deg = deg;
		this.speed = speed;
	}

	private String speed;

    public String getDeg ()
    {
        return deg;
    }

    public void setDeg (String deg)
    {
        this.deg = deg;
    }

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }
}
