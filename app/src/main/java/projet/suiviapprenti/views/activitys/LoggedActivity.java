package projet.suiviapprenti.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import projet.suiviapprenti.R;
import projet.suiviapprenti.beans.Apprenti;
import projet.suiviapprenti.utils.LoginForm;
import projet.suiviapprenti.utils.ProfilForm;
import projet.suiviapprenti.views.fragments.CursusFragment;
import projet.suiviapprenti.views.fragments.ParcoursFragment;
import projet.suiviapprenti.views.fragments.ProfilFragment;

public class LoggedActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ProfilForm profilForm;
    LoginForm loginForm;
    Apprenti app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_actiivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        loginForm = new LoginForm();
        profilForm = new ProfilForm();
            updateApprenti();
            this.getIntent().putExtra("Apprenti", app);

        if(findViewById(R.id.fragment_container_profil) != null) {
            ProfilFragment profilFrag = new ProfilFragment();
            profilFrag.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_profil, profilFrag).commit();
        }

    }

    private void updateApprenti() {
        try {
            app = profilForm.getInfosPersonnelles();
        } catch (Exception e) {
            reLog();
        }
    }

    private void reLog() {
        /*Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);*/
        finish();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        updateApprenti();
        if (id == R.id.menu_profil) {
            ProfilFragment profilFrag = new ProfilFragment();
            profilFrag.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_profil, profilFrag).commit();
        } else if (id == R.id.menu_parcours) {
            ParcoursFragment parcoursFrag = new ParcoursFragment();
            parcoursFrag.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_profil, parcoursFrag).commit();
        } else if (id == R.id.menu_cursus) {
            CursusFragment cursusFrag = new CursusFragment();
            cursusFrag.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_profil, cursusFrag).commit();

        } else if (id == R.id.menu_logoff) {
            loginForm.sendDisconnection();
            reLog();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
