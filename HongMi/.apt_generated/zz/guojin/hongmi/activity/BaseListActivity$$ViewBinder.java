// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BaseListActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.BaseListActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034466, "field 'title_second'");
    target.title_second = finder.castView(view, 2131034466, "field 'title_second'");
    view = finder.findRequiredView(source, 2131034464, "field 'goback' and method 'onClick'");
    target.goback = finder.castView(view, 2131034464, "field 'goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick();
        }
      });
    view = finder.findRequiredView(source, 2131034154, "field 'xListView'");
    target.xListView = finder.castView(view, 2131034154, "field 'xListView'");
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
  }

  @Override public void unbind(T target) {
    target.title_second = null;
    target.goback = null;
    target.xListView = null;
    target.title = null;
  }
}
