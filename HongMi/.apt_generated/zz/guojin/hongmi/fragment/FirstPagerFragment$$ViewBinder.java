// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FirstPagerFragment$$ViewBinder<T extends zz.guojin.hongmi.fragment.FirstPagerFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034374, "field 'tv_dami' and method 'onClick'");
    target.tv_dami = finder.castView(view, 2131034374, "field 'tv_dami'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034377, "field 'luck_wheel' and method 'onClick'");
    target.luck_wheel = finder.castView(view, 2131034377, "field 'luck_wheel'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034363, "field 'tv_name_user'");
    target.tv_name_user = finder.castView(view, 2131034363, "field 'tv_name_user'");
    view = finder.findRequiredView(source, 2131034371, "field 'tv_money2'");
    target.tv_money2 = finder.castView(view, 2131034371, "field 'tv_money2'");
    view = finder.findRequiredView(source, 2131034121, "field 'gridview'");
    target.gridview = finder.castView(view, 2131034121, "field 'gridview'");
    view = finder.findRequiredView(source, 2131034373, "field 'tv_money3'");
    target.tv_money3 = finder.castView(view, 2131034373, "field 'tv_money3'");
    view = finder.findRequiredView(source, 2131034369, "field 'tv_money1'");
    target.tv_money1 = finder.castView(view, 2131034369, "field 'tv_money1'");
    view = finder.findRequiredView(source, 2131034376, "field 'shopping' and method 'onClick'");
    target.shopping = finder.castView(view, 2131034376, "field 'shopping'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034367, "field 'tv_grade_user'");
    target.tv_grade_user = finder.castView(view, 2131034367, "field 'tv_grade_user'");
    view = finder.findRequiredView(source, 2131034375, "field 'tv_shoumi' and method 'onClick'");
    target.tv_shoumi = finder.castView(view, 2131034375, "field 'tv_shoumi'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034365, "field 'tv_id_user'");
    target.tv_id_user = finder.castView(view, 2131034365, "field 'tv_id_user'");
    view = finder.findRequiredView(source, 2131034361, "field 'tv_exit' and method 'onClick'");
    target.tv_exit = finder.castView(view, 2131034361, "field 'tv_exit'");
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
    target.tv_dami = null;
    target.luck_wheel = null;
    target.tv_name_user = null;
    target.tv_money2 = null;
    target.gridview = null;
    target.tv_money3 = null;
    target.tv_money1 = null;
    target.shopping = null;
    target.tv_grade_user = null;
    target.tv_shoumi = null;
    target.tv_id_user = null;
    target.tv_exit = null;
  }
}
