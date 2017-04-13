// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChangeSecondPwdActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.ChangeSecondPwdActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034162, "field 'before'");
    target.before = finder.castView(view, 2131034162, "field 'before'");
    view = finder.findRequiredView(source, 2131034165, "field 'butt' and method 'onClick'");
    target.butt = finder.castView(view, 2131034165, "field 'butt'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034461, "field 'title'");
    target.title = finder.castView(view, 2131034461, "field 'title'");
    view = finder.findRequiredView(source, 2131034164, "field 'qrnew'");
    target.qrnew = finder.castView(view, 2131034164, "field 'qrnew'");
    view = finder.findRequiredView(source, 2131034460, "field 'goback' and method 'goBack'");
    target.goback = finder.castView(view, 2131034460, "field 'goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.goBack();
        }
      });
    view = finder.findRequiredView(source, 2131034163, "field 'news'");
    target.news = finder.castView(view, 2131034163, "field 'news'");
    view = finder.findRequiredView(source, 2131034161, "field 'll_my_second_pwd'");
    target.ll_my_second_pwd = finder.castView(view, 2131034161, "field 'll_my_second_pwd'");
  }

  @Override public void unbind(T target) {
    target.before = null;
    target.butt = null;
    target.title = null;
    target.qrnew = null;
    target.goback = null;
    target.news = null;
    target.ll_my_second_pwd = null;
  }
}
