// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class QiangOrderActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.QiangOrderActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034288, "field 'money_yin'");
    target.money_yin = finder.castView(view, 2131034288, "field 'money_yin'");
    view = finder.findRequiredView(source, 2131034281, "field 'tong_layout' and method 'onClick'");
    target.tong_layout = finder.castView(view, 2131034281, "field 'tong_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034284, "field 'money_tong'");
    target.money_tong = finder.castView(view, 2131034284, "field 'money_tong'");
    view = finder.findRequiredView(source, 2131034296, "field 'money_zuan'");
    target.money_zuan = finder.castView(view, 2131034296, "field 'money_zuan'");
    view = finder.findRequiredView(source, 2131034285, "field 'yin_layout' and method 'onClick'");
    target.yin_layout = finder.castView(view, 2131034285, "field 'yin_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034289, "field 'jin_layout' and method 'onClick'");
    target.jin_layout = finder.castView(view, 2131034289, "field 'jin_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034292, "field 'money_jin'");
    target.money_jin = finder.castView(view, 2131034292, "field 'money_jin'");
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
    view = finder.findRequiredView(source, 2131034293, "field 'zuan_layout' and method 'onClick'");
    target.zuan_layout = finder.castView(view, 2131034293, "field 'zuan_layout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
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
  }

  @Override public void unbind(T target) {
    target.money_yin = null;
    target.tong_layout = null;
    target.money_tong = null;
    target.money_zuan = null;
    target.yin_layout = null;
    target.jin_layout = null;
    target.money_jin = null;
    target.title = null;
    target.zuan_layout = null;
    target.img_back = null;
  }
}
