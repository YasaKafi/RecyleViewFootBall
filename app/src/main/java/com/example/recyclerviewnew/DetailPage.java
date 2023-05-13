package com.example.recyclerviewnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPage extends AppCompatActivity {

    Intent intent;
    EPLTeamModel eplTeamModel;

    TextView tvTeamName, tvLeague, tvFormedYear, tvStadium, tvStadiumLoc, tvDescription;

    ImageView ivStadium, ivJersey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

//        String url = "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League";
//
//        Glide.with(this)
//                .load(url)
//                .into(ivStadium);

        intent = getIntent();
        tvTeamName = findViewById(R.id.tvname);
        tvLeague = findViewById(R.id.tvLeagueData);
        tvStadium = findViewById(R.id.tvStadiumNameData);
        tvFormedYear = findViewById(R.id.tvFormedYearData);
        tvDescription = findViewById(R.id.tvDescriptionData);
        tvStadiumLoc = findViewById(R.id.tvStadiumLocData);
        ivStadium = findViewById(R.id.ivStadium);
        ivJersey = findViewById(R.id.ivJersey);

        eplTeamModel = intent.getParcelableExtra("myteam");

        System.out.println("nama team " + eplTeamModel.getJudul());
        System.out.println("nama team " + eplTeamModel.getLeague());
        System.out.println("nama team " + eplTeamModel.getDescription());
        System.out.println("nama team " + eplTeamModel.getStadiumLoc());
        System.out.println("nama team " + eplTeamModel.getFormedYear());
        tvTeamName.setText(eplTeamModel.getJudul());
        tvLeague.setText(eplTeamModel.getLeague());
        tvFormedYear.setText(eplTeamModel.getFormedYear());
//        tvLeague.setText(eplTeamModel.getLeague());
        tvStadium.setText(eplTeamModel.getStadiumName());
        tvStadiumLoc.setText(eplTeamModel.getStadiumLoc());
//        tvFormedYear.setText(eplTeamModel.getFormedYear());
        tvDescription.setText(eplTeamModel.getDescription());

        Glide.with(this).load(eplTeamModel.getStadium()).into(ivStadium);
        Glide.with(this).load(eplTeamModel.getJersey()).into(ivJersey);


    }
}