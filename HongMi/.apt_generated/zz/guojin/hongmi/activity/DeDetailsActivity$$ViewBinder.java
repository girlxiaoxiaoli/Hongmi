// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DeDetailsActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.DeDetailsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034207, "field 'syhmc'");
    target.syhmc = finder.castView(view, 2131034207, "field 'syhmc'");
    view = finder.findRequiredView(source, 2131034208, "field 'syhzh'");
    target.syhzh = finder.castView(view, 2131034208, "field 'syhzh'");
    view = finder.findRequiredView(source, 2131034201, "field 'sid'");
    target.sid = finder.castView(view, 2131034201, "field 'sid'");
    view = finder.findRequiredView(source, 2131034202, "field 'sjb'");
    target.sjb = finder.castView(view, 2131034202, "field 'sjb'");
    view = finder.findRequiredView(source, 2131034209, "field 'szfb'");
    target.szfb = finder.castView(view, 2131034209, "field 'szfb'");
    view = finder.findRequiredView(source, 2131034212, "field 'dakuan_layout'");
    target.dakuan_layout = finder.castView(view, 2131034212, "field 'dakuan_layout'");
    view = finder.findRequiredView(source, 2131034206, "field 'sphone'");
    target.sphone = finder.castView(view, 2131034206, "field 'sphone'");
    view = finder.findRequiredView(source, 2131034205, "field 'sue_truename'");
    target.sue_truename = finder.castView(view, 2131034205, "field 'sue_truename'");
    view = finder.findRequiredView(source, 2131034464, "field 'img_back' and method 'onClick'");
    target.img_back = finder.castView(view, 2131034464, "field 'img_back'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
    view = finder.findRequiredView(source, 2131034211, "field 'sue_accname'");
    target.sue_accname = finder.castView(view, 2131034211, "field 'sue_accname'");
    view = finder.findRequiredView(source, 2131034204, "field 'sue_account'");
    target.sue_account = finder.castView(view, 2131034204, "field 'sue_account'");
    view = finder.findRequiredView(source, 2131034213, "field 'pic_load' and method 'onClick'");
    target.pic_load = finder.castView(view, 2131034213, "field 'pic_load'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034203, "field 'sdata'");
    target.sdata = finder.castView(view, 2131034203, "field 'sdata'");
    view = finder.findRequiredView(source, 2131034210, "field 'sweixin'");
    target.sweixin = finder.castView(view, 2131034210, "field 'sweixin'");
  }

  @Override public void unbind(T target) {
    target.syhmc = null;
    target.syhzh = null;
    target.sid = null;
    target.sjb = null;
    target.szfb = null;
    target.dakuan_layout = null;
    target.sphone = null;
    target.sue_truename = null;
    target.img_back = null;
    target.title = null;
    target.sue_accname = null;
    target.sue_account = null;
    target.pic_load = null;
    target.sdata = null;
    target.sweixin = null;
  }
}
