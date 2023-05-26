package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import eu.bolt.verification.R$color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class v7 extends ConstraintLayout {
    private final hg E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v7(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        hg a8 = hg.a(LayoutInflater.from(context), this);
        Intrinsics.e(a8, "inflate(LayoutInflater.from(context), this)");
        this.E = a8;
        setBackgroundColor(uq.d(this, R$color.F));
        uq.L(this);
        uq.d0(this);
    }

    public /* synthetic */ v7(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final hg getBinding() {
        return this.E;
    }
}
