package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import eu.bolt.verification.sdk.internal.q4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x0 extends e4 {

    /* renamed from: l0  reason: collision with root package name */
    private final dg f45600l0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        dg b8 = dg.b(LayoutInflater.from(context));
        Intrinsics.e(b8, "inflate(LayoutInflater.from(context))");
        this.f45600l0 = b8;
        B0(b8.getRoot());
        q4.a.a(this, false, false, 2, null);
    }

    public /* synthetic */ x0(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final dg getBinding() {
        return this.f45600l0;
    }
}
