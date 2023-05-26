package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import eu.bolt.verification.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w6 extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private final gg f45491f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w6(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        gg a8 = gg.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f45491f = a8;
        setId(R$id.dialogErrorContent);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        setClipToPadding(false);
        setOrientation(1);
    }

    public /* synthetic */ w6(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final void a(eu.bolt.client.design.button.a button) {
        Intrinsics.f(button, "button");
        addView(button);
    }

    public final gg getBinding() {
        return this.f45491f;
    }
}
