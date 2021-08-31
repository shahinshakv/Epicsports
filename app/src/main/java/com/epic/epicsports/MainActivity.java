package com.epic.epicsports;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.startapp.sdk.adsbase.StartAppAd;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private CardView livestream, livecricket, matchhighlights, livescore, topscrores, game, whatspp;
    private StartAppAd startAppAd = new StartAppAd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAppAd.showAd();
        dl = (DrawerLayout) findViewById(R.id.drawer);
        livestream = findViewById(R.id.livestream);
        livecricket = findViewById(R.id.livecricket);
        matchhighlights = findViewById(R.id.matchhighlights);
        livescore = findViewById(R.id.livescore);
        game = findViewById(R.id.game);
        whatspp = findViewById(R.id.whatspp);
        topscrores = findViewById(R.id.topscrores);
        topscrores.setOnClickListener(this);
        whatspp.setOnClickListener(this);
        game.setOnClickListener(this);
        livescore.setOnClickListener(this);
        matchhighlights.setOnClickListener(this);
        livestream.setOnClickListener(this);
        livecricket.setOnClickListener(this);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.navigation_view);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home:
                        dl.closeDrawers();
                        break;
                    case R.id.nav_privacy:
                        Intent privacy = new Intent(MainActivity.this, WebViews.class);
                        privacy.putExtra("url", "https://www.epicsports.site/p/privacy-policy.html");
                        startActivity(privacy);
                        privacy.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        break;
                    case R.id.dmca:
                        Intent dmca = new Intent(MainActivity.this, WebViews.class);
                        dmca.putExtra("url", "https://www.epicsports.site/p/dmca.html");
                        startActivity(dmca);
                        dmca.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        break;
                }


                return true;

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Epicsports offer premium and exclusive sports news and links to watch games online live, News, Wallpapers, Scoreboard, T.V channel Lists.\n" +
                    "\n" +
                    "\uD83D\uDCF1 Download Epicsports App\n" +
                    "\uD83D\uDC49 http://bit.ly/Epicsports_App";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Epic Sports");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.livestream:
                Intent intent = new Intent(this, WebViews.class);
                intent.putExtra("url", "https://www.epicsports.site/");
                this.startActivity(intent);
                startAppAd.showAd();
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                break;

            case R.id.livecricket:
                Intent livecricket = new Intent(this, WebViews.class);
                livecricket.putExtra("url", "https://www.epicsports.site/p/news.html ");
                this.startActivity(livecricket);
                startAppAd.showAd();
                livecricket.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                break;

            case R.id.matchhighlights:
                Intent matchhighlights = new Intent(this, WebViews.class);
                matchhighlights.putExtra("url", "https://www.epicsports.site/p/highlights.html");
                this.startActivity(matchhighlights);
                startAppAd.showAd();
                matchhighlights.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                break;

            case R.id.livescore:
                Intent livescore = new Intent(this, WebViews.class);
                livescore.putExtra("url", "https://www.epicsports.site/p/point-table.html");
                this.startActivity(livescore);
                startAppAd.showAd();
                livescore.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                break;

            case R.id.topscrores:
                Intent topscrores = new Intent(this, WebViews.class);
                topscrores.putExtra("url", "https://www.epicsports.site/p/top-scorers.html");
                this.startActivity(topscrores);
                startAppAd.showAd();
                topscrores.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                break;

            case R.id.game:
                Intent game = new Intent(this, WebViews.class);
                game.putExtra("url", "https://doodlecricket.github.io/#/");
                this.startActivity(game);
                startAppAd.showAd();
                game.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                break;
            case R.id.whatspp:
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Epicsports offer premium and exclusive sports news and links to watch games online live, News, Wallpapers, Scoreboard, T.V channel Lists.\n" +
                        "\n" +
                        "\uD83D\uDCF1 Download Epicsports App\n" +
                        "\uD83D\uDC49 http://bit.ly/Epicsports_App");
                try {
                    this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Whatsapp have not been installed.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startAppAd.onBackPressed();
        super.onBackPressed();

    }
}
