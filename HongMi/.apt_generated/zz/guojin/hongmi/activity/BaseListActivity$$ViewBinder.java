// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BaseListActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.BaseListActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034443, "field 'goback' and method 'onClick'");
    target.goback = finder.castView(view, 2131034443, "field 'goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick();
        }
      });
    view = finder.findRequiredView(source, 2131034445, "field 'title_second'");
    target.title_second = finder.castView(view, 2131034445, "field 'title_second'");
    view = finder.findRequiredView(source, 2131034150, "field 'xListView'");
    target.xListView = finder.castView(view, 2131034150, "field 'xListView'");
    view = finder.findRequiredView(source, 2131034444, "field 'title'");
    target.title = finder.castView(view, 2131034444, "field 'title'");
  }

  @Override public void unbind(T target) {
    target.goback = null;
    target.title_second = null;
    target.xListView = null;
    target.title = null;
  }
}
