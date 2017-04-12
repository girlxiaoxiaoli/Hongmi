// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SheDetailsActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.SheDetailsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034315, "field 'sue_truename'");
    target.sue_truename = finder.castView(view, 2131034315, "field 'sue_truename'");
    view = finder.findRequiredView(source, 2131034317, "field 'syhzh'");
    target.syhzh = finder.castView(view, 2131034317, "field 'syhzh'");
    view = finder.findRequiredView(source, 2131034314, "field 'sue_account'");
    target.sue_account = finder.castView(view, 2131034314, "field 'sue_account'");
    view = finder.findRequiredView(source, 2131034443, "field 'iv_goback' and method 'goBack'");
    target.iv_goback = finder.castView(view, 2131034443, "field 'iv_goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.goBack(finder.<android.widget.ImageView>castParam(p0, "doClick", 0, "goBack", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034311, "field 'sid'");
    target.sid = finder.castView(view, 2131034311, "field 'sid'");
    view = finder.findRequiredView(source, 2131034319, "field 'sue_accname'");
    target.sue_accname = finder.castView(view, 2131034319, "field 'sue_accname'");
    view = finder.findRequiredView(source, 2131034313, "field 'sdata'");
    target.sdata = finder.castView(view, 2131034313, "field 'sdata'");
    view = finder.findRequiredView(source, 2131034318, "field 'szfb'");
    target.szfb = finder.castView(view, 2131034318, "field 'szfb'");
    view = finder.findRequiredView(source, 2131034316, "field 'syhmc'");
    target.syhmc = finder.castView(view, 2131034316, "field 'syhmc'");
    view = finder.findRequiredView(source, 2131034312, "field 'sjb'");
    target.sjb = finder.castView(view, 2131034312, "field 'sjb'");
    view = finder.findRequiredView(source, 2131034444, "field 'title'");
    target.title = finder.castView(view, 2131034444, "field 'title'");
    view = finder.findRequiredView(source, 2131034320, "field 'dakuan_layout'");
    target.dakuan_layout = finder.castView(view, 2131034320, "field 'dakuan_layout'");
  }

  @Override public void unbind(T target) {
    target.sue_truename = null;
    target.syhzh = null;
    target.sue_account = null;
    target.iv_goback = null;
    target.sid = null;
    target.sue_accname = null;
    target.sdata = null;
    target.szfb = null;
    target.syhmc = null;
    target.sjb = null;
    target.title = null;
    target.dakuan_layout = null;
  }
}
