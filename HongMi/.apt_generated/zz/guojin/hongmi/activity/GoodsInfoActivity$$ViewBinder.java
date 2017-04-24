// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GoodsInfoActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.GoodsInfoActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034231, "field 'etNumber'");
    target.etNumber = finder.castView(view, 2131034231, "field 'etNumber'");
    view = finder.findRequiredView(source, 2131034235, "field 'et_address'");
    target.et_address = finder.castView(view, 2131034235, "field 'et_address'");
    view = finder.findRequiredView(source, 2131034227, "field 'imgGoods'");
    target.imgGoods = finder.castView(view, 2131034227, "field 'imgGoods'");
    view = finder.findRequiredView(source, 2131034236, "field 'btnPay' and method 'onClick'");
    target.btnPay = finder.castView(view, 2131034236, "field 'btnPay'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034230, "field 'tvSub' and method 'onClick'");
    target.tvSub = finder.castView(view, 2131034230, "field 'tvSub'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034228, "field 'infoGoods'");
    target.infoGoods = finder.castView(view, 2131034228, "field 'infoGoods'");
    view = finder.findRequiredView(source, 2131034232, "field 'tvCount' and method 'onClick'");
    target.tvCount = finder.castView(view, 2131034232, "field 'tvCount'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034229, "field 'tvPrice'");
    target.tvPrice = finder.castView(view, 2131034229, "field 'tvPrice'");
    view = finder.findRequiredView(source, 2131034226, "field 'tvGoback' and method 'onClick'");
    target.tvGoback = finder.castView(view, 2131034226, "field 'tvGoback'");
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
    target.etNumber = null;
    target.et_address = null;
    target.imgGoods = null;
    target.btnPay = null;
    target.tvSub = null;
    target.infoGoods = null;
    target.tvCount = null;
    target.tvPrice = null;
    target.tvGoback = null;
  }
}
