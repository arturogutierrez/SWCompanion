package com.arturogutierrez.swcompanion.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.arturogutierrez.swcompanion.application.SWApplication;
import com.arturogutierrez.swcompanion.di.component.ApplicationComponent;
import com.arturogutierrez.swcompanion.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(getLayoutResource());

    getApplicationComponent().inject(this);
    ButterKnife.bind(this);
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((SWApplication) getApplication()).getApplicationComponent();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

  protected abstract int getLayoutResource();
}
