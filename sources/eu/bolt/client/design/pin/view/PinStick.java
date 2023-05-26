package eu.bolt.client.design.pin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.v9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class PinStick extends DesignImageView {
    private static final a E = new a(null);
    @Deprecated
    private static final aa.f F = new aa.f(20.0f, 4.0f);
    private v9 D;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinStick(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinStick(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public /* synthetic */ PinStick(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final void setConfig(b config) {
        Intrinsics.f(config, "config");
        throw null;
    }

    public final void setStickLoadingListener(v9 v9Var) {
        this.D = v9Var;
    }
}
