package ee.mtakso.driver.ui.base.statistics;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import ee.mtakso.driver.R;

/* loaded from: classes3.dex */
public class BarGraphView extends RelativeLayout {

    /* renamed from: f  reason: collision with root package name */
    private BarGraphAdapter f26327f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f26328g;

    /* renamed from: h  reason: collision with root package name */
    private OnBarClickListener f26329h;

    /* renamed from: i  reason: collision with root package name */
    private BarGraphTooltipView f26330i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f26331j;

    /* loaded from: classes3.dex */
    public interface OnBarClickListener {
        void w(int i8);
    }

    public BarGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26331j = new View.OnClickListener() { // from class: ee.mtakso.driver.ui.base.statistics.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BarGraphView.this.d(view);
            }
        };
        c();
    }

    private BarGraphItemModel b(float f8, int i8) {
        return BarGraphItemModel.a(this.f26327f.c(i8), this.f26327f.f(i8), this.f26327f.b(), f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        OnBarClickListener onBarClickListener = this.f26329h;
        if (onBarClickListener != null) {
            onBarClickListener.w(((Integer) view.getTag(R.id.bargraph_Position)).intValue());
        }
    }

    private static float g(float[] fArr) {
        float f8 = 0.0f;
        for (float f9 : fArr) {
            f8 += f9;
        }
        return f8;
    }

    public void c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f26328g = linearLayout;
        linearLayout.setId(R.id.bargraph_Bars);
        this.f26328g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.f26330i = BarGraphTooltipView.h(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, R.id.bargraph_Bars);
        this.f26330i.setLayoutParams(layoutParams);
        this.f26330i.setVisibility(8);
        this.f26330i.setOnClickListener(this.f26331j);
        addView(this.f26328g);
        addView(this.f26330i);
    }

    public void e(boolean z7) {
        boolean z8;
        int i8;
        int selectedPosition = getSelectedPosition();
        int i9 = 0;
        if (this.f26327f.d() == 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        BarGraphTooltipView barGraphTooltipView = this.f26330i;
        if (z8) {
            i8 = 8;
        } else {
            i8 = 0;
        }
        barGraphTooltipView.setVisibility(i8);
        float f8 = Float.NEGATIVE_INFINITY;
        Integer num = null;
        for (int i10 = 0; i10 < this.f26327f.d(); i10++) {
            float g8 = g(this.f26327f.f(i10));
            if (g8 > f8) {
                num = Integer.valueOf(i10);
                f8 = g8;
            }
        }
        if (z7 && this.f26328g.getChildCount() == this.f26327f.d()) {
            while (i9 < this.f26327f.d()) {
                ((BarGraphItemView) this.f26328g.getChildAt(i9)).j(b(f8, i9), true);
                i9++;
            }
        } else {
            this.f26328g.removeAllViews();
            while (i9 < this.f26327f.d()) {
                BarGraphItemView c8 = BarGraphItemView.c(getContext(), b(f8, i9));
                c8.setTag(R.id.bargraph_Position, Integer.valueOf(i9));
                c8.setOnClickListener(this.f26331j);
                this.f26328g.addView(c8);
                i9++;
            }
        }
        if (selectedPosition != -1) {
            f(selectedPosition);
        } else if (num != null) {
            f(num.intValue());
        }
    }

    public void f(int i8) {
        boolean z7;
        for (int i9 = 0; i9 < this.f26328g.getChildCount(); i9++) {
            View childAt = this.f26328g.getChildAt(i9);
            if (i9 == i8) {
                z7 = true;
            } else {
                z7 = false;
            }
            childAt.setSelected(z7);
        }
        this.f26327f.e(i8);
        this.f26330i.setTag(R.id.bargraph_Position, Integer.valueOf(i8));
        this.f26330i.f(this, this.f26328g.getChildAt(i8));
    }

    public int getSelectedPosition() {
        for (int i8 = 0; i8 < this.f26328g.getChildCount(); i8++) {
            if (this.f26328g.getChildAt(i8).isSelected()) {
                return i8;
            }
        }
        return -1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i8 = savedState.f26332f;
        BarGraphAdapter barGraphAdapter = this.f26327f;
        if (barGraphAdapter != null && i8 >= 0 && i8 < barGraphAdapter.d()) {
            f(i8);
        }
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getSelectedPosition());
    }

    public void setAdapter(BarGraphAdapter barGraphAdapter) {
        this.f26327f = barGraphAdapter;
        this.f26330i.j(barGraphAdapter.a());
        e(false);
    }

    public void setOnBarClickListener(OnBarClickListener onBarClickListener) {
        this.f26329h = onBarClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: ee.mtakso.driver.ui.base.statistics.BarGraphView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private final int f26332f;

        public SavedState(Parcelable parcelable, int i8) {
            super(parcelable);
            this.f26332f = i8;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f26332f);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f26332f = parcel.readInt();
        }
    }
}
