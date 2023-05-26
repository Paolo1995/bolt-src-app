package eu.bolt.driver.chat.helper;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipboardHelper.kt */
/* loaded from: classes5.dex */
public final class ClipboardHelper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f40412b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ClipboardManager f40413a;

    /* compiled from: ClipboardHelper.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ClipboardHelper a(Context context) {
            Intrinsics.f(context, "context");
            return new ClipboardHelper(context);
        }
    }

    public ClipboardHelper(Context context) {
        Intrinsics.f(context, "context");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.f40413a = (ClipboardManager) systemService;
    }

    public final void a(CharSequence charSequence) {
        this.f40413a.setPrimaryClip(ClipData.newPlainText(null, charSequence));
    }
}
