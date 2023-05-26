package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class eb implements db {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f42753a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f42754b;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function0<InputMethodManager> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final InputMethodManager invoke() {
            InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(eb.this.f42753a, InputMethodManager.class);
            if (inputMethodManager == null) {
                Timber.f53064a.a("failed to get input method manager", new Object[0]);
            }
            return inputMethodManager;
        }
    }

    @Inject
    public eb(Activity activity) {
        Lazy a8;
        Intrinsics.f(activity, "activity");
        this.f42753a = activity;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new a());
        this.f42754b = a8;
    }

    private final InputMethodManager c() {
        return (InputMethodManager) this.f42754b.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        if (r2 == null) goto L2;
     */
    @Override // eu.bolt.verification.sdk.internal.db
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.view.View r2, boolean r3) {
        /*
            r1 = this;
            if (r2 == 0) goto Lc
            boolean r0 = r2.hasFocus()     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L9
            goto La
        L9:
            r2 = 0
        La:
            if (r2 != 0) goto L23
        Lc:
            android.app.Activity r2 = r1.f42753a     // Catch: java.lang.Exception -> L39
            android.view.View r2 = r2.getCurrentFocus()     // Catch: java.lang.Exception -> L39
            if (r2 != 0) goto L23
            android.app.Activity r2 = r1.f42753a     // Catch: java.lang.Exception -> L39
            android.view.Window r2 = r2.getWindow()     // Catch: java.lang.Exception -> L39
            android.view.View r2 = r2.getDecorView()     // Catch: java.lang.Exception -> L39
            java.lang.String r0 = "activity.window.decorView"
            kotlin.jvm.internal.Intrinsics.e(r2, r0)     // Catch: java.lang.Exception -> L39
        L23:
            if (r3 == 0) goto L28
            r2.clearFocus()     // Catch: java.lang.Exception -> L39
        L28:
            android.os.IBinder r2 = r2.getWindowToken()     // Catch: java.lang.Exception -> L39
            if (r2 == 0) goto L3f
            android.view.inputmethod.InputMethodManager r3 = r1.c()     // Catch: java.lang.Exception -> L39
            if (r3 == 0) goto L3f
            r0 = 0
            r3.hideSoftInputFromWindow(r2, r0)     // Catch: java.lang.Exception -> L39
            goto L3f
        L39:
            r2 = move-exception
            timber.log.Timber$Forest r3 = timber.log.Timber.f53064a
            r3.b(r2)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.eb.a(android.view.View, boolean):void");
    }
}
