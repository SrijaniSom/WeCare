package com.example.healthcarefinal.ui.country;
public class CovidCountry {


    String mCovidCountry,mcases,mTodayCases,mDeaths,mTodaysDeath,mRecovered,mCritical;

    public CovidCountry(String mCovidCountry, String mcases) {
        this.mCovidCountry = mCovidCountry;
        this.mcases = mcases;
        this.mTodayCases = mTodayCases;
        this.mDeaths = mDeaths;
        this.mTodaysDeath = mTodaysDeath;
        this.mRecovered = mRecovered;
        this.mCritical = mCritical;


    }
    public String getmCovidCountry(){
        return mCovidCountry;
    }

    public String  getmcases() {
        return mcases;
    }
}