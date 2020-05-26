package com.example.reminderproject_bt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView bgApp, clover;
    LinearLayout textsplash,texthome, menus;
    Animation frombottom;
    private CardView calendar_card, notes_card, newnote_card,settings_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);

        bgApp = findViewById(R.id.bgApp);
        clover = findViewById(R.id.clover);
        textsplash = findViewById(R.id.textsplash);
        texthome = findViewById(R.id.texthome);
        menus = findViewById(R.id.menus);
        calendar_card = findViewById(R.id.Calendar_card);
        notes_card = findViewById(R.id.NoteList_card);
        newnote_card = findViewById(R.id.NewNote_card);
        settings_card = findViewById(R.id.Settings_card);

        settings_card.setOnClickListener(this);
        newnote_card.setOnClickListener(this);
        calendar_card.setOnClickListener(this);
        notes_card.setOnClickListener(this);


        bgApp.animate().translationY(-1800).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);


        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){//değiştir - setting
            case R.id.NewNote_card : i = new Intent(this,NoteAdd.class); startActivity(i); break;
            case R.id.Settings_card : i = new Intent(this,SettingsActivity.class); startActivity(i); break;
            case R.id.NoteList_card : i = new Intent(this,NoteList.class); startActivity(i); break;
            case R.id.Calendar_card : i = new Intent(this,Calendar.class); startActivity(i); break; // calendar yap
            default:break;
        }
    }
}
