package com.example.lebed.zenvo.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.lebed.zenvo.R;
import com.example.lebed.zenvo.View.CustomerFragments.AboutCompanyFragment;
import com.example.lebed.zenvo.View.CustomerFragments.CustomerAccountSettingsFragment;
import com.example.lebed.zenvo.View.CustomerFragments.CustomerConstructorFragment;
import com.example.lebed.zenvo.View.CustomerFragments.CustomerEventsFragment;
import com.example.lebed.zenvo.View.CustomerFragments.CustomerFavoriteContractorsFragment;
import com.example.lebed.zenvo.View.CustomerFragments.Main.CardContractor;
import com.example.lebed.zenvo.View.CustomerFragments.Main.CustomerMainFragment;
import com.example.lebed.zenvo.View.CustomerFragments.CustomerTendersFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private List<CardContractor> contractorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        init();
    }

    public List<CardContractor> getListOfContractors(){

        return contractorList;
    }

    private void init() {
        drawerLayout = findViewById(R.id.customer_drawer_layout);
        ImageButton buttonMenu = findViewById(R.id.customer_menu_button);
        buttonMenu.setOnClickListener(this);

        NavigationView navigationView = findViewById(R.id.customer_navigation_menu);
        navigationView.setNavigationItemSelectedListener(this);

        contractorList = new ArrayList<>();
        contractorList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.mask),"Елон Маск", "4.7","Марс", "Отзывов: 32"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.penelopa),"Пенелопа Крус", "4.1","Щучин", "Отзывов: 98"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.peris),"Сергей Светлаков", "2.7","Светлогорск", "Отзывов: 8"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.tea),"Золотая Чаша", "3.1","Кухонный шкафчик", "Отзывов: 41"));
        contractorList.add(new CardContractor(roundDrawable(R.drawable.gosling),"Райан Гослинг", "4.9","Зельва", "Отзывов: 56"));

        getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                new CustomerMainFragment()).commit();
        navigationView.setCheckedItem(R.id.customer_main_item);


    }
    private RoundedBitmapDrawable roundDrawable(int id){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customer_menu_button:
                drawerLayout.openDrawer(Gravity.START);
                break;
            //    case R.id.customer_main_button:
            //        openFragment(v);
            //        break;
            //    case R.id.customer_constructor_button:
            //        openFragment(v);
//
            //        break;
            //    case R.id.customer_tenders_button:
            //        openFragment(v);
//
            //        break;
            //    case R.id.customer_events_button:
            //        openFragment(v);
//
            //        break;
            //    //case R.id.customer_profile_button:
            //    //    openFragment(v);
//
            //        //break;
            //    case R.id.customer_account_settings_button:
            //        openFragment(v);
//
            //        break;
            //    case R.id.customer_favorite_contractors_button:
            //        openFragment(v);
//
            //        break;
        }

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.customer_main_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new CustomerMainFragment()).commit();
                break;
            case R.id.customer_constructor_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new CustomerConstructorFragment()).commit();
                break;
            case R.id.customer_tenders_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new CustomerTendersFragment()).commit();
                break;
            case R.id.customer_events_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new CustomerEventsFragment()).commit();
                break;
            case R.id.customer_account_settings_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new CustomerAccountSettingsFragment()).commit();
                break;
            case R.id.customer_favorite_contractors_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new CustomerFavoriteContractorsFragment()).commit();
                break;
            case R.id.customer_about_company_item:
                getSupportFragmentManager().beginTransaction().replace(R.id.customer_fragment_container,
                        new AboutCompanyFragment()).commit();
                break;

        }

        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }
}
