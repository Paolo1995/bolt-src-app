package eu.bolt.client.design.pin.destination;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.sdk.internal.a6;
import eu.bolt.verification.sdk.internal.b5;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class PinLabel extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final a f40125h = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final b5 f40126f;

    /* renamed from: g  reason: collision with root package name */
    private int f40127g;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinLabel(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        b5 a8 = b5.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f40126f = a8;
        this.f40127g = -1;
        setBackground(a6.a(f2.o(context, R$drawable.bg_gray_14dp_rounded_corners), f2.b(context, R$color.purple_500)));
    }

    public /* synthetic */ PinLabel(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final void setConfig(b config) {
        Intrinsics.f(config, "config");
        throw null;
    }
}
