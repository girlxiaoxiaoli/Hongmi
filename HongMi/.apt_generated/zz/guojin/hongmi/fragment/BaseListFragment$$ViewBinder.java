// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BaseListFragment$$ViewBinder<T extends zz.guojin.hongmi.fragment.BaseListFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034338, "field 'xlistview'");
    target.xlistview = finder.castView(view, 2131034338, "field 'xlistview'");
  }

  @Override public void unbind(T target) {
    target.xlistview = null;
  }
}
