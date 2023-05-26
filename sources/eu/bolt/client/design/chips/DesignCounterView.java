package eu.bolt.client.design.chips;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.o4;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class DesignCounterView extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    private final o4 f40026f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignCounterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignCounterView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        o4 a8 = o4.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f40026f = a8;
        setBackground(f2.o(context, R$drawable.bg_chip_counter));
    }

    public /* synthetic */ DesignCounterView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final o4 getBinding() {
        return this.f40026f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(Math.max(getMeasuredWidth(), getMeasuredHeight()), getMeasuredHeight());
    }

    public final void setCount(int i8) {
        this.f40026f.f44411b.setText(String.valueOf(i8));
    }
}
