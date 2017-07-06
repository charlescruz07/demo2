package com.cruz.sportify.Main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.cruz.sportify.Main.Feed.FeedFragment;
import com.cruz.sportify.Main.Profile.ProfileActivity;
import com.cruz.sportify.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;

public class MainActivity extends AppCompatActivity {

    PrimaryDrawerItem home, badges, editProfile, settings, logOut, partners, helpAndFeedback, reportBug, aboutSportify;
    AccountHeader accountHeader;
    Toolbar toolbar;
    Drawer drawer;
    Window window;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializes window
        window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#2c3e50"));
        }

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer();
            }
        });

        //Initializes drawer items
        initNavDrawerItems();

        //Initializes drawer profile
        initNavDrawerProfile();

        drawer = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withActivity(this)
                .addDrawerItems(
                        home,
                        badges,
                        editProfile,
                        settings,
                        logOut,
                        new DividerDrawerItem(),
                        partners,
                        helpAndFeedback,
                        reportBug,
                        aboutSportify

                )
                .withSelectedItem(0)
                .buildForFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(frameLayout.getId(),new FeedFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    private void initNavDrawerProfile() {


        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.background)
                .addProfiles(
                        new ProfileDrawerItem().withName("Charles Cruz")
                                .withEmail("charles.cruz07@yahoo.com")
                                .withIcon(R.drawable.charles)
                )
                .withOnAccountHeaderProfileImageListener(new AccountHeader.OnAccountHeaderProfileImageListener() {
                    @Override
                    public boolean onProfileImageClick(View view, IProfile profile, boolean current) {
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        return false;
                    }

                    @Override
                    public boolean onProfileImageLongClick(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .build();
    }

    private void initNavDrawerItems() {


        home = new PrimaryDrawerItem()
                .withIdentifier(0)
                .withName("Home")
                .withIcon(CommunityMaterial.Icon.cmd_home);


        badges = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName("Badges")
                .withIcon(CommunityMaterial.Icon.cmd_ribbon)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){

                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                });

        editProfile = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName("Edit Profile")
                .withIcon(CommunityMaterial.Icon.cmd_account_settings_variant)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                });

        settings = new PrimaryDrawerItem()
                .withIdentifier(4)
                .withName("Settings")
                .withIcon(CommunityMaterial.Icon.cmd_settings)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                });


        logOut = new PrimaryDrawerItem()
                .withIdentifier(5)
                .withName("Log Out")
                .withIcon(CommunityMaterial.Icon.cmd_logout)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                });

        partners = new PrimaryDrawerItem()
                .withIdentifier(6)
                .withName("Partners")
                .withIcon(CommunityMaterial.Icon.cmd_account_network);

        helpAndFeedback = new PrimaryDrawerItem()
                .withIdentifier(6)
                .withName("Help & Feedback")
                .withIcon(CommunityMaterial.Icon.cmd_help);

        reportBug = new PrimaryDrawerItem()
                .withIdentifier(7)
                .withName("Report Bug")
                .withIcon(CommunityMaterial.Icon.cmd_bug);

        aboutSportify = new PrimaryDrawerItem()
                .withIdentifier(8)
                .withName("About Sportify")
                .withIcon(CommunityMaterial.Icon.cmd_account_box_outline);
    }
}
