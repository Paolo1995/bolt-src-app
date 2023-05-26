package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$layout;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class u5 extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    public static final a f45331f = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        View.inflate(context, R$layout.rib_dialog_error, this);
        setBackgroundColor(uq.d(this, R$color.transparent_500));
        uq.L(this);
        uq.d0(this);
        setElevation(f2.i(context, 10.0f));
    }

    public /* synthetic */ u5(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
