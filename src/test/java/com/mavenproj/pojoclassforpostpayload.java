package com.mavenproj;

public class pojoclassforpostpayload
{
    public pojoclassforpostpayload(String UserName, String Email, String FirstName, String LastName, String Password) {
		super();
		this.UserName = UserName;
		this.Email = Email;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Password = Password;
	}

	private String UserName;
	private String Email;

    private String FirstName;

    private String LastName;

    private String Password;
   
    public pojoclassforpostpayload() {}

    public String getUserName ()
    {
        return UserName;
    }

    public void setUserName (String UserName)
    {
        this.UserName = UserName;
    }

    public String getEmail ()
    {
        return Email;
    }

    public void setEmail (String Email)
    {
        this.Email = Email;
    }

    public String getFirstName ()
    {
        return FirstName;
    }

    public void setFirstName (String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getLastName ()
    {
        return LastName;
    }

    public void setLastName (String LastName)
    {
        this.LastName = LastName;
    }

    public String getPassword ()
    {
        return Password;
    }

    public void setPassword (String Password)
    {
        this.Password = Password;
    }

   
}
		
