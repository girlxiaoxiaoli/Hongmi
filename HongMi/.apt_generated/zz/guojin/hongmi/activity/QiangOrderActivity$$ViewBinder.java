// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class QiangOrderActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.QiangOrderActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034444, "field 'title'");
    target.title = finder.castView(view, 2131034444, "field 'title'");
    view = finder.findRequiredView(source, 2131034268, "field 'money_tong'");
    target.money_tong = finder.castView(view, 2131034268, "field 'money_tong'");
    view = finder.findRequiredView(source, 2131034265, "field 'tong_layout' and method 'onClick'");
    target.tong_layout = finder.castView(view, 2131034265, "field 'tong_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034273, "field 'jin_layout' and method 'onClick'");
    target.jin_layout = finder.castView(view, 2131034273, "field 'jin_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034269, "field 'yin_layout' and method 'onClick'");
    target.yin_layout = finder.castView(view, 2131034269, "field 'yin_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034277, "field 'zuan_layout' and method 'onClick'");
    target.zuan_layout = finder.castView(view, 2131034277, "field 'zuan_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034276, "field 'money_jin'");
    target.money_jin = finder.castView(view, 2131034276, "field 'money_jin'");
    view = finder.findRequiredView(source, 2131034272, "field 'money_yin'");
    target.money_yin = finder.castView(view, 2131034272, "field 'money_yin'");
    view = finder.findRequiredView(source, 2131034280, "field 'money_zuan'");
    target.money_zuan = finder.castView(view, 2131034280, "field 'money_zuan'");
    view = finder.findRequiredView(source, 2131034443, "field 'img_back' and method 'onClick'");
    target.img_back = finder.castView(view, 2131034443, "field 'img_back'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.title = null;
    target.money_tong = null;
    target.tong_layout = null;
    target.jin_layout = null;
    target.yin_layout = null;
    target.zuan_layout = null;
    target.money_jin = null;
    target.money_yin = null;
    target.money_zuan = null;
    target.img_back = null;
  }
}
