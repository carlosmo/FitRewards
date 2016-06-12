package com.example.carlosmo.fitrewards;

/**
 * Created by carlosmo on 16-06-12.
 */
public class Reward {
    String company, description;
    String imgURL;
    int redemptionTarget;

    public Reward(String company, String description, String imgURL, int redemptionTarget) {
        this.company = company;
        this.description = description;
        this.imgURL = imgURL;
        this.redemptionTarget = redemptionTarget;
    }

    public String getCompany() { return company; }
    public String getDescription() { return description; }
    public String getImgURL() { return imgURL; }
    public String getRedemptionTarget() { return redemptionTarget + ""; }
}
