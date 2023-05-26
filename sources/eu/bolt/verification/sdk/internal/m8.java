package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import eu.bolt.verification.R$color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m8 extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    private final ig f44162f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m8(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        ig a8 = ig.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f44162f = a8;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setBackgroundResource(R$color.F);
        uq.L(this);
        uq.d0(this);
    }

    public /* synthetic */ m8(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final ig getBinding() {
        return this.f44162f;
    }
}
