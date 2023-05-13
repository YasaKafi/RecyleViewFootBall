package com.example.recyclerviewnew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ContactAdapterListener{

    RecyclerView rvContact;

    ArrayList<EPLTeamModel> listDataEPLTeam;

    private ContactAdapter adapterListKontak;

    public void getEPLOnlien(){
        ProgressBar progressBar = findViewById(R.id.tvproges);
        String url = "https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League";
        AndroidNetworking.get(url)
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                            }
                        });
                        try {
                            JSONArray jsonArrayEPLTeam = jsonObject.getJSONArray("teams");
                            for (int i = 0; i < jsonArrayEPLTeam.length(); i++) {
                                EPLTeamModel myTeam = new EPLTeamModel();
                                JSONObject jsonTeam = jsonArrayEPLTeam.getJSONObject(i);
                                myTeam.setJudul(jsonTeam.getString("strTeam"));
                                myTeam.setDescription(jsonTeam.getString("strDescriptionEN"));
                                myTeam.setStadiumName(jsonTeam.getString("strStadium"));
                                myTeam.setLeague(jsonTeam.getString("strLeague"));
                                myTeam.setBadges(jsonTeam.getString("strTeamBadge"));
                                myTeam.setFormedYear(jsonTeam.getString("intFormedYear"));
                                myTeam.setStadiumLoc(jsonTeam.getString("strStadiumLocation"));
                                myTeam.setStadium(jsonTeam.getString("strStadiumThumb"));

                                listDataEPLTeam.add(myTeam);
                            }
                            rvContact =  (RecyclerView) findViewById(R.id.rvkontakname);
                            adapterListKontak = new ContactAdapter(getApplicationContext(), listDataEPLTeam, MainActivity.this);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            rvContact.setHasFixedSize(true);
                            rvContact.setLayoutManager(mLayoutManager);
                            rvContact.setAdapter(adapterListKontak);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("error", "onError: " + anError.toString());
                    }
                });
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listDataEPLTeam = new ArrayList<>();
        setContentView(R.layout.activity_main);

        getEPLOnlien();





