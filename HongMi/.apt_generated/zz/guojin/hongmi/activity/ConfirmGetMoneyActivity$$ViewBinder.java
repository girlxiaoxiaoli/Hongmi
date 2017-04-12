// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ConfirmGetMoneyActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.ConfirmGetMoneyActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034443, "field 'goback' and method 'img_back'");
    target.goback = finder.castView(view, 2131034443, "field 'goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.img_back(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034210, "field 'male1'");
    target.male1 = finder.castView(view, 2131034210, "field 'male1'");
    view = finder.findRequiredView(source, 2131034444, "field 'title'");
    target.title = finder.castView(view, 2131034444, "field 'title'");
    view = finder.findRequiredView(source, 2131034185, "field 'male'");
    target.male = finder.castView(view, 2131034185, "field 'male'");
    view = finder.findRequiredView(source, 2131034184, "field 'sex'");
    target.sex = finder.castView(view, 2131034184, "field 'sex'");
  }

  @Override public void unbind(T target) {
    target.goback = null;
    target.male1 = null;
    target.title = null;
    target.male = null;
    target.sex = null;
  }
}
