package ee.mtakso.driver.ui.base.statistics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import ee.mtakso.driver.R;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
class BarGraphTooltipView extends RelativeLayout {

    /* renamed from: f  reason: collision with root package name */
    private final int f26320f;

    /* renamed from: g  reason: collision with root package name */
    private View f26321g;

    /* renamed from: h  reason: collision with root package name */
    private View f26322h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f26323i;

    private BarGraphTooltipView(Context context, int i8) {
        super(context);
        this.f26320f = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float g(float f8, float f9, float f10) {
        return Math.max(f9, Math.min(f8, f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BarGraphTooltipView h(Context context) {
        BarGraphTooltipView barGraphTooltipView = new BarGraphTooltipView(context, context.getResources().getDimensionPixelSize(R.dimen.bargraph_bar_horizontal_margin));
        barGraphTooltipView.i();
        return barGraphTooltipView;
    }

    private void i() {
        View.inflate(getContext(), R.layout.bargraph_tooltip, this);
        this.f26321g = findViewById(R.id.bargraph_tooltipArrow);
        this.f26322h = findViewById(R.id.bargraph_tooltipBackground);
        this.f26323i = (ViewGroup) findViewById(R.id.bargraph_tooltipContent);
    }

    public void f(final View view, final View view2) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ee.mtakso.driver.ui.base.statistics.BarGraphTooltipView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float x7 = view2.getX() + (view2.getWidth() * 0.5f);
                BarGraphTooltipView.this.f26321g.setX(x7 - (BarGraphTooltipView.this.f26321g.getWidth() * 0.5f));
                float width = x7 - (BarGraphTooltipView.this.f26323i.getWidth() * 0.5f);
                BarGraphTooltipView.this.f26323i.setX(BarGraphTooltipView.g(width, BarGraphTooltipView.this.f26320f, (view.getWidth() - BarGraphTooltipView.this.f26320f) - BarGraphTooltipView.this.f26323i.getWidth()));
                BarGraphTooltipView.this.f26322h.setX(BarGraphTooltipView.g(width, BarGraphTooltipView.this.f26320f, (view.getWidth() - BarGraphTooltipView.this.f26320f) - BarGraphTooltipView.this.f26322h.getWidth()));
            }
        });
        requestLayout();
    }

    public void j(View view) {
        this.f26323i.removeAllViews();
        this.f26323i.addView(view, -2, -2);
    }
}
