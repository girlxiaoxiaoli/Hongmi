// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LuckyWheelActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.LuckyWheelActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034251, "field 'thirdAward'");
    target.thirdAward = finder.castView(view, 2131034251, "field 'thirdAward'");
    view = finder.findRequiredView(source, 2131034466, "field 'title_second' and method 'click'");
    target.title_second = finder.castView(view, 2131034466, "field 'title_second'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034252, "field 'fourthAward'");
    target.fourthAward = finder.castView(view, 2131034252, "field 'fourthAward'");
    view = finder.findRequiredView(source, 2131034253, "field 'fifthAward'");
    target.fifthAward = finder.castView(view, 2131034253, "field 'fifthAward'");
    view = finder.findRequiredView(source, 2131034255, "field 'sevenAward'");
    target.sevenAward = finder.castView(view, 2131034255, "field 'sevenAward'");
    view = finder.findRequiredView(source, 2131034245, "field 'layout'");
    target.layout = finder.castView(view, 2131034245, "field 'layout'");
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
    view = finder.findRequiredView(source, 2131034464, "field 'ivGoback' and method 'click'");
    target.ivGoback = finder.castView(view, 2131034464, "field 'ivGoback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.click(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034250, "field 'secondAward'");
    target.secondAward = finder.castView(view, 2131034250, "field 'secondAward'");
    view = finder.findRequiredView(source, 2131034249, "field 'firstAward'");
    target.firstAward = finder.castView(view, 2131034249, "field 'firstAward'");
    view = finder.findRequiredView(source, 2131034246, "field 'panWheel'");
    target.panWheel = finder.castView(view, 2131034246, "field 'panWheel'");
    view = finder.findRequiredView(source, 2131034248, "field 'btnClick' and method 'startWheel'");
    target.btnClick = finder.castView(view, 2131034248, "field 'btnClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.startWheel();
        }
      });
    view = finder.findRequiredView(source, 2131034254, "field 'sixthAward'");
    target.sixthAward = finder.castView(view, 2131034254, "field 'sixthAward'");
  }

  @Override public void unbind(T target) {
    target.thirdAward = null;
    target.title_second = null;
    target.fourthAward = null;
    target.fifthAward = null;
    target.sevenAward = null;
    target.layout = null;
    target.title = null;
    target.ivGoback = null;
    target.secondAward = null;
    target.firstAward = null;
    target.panWheel = null;
    target.btnClick = null;
    target.sixthAward = null;
  }
}
