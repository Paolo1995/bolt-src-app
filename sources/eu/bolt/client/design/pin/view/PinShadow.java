package eu.bolt.client.design.pin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import eu.bolt.verification.sdk.internal.ve;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class PinShadow extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final a f40146h = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final ve f40147f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f40148g;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinShadow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinShadow(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        ve a8 = ve.a(LayoutInflater.from(context), this);
        Intrinsics.e(a8, "inflate(LayoutInflater.from(context), this)");
        this.f40147f = a8;
        this.f40148g = true;
    }

    public /* synthetic */ PinShadow(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