//        EPLTeamModel movieOne = new EPLTeamModel();
//        movieOne.setJudul("The Sea Beast");
//        movieOne.setGenre("Genre : Adventure,Comedy");
//        movieOne.setYear("Year : 2022");
//        movieOne.setStudio("Studio : Netflix Animation");
//        movieOne.setDuration("Duration : 119 minutes");
//        movieOne.setDirector("Director : Chris Williams");
//        movieOne.setImage(R.drawable.poster1);
//        listDataKontak.add(movieOne);
//
//        EPLTeamModel movieTwo = new EPLTeamModel();
//        movieTwo.setJudul("Minions The Rise of Gru");
//        movieTwo.setGenre("Genre : Adventure,Comedy");
//        movieTwo.setYear("Year : 2022");
//        movieTwo.setStudio("Studio : Illumination");
//        movieTwo.setDuration("Duration : 87 minutes");
//        movieTwo.setDirector("Director : Kyle Balda");
//        movieTwo.setImage(R.drawable.poster2);
//        listDataKontak.add(movieTwo);
//
//
//        EPLTeamModel movieThree = new EPLTeamModel();
//        movieThree.setJudul("Ivanna");
//        movieThree.setGenre("Genre : Thriller,Slasher");
//        movieThree.setYear("Year : 2022");
//        movieThree.setStudio("Studio : MD Pictures");
//        movieThree.setDuration("Duration : 103 minutes");
//        movieThree.setDirector("Director : Kimo Stamboel");
//        movieThree.setImage(R.drawable.poster3);
//        listDataKontak.add(movieThree);
//
//        EPLTeamModel movieFour = new EPLTeamModel();
//        movieFour.setJudul("Plane");
//        movieFour.setGenre("Genre : Action,Thriller");
//        movieFour.setYear("Year : 2023");
//        movieFour.setStudio("Studio : MadRiver Pictures");
//        movieFour.setDuration("Duration : 107 minutes");
//        movieFour.setDirector("Director : Jean-François Richet");
//        movieFour.setImage(R.drawable.poster4);
//        listDataKontak.add(movieFour);
//
//        EPLTeamModel movieFive = new EPLTeamModel();
//        movieFive.setJudul("Transformers: Rise of the Beasts");
//        movieFive.setGenre("Genre : Action,Sci-fi");
//        movieFive.setYear("Year : 2023");
//        movieFive.setStudio("Studio : Paramount Pictures");
//        movieFive.setDuration("Duration : not yet released");
//        movieFive.setDirector("Director : Steven Caple Jr");
//        movieFive.setImage(R.drawable.poster5);
//        listDataKontak.add(movieFive);
//
//        EPLTeamModel movieSix = new EPLTeamModel();
//        movieSix.setJudul("Bleach");
//        movieSix.setGenre("Genre : Action,Adventure,Fantasy");
//        movieSix.setYear("Year : 2018");
//        movieSix.setStudio("Studio : Pierrot Co., Ltd");
//        movieSix.setDuration("Duration : 108 minutes");
//        movieSix.setDirector("Director : Shinsuke Sato");
//        movieSix.setImage(R.drawable.poster6);
//        listDataKontak.add(movieSix);
//
//        EPLTeamModel movieSeven = new EPLTeamModel();
//        movieSeven.setJudul("Venom");
//        movieSeven.setGenre("Genre : Action,Sci-fi");
//        movieSeven.setYear("Year : 2018");
//        movieSeven.setStudio("Studio : Columbia Pictures");
//        movieSeven.setDuration("Duration : 112 minutes");
//        movieSeven.setDirector("Director : Ruben Fleischer");
//        movieSeven.setImage(R.drawable.poster7);
//        listDataKontak.add(movieSeven);
//
//        EPLTeamModel movieEight = new EPLTeamModel();
//        movieEight.setJudul("Black Adam");
//        movieEight.setGenre("Genre : Action,Adventure");
//        movieEight.setYear("Year : 2022");
//        movieEight.setStudio("Studio : DC Studios");
//        movieEight.setDuration("Duration : 125 minutes");
//        movieEight.setDirector("Director : Jaume Collet-Serra");
//        movieEight.setImage(R.drawable.poster8);
//        listDataKontak.add(movieEight);
//
//        EPLTeamModel movieNine = new EPLTeamModel();
//        movieNine.setJudul("Jujutsu Kaisen 0");
//        movieNine.setGenre("Genre : Fantasy,Action,Mystery");
//        movieNine.setYear("Year : 2021");
//        movieNine.setStudio("Studio : MAPPA");
//        movieNine.setDuration("Duration : 105 minutes");
//        movieNine.setDirector("Director : Sunghoo Park");
//        movieNine.setImage(R.drawable.poster9);
//        listDataKontak.add(movieNine);
//
//        EPLTeamModel movieTen = new EPLTeamModel();
//        movieTen.setJudul("Mortal Kombat");
//        movieTen.setGenre("Genre : Fantasy,Action,Martial Arts,Thriller");
//        movieTen.setYear("Year : 2021");
//        movieTen.setStudio("Studio : New Line Cinema");
//        movieTen.setDuration("Duration : 110 minutes");
//        movieTen.setDirector("Director : Simon McQuoid");
//        movieTen.setImage(R.drawable.poster10);
//        listDataKontak.add(movieTen);
//

    }

    @Override
    public void onContactSelected(EPLTeamModel myteam) {
        Intent intent = new Intent(MainActivity.this, DetailPage.class);
        intent.putExtra("myteam", myteam);
        startActivity(intent);

//        Toast.makeText(this, "selected name "+contact.getJudul(), Toast.LENGTH_SHORT).show();
    }
}