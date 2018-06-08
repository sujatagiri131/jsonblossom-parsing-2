package com.android.jsontraining2.jsonpack;

public class json {
    private String id;

    private String user_name;

    private String image;

    private String review;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUser_name ()
    {
        return user_name;
    }

    public void setUser_name (String user_name)
    {
        this.user_name = user_name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getReview ()
    {
        return review;
    }

    public void setReview (String review)
    {
        this.review = review;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", user_name = "+user_name+", image = "+image+", review = "+review+"]";
    }
}