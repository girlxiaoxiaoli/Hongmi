// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SheDetailsActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.SheDetailsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034330, "field 'sue_truename'");
    target.sue_truename = finder.castView(view, 2131034330, "field 'sue_truename'");
    view = finder.findRequiredView(source, 2131034329, "field 'sue_account'");
    target.sue_account = finder.castView(view, 2131034329, "field 'sue_account'");
    view = finder.findRequiredView(source, 2131034334, "field 'sue_accname'");
    target.sue_accname = finder.castView(view, 2131034334, "field 'sue_accname'");
    view = finder.findRequiredView(source, 2131034328, "field 'sdata'");
    target.sdata = finder.castView(view, 2131034328, "field 'sdata'");
    view = finder.findRequiredView(source, 2131034326, "field 'sid'");
    target.sid = finder.castView(view, 2131034326, "field 'sid'");
    view = finder.findRequiredView(source, 2131034327, "field 'sjb'");
    target.sjb = finder.castView(view, 2131034327, "field 'sjb'");
    view = finder.findRequiredView(source, 2131034331, "field 'syhmc'");
    target.syhmc = finder.castView(view, 2131034331, "field 'syhmc'");
    view = finder.findRequiredView(source, 2131034461, "field 'title'");
    target.title = finder.castView(view, 2131034461, "field 'title'");
    view = finder.findRequiredView(source, 2131034460, "field 'iv_goback' and method 'goBack'");
    target.iv_goback = finder.castView(view, 2131034460, "field 'iv_goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.goBack(finder.<android.widget.ImageView>castParam(p0, "doClick", 0, "goBack", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034332, "field 'syhzh'");
    target.syhzh = finder.castView(view, 2131034332, "field 'syhzh'");
    view = finder.findRequiredView(source, 2131034333, "field 'szfb'");
    target.szfb = finder.castView(view, 2131034333, "field 'szfb'");
    view = finder.findRequiredView(source, 2131034335, "field 'dakuan_layout'");
    target.dakuan_layout = finder.castView(view, 2131034335, "field 'dakuan_layout'");
  }

  @Override public void unbind(T target) {
    target.sue_truename = null;
    target.sue_account = null;
    target.sue_accname = null;
    target.sdata = null;
    target.sid = null;
    target.sjb = null;
    target.syhmc = null;
    target.title = null;
    target.iv_goback = null;
    target.syhzh = null;
    target.szfb = null;
    target.dakuan_layout = null;
  }
}
