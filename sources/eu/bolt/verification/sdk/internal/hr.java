package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsCompat;
import eu.bolt.verification.R$color;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class hr extends ConstraintLayout {
    private final lg E;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<WindowInsetsCompat, Unit> {
        a() {
            super(1);
        }

        public final void b(WindowInsetsCompat insets) {
            Intrinsics.f(insets, "insets");
            uq.z(hr.this, insets, (r13 & 2) != 0 ? false : true, (r13 & 4) != 0 ? false : false, (r13 & 8) != 0 ? false : true, (r13 & 16) != 0 ? false : true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WindowInsetsCompat windowInsetsCompat) {
            b(windowInsetsCompat);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hr(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        lg a8 = lg.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.E = a8;
        setBackgroundColor(uq.d(this, R$color.F));
    }

    public /* synthetic */ hr(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final lg getBinding() {
        return this.E;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        Intrinsics.f(view, "view");
        super.onViewAdded(view);
        uq.B(view, new a());
    }
}
