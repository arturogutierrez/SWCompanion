package com.arturogutierrez.swcompanion.view.fragment;

import android.support.v4.app.Fragment;
import com.arturogutierrez.swcompanion.di.HasComponent;

public abstract class BaseFragment extends Fragment{

  @SuppressWarnings("unchecked")
  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
