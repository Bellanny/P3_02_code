package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


public class DetailActivity extends AppCompatActivity {

private ImageView avatar;
private TextView nameTextView;
private TextView name;
private TextView address;
private TextView phone;
private TextView social;
private TextView aboutMeTextView;
private TextView aboutMe;
private FloatingActionButton fav;
private NeighbourApiService neighbourService;
private Toolbar toolbard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        neighbourService = DI.getNeighbourApiService();

        Intent intent = getIntent();
        Neighbour neighbour = (Neighbour) intent.getSerializableExtra("Neighbour");

        avatar = findViewById(R.id.avatar);
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(avatar);

         toolbard = findViewById(R.id.toolbar);
         setSupportActionBar(toolbard);
         toolbard.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
         toolbard.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();
             }
         });

        fav = findViewById(R.id.fav);
        if (neighbourService.getFav().contains(neighbour)) {
            fav.setImageResource(R.drawable.ic_star_white_24dp); }
        else {
            fav.setImageResource(R.drawable.ic_star_border_black_24dp);
        }


        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (neighbourService.getFav().contains(neighbour)) {
                    neighbourService.deleteFavNeighbour(neighbour);
                    fav.setImageResource(R.drawable.ic_star_border_black_24dp);
                }
                else {
                neighbourService.addFavNeighbour(neighbour);
                fav.setImageResource(R.drawable.ic_star_white_24dp);
                }
            }
        });

        nameTextView = findViewById(R.id.name);
        nameTextView.setText(neighbour.getName());

        name = findViewById(R.id.name_1);
        name.setText(neighbour.getName());

       address = findViewById(R.id.address);
       address.setText(neighbour.getAddress());

        phone = findViewById(R.id.phone);
        phone.setText(neighbour.getPhoneNumber());

        social = findViewById(R.id.social);
        social.setText(neighbour.getSocial());

        aboutMeTextView = findViewById(R.id.aboutMe_text);
        aboutMeTextView.setText(neighbour.getAboutMeText());

        aboutMe = findViewById(R.id.aboutMe);
        aboutMe.setText(neighbour.getAboutMe());

    }

}
