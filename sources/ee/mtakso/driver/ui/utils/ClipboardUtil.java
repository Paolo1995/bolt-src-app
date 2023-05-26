package ee.mtakso.driver.ui.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardUtil.kt */
/* loaded from: classes5.dex */
public final class ClipboardUtil {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f34300b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ClipboardManager f34301a;

    /* compiled from: ClipboardUtil.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClipboardUtil a(Context context) {
            Intrinsics.f(context, "context");
            return new ClipboardUtil(context);
        }
    }

    public ClipboardUtil(Context context) {
        Intrinsics.f(context, "context");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.f34301a = (ClipboardManager) systemService;
    }

    public final void a(CharSequence charSequence) {
        this.f34301a.setPrimaryClip(ClipData.newPlainText(null, charSequence));
    }
}
