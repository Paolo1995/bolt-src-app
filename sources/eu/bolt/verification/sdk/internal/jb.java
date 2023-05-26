package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import eu.bolt.logger.Logger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class jb {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f43681a;

    /* renamed from: b  reason: collision with root package name */
    private final Activity f43682b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f43683c;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function0<InputMethodManager> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final InputMethodManager invoke() {
            InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(jb.this.f43682b, InputMethodManager.class);
            if (inputMethodManager == null) {
                jb.this.f43681a.d("failed to get input method manager");
            }
            return inputMethodManager;
        }
    }

    public jb(Logger logger, Activity activity) {
        Lazy a8;
        Intrinsics.f(logger, "logger");
        Intrinsics.f(activity, "activity");
        this.f43681a = logger;
        this.f43682b = activity;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new a());
        this.f43683c = a8;
    }

    private final InputMethodManager b() {
        return (InputMethodManager) this.f43683c.getValue();
    }

    public final void c(View view, boolean z7) {
        this.f43681a.b("Close keyboard");
        if (view == null) {
            try {
                view = this.f43682b.getCurrentFocus();
                if (view == null) {
                    view = this.f43682b.getWindow().getDecorView();
                    Intrinsics.e(view, "activity.window.decorView");
                }
            } catch (Exception e8) {
                this.f43681a.a(e8, "Error while closing keyboard");
                return;
            }
        }
        if (z7) {
            view.clearFocus();
        }
        if (view.getWindowToken() == null) {
            throw new NullPointerException("Window token is null");
        }
        InputMethodManager b8 = b();
        if (b8 != null) {
            b8.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
