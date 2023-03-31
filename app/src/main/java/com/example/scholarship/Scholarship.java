package com.example.scholarship;

public class Scholarship {
    String domain,title,eligibility,amt,link;

    public Scholarship(String domain, String title, String eligibility, String amt, String link) {
        this.domain = domain;
        this.title = title;
        this.eligibility = eligibility;
        this.amt = amt;
        this.link = link;
    }

    public String getDomain() {
        return domain;
    }

    public String getTitle() {
        return title;
    }

    public String getEligibility() {
        return eligibility;
    }

    public String getAmt() {
        return amt;
    }

    public String getLink() {
        return link;
    }
}
