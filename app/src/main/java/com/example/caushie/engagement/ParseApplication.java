package com.example.caushie.engagement;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {



    @Override
    public void onCreate(){
        super.onCreate();


        // Register your parse models
        ParseObject.registerSubclass(Post.class);


        // set applicationId, and server server based on the values in the Heroku settings.
        // clientKey is not needed unless explicitly configured
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("myTeam") // should correspond to APP_ID env variable
                .clientKey("myTeamAj")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://teamaj.herokuapp.com/parse").build());

    }
}
