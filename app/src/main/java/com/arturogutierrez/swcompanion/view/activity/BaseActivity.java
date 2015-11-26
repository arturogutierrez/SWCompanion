package com.arturogutierrez.swcompanion.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.application.SWApplication;
import com.arturogutierrez.swcompanion.di.component.ApplicationComponent;
import com.arturogutierrez.swcompanion.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

  @Bind(R.id.toolbar)
  protected Toolbar toolbar;

  @Bind(R.id.drawerLayout)
  protected DrawerLayout drawerLayout;
  protected ActionBarDrawerToggle drawerToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(getLayoutResource());

    getApplicationComponent().inject(this);
    ButterKnife.bind(this);

    configureToolbar();
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    if (drawerToggle != null) {
      drawerToggle.syncState();
    }
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    if (drawerToggle != null) {
      drawerToggle.onConfigurationChanged(newConfig);
    }
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((SWApplication) getApplication()).getApplicationComponent();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  protected abstract int getLayoutResource();

  protected void addFragment(int containerViewId, Fragment fragment) {
    FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  private void configureToolbar() {
    setSupportActionBar(toolbar);

    showDrawerLayout();
  }

  private void showDrawerLayout() {
    if (drawerLayout != null) {
      drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,
          R.string.drawer_close);
      drawerLayout.setDrawerListener(drawerToggle);
    }
  }
}
