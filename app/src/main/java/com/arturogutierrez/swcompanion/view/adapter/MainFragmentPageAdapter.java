package com.arturogutierrez.swcompanion.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.arturogutierrez.swcompanion.R;
import com.arturogutierrez.swcompanion.view.fragment.FilmListFragment;

public class MainFragmentPageAdapter extends FragmentPagerAdapter {

  private PageConfiguration pageConfiguration[];
  private Fragment fragmentsCache[];

  public MainFragmentPageAdapter(Context context, FragmentManager fragmentManager) {
    super(fragmentManager);

    initialize(context);
  }

  private void initialize(Context context) {
    pageConfiguration = new PageConfiguration[1];
    pageConfiguration[0] =
        new PageConfiguration(context.getString(R.string.films), FilmListFragment.class);

    fragmentsCache = new Fragment[1];
  }

  @Override
  public Fragment getItem(int position) {
    if (fragmentsCache[position] == null) {
      fragmentsCache[position] = createPageFragment(position);
    }

    return fragmentsCache[position];
  }

  @Override
  public int getCount() {
    return fragmentsCache.length;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return pageConfiguration[position].tabTitle;
  }

  private Fragment createPageFragment(int position) {
    Class fragmentClass = pageConfiguration[position].fragmentClass;

    try {
      return (Fragment) fragmentClass.newInstance();
    } catch (InstantiationException e) {
      // Do not happen
    } catch (IllegalAccessException e) {
      // Do not happen
    }

    return null;
  }

  private class PageConfiguration {
    private String tabTitle;
    private Class fragmentClass;

    private PageConfiguration(String tabTitle, Class fragmentClass) {
      this.tabTitle = tabTitle;
      this.fragmentClass = fragmentClass;
    }
  }
}
