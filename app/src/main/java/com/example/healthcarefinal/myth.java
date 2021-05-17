package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healthcarefinal.R;
import com.example.healthcarefinal.mythj;

import java.util.ArrayList;

public class myth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myth);

    String[] urls={"https://www.lifeadvancer.com/drinking-water-after-eating/","https://ca.style.yahoo.com/heres-how-eating-chapati-everyday-is-good-for-your-health-061710839.html?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuYmluZy5jb20v&guce_referrer_sig=AQAAAHLyCRA0IOnNCVlT_JcfrHD917b9aKV4uh10W0I2XUv3B9wkAvIKnpFyoatD4DaK1QFi8-TRWUfRnvzF2fpghkdFdbwWmIumNrGFuWTpy6padDgfXErLwxtRn9FudrIvoN0eJO91MT43UBCrWw6kZSNisffSwxpnlcxZOytKGNLl","https://www.sclhealth.org/blog/2018/09/the-benefits-of-getting-a-full-night-sleep/","https://www.healthline.com/nutrition/animal-vs-plant-protein","https://www.cdc.gov/mentalhealth/learn/index.htm#:~:text=Mental%20health%20includes%20our%20emotional,others%2C%20and%20make%20healthy%20choices.&text=Mental%20health%20is%20important%20at,childhood%20and%20adolescence%20through%20adulthood","https://www.healthline.com/health/why-cant-i-gain-weight","https://www.healthline.com/health/skin/acne#causes","https://www.healthline.com/health/eye-health/eye-strain","https://www.webmd.com/balance/guide/tips-to-control-stress","https://www.webmd.com/balance/guide/tips-to-control-stress","https://www.aad.org/public/diseases/hair-loss/causes/18-causes","https://www.everydayhealth.com/hypertension/treating/if-your-reading-is-normal.aspx"};
        ArrayList<mythj> phr=new ArrayList<>();
        phr.add(new mythj("Drink water","Esplains why to drink water",R.drawable.water,"https://www.lifeadvancer.com/drinking-water-after-eating/"));
        phr.add(new mythj("Chapati's Importance","Why is chapati good for health?",R.drawable.chapati,"https://ca.style.yahoo.com/heres-how-eating-chapati-everyday-is-good-for-your-health-061710839.html?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuYmluZy5jb20v&guce_referrer_sig=AQAAAHLyCRA0IOnNCVlT_JcfrHD917b9aKV4uh10W0I2XUv3B9wkAvIKnpFyoatD4DaK1QFi8-TRWUfRnvzF2fpghkdFdbwWmIumNrGFuWTpy6padDgfXErLwxtRn9FudrIvoN0eJO91MT43UBCrWw6kZSNisffSwxpnlcxZOytKGNLl"));
        phr.add(new mythj("Sleeping Benefits","Why should we sleep?",R.drawable.sleep,"https://www.sclhealth.org/blog/2018/09/the-benefits-of-getting-a-full-night-sleep/"));
        phr.add(new mythj("Vegetable proteins vs Animal proteins","Explains difference between them", R.drawable.protein,"https://www.healthline.com/nutrition/animal-vs-plant-protein"));
        phr.add(new mythj("Importance of Mental Health","Why to be happy?",R.drawable.mental,"https://www.cdc.gov/mentalhealth/learn/index.htm#:~:text=Mental%20health%20includes%20our%20emotional,others%2C%20and%20make%20healthy%20choices.&text=Mental%20health%20is%20important%20at,childhood%20and%20adolescence%20through%20adulthood"));
        phr.add(new mythj("Reasons for not gaining weight","Bye Bye fat",R.drawable.wight,"https://www.healthline.com/health/why-cant-i-gain-weight"));
        phr.add(new mythj("Reasons behind pimples","Explains why do we have pimples",R.drawable.pimple,"https://www.healthline.com/health/skin/acne#causes"));
        phr.add(new mythj("Are your eyes strained?","Reasons and causes of eye strain",R.drawable.strain,"https://www.healthline.com/health/eye-health/eye-strain"));
        phr.add(new mythj("Stress Handle","10 way outs",R.drawable.stress,"https://www.webmd.com/balance/guide/tips-to-control-stress"));
        phr.add(new mythj("Hair Fall!!","Reasons of hair loss",R.drawable.hair,"https://www.aad.org/public/diseases/hair-loss/causes/18-causes"));
        phr.add(new mythj("Blood Pressure","Ways to maintain",R.drawable.maintain,"https://www.everydayhealth.com/hypertension/treating/if-your-reading-is-normal.aspx"));




        factAdapter adapter=new factAdapter(this,phr);
        ListView listView=(ListView)findViewById(R.id.phrases_ListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(myth.this, "You clicked"+phr.get(position), Toast.LENGTH_SHORT).show();
                Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                startActivity(openLinksIntent);

            }
        });
    }
}