// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DeDetailsActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.DeDetailsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034209, "field 'pic_load' and method 'onClick'");
    target.pic_load = finder.castView(view, 2131034209, "field 'pic_load'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034206, "field 'sweixin'");
    target.sweixin = finder.castView(view, 2131034206, "field 'sweixin'");
    view = finder.findRequiredView(source, 2131034202, "field 'sphone'");
    target.sphone = finder.castView(view, 2131034202, "field 'sphone'");
    view = finder.findRequiredView(source, 2131034203, "field 'syhmc'");
    target.syhmc = finder.castView(view, 2131034203, "field 'syhmc'");
    view = finder.findRequiredView(source, 2131034198, "field 'sjb'");
    target.sjb = finder.castView(view, 2131034198, "field 'sjb'");
    view = finder.findRequiredView(source, 2131034162, "field 'iv_goback' and method 'goBack'");
    target.iv_goback = finder.castView(view, 2131034162, "field 'iv_goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.goBack(finder.<android.widget.ImageView>castParam(p0, "doClick", 0, "goBack", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034201, "field 'sue_truename'");
    target.sue_truename = finder.castView(view, 2131034201, "field 'sue_truename'");
    view = finder.findRequiredView(source, 2131034197, "field 'sid'");
    target.sid = finder.castView(view, 2131034197, "field 'sid'");
    view = finder.findRequiredView(source, 2131034208, "field 'dakuan_layout'");
    target.dakuan_layout = finder.castView(view, 2131034208, "field 'dakuan_layout'");
    view = finder.findRequiredView(source, 2131034200, "field 'sue_account'");
    target.sue_account = finder.castView(view, 2131034200, "field 'sue_account'");
    view = finder.findRequiredView(source, 2131034207, "field 'sue_accname'");
    target.sue_accname = finder.castView(view, 2131034207, "field 'sue_accname'");
    view = finder.findRequiredView(source, 2131034205, "field 'szfb'");
    target.szfb = finder.castView(view, 2131034205, "field 'szfb'");
    view = finder.findRequiredView(source, 2131034204, "field 'syhzh'");
    target.syhzh = finder.castView(view, 2131034204, "field 'syhzh'");
    view = finder.findRequiredView(source, 2131034199, "field 'sdata'");
    target.sdata = finder.castView(view, 2131034199, "field 'sdata'");
  }

  @Override public void unbind(T target) {
    target.pic_load = null;
    target.sweixin = null;
    target.sphone = null;
    target.syhmc = null;
    target.sjb = null;
    target.iv_goback = null;
    target.sue_truename = null;
    target.sid = null;
    target.dakuan_layout = null;
    target.sue_account = null;
    target.sue_accname = null;
    target.szfb = null;
    target.syhzh = null;
    target.sdata = null;
  }
}
