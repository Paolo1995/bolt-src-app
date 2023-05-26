package ee.mtakso.driver.ui.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardUtils.kt */
/* loaded from: classes5.dex */
public final class KeyboardUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyboardUtils f34304a = new KeyboardUtils();

    private KeyboardUtils() {
    }

    public static /* synthetic */ void c(KeyboardUtils keyboardUtils, View view, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        keyboardUtils.b(view, z7);
    }

    public final boolean a(View view) {
        if (view == null) {
            Kalev.b("hideKeyboard View is null");
            return false;
        }
        try {
            Object systemService = view.getContext().getSystemService("input_method");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void b(View view, boolean z7) {
        Intrinsics.f(view, "view");
        Object systemService = view.getContext().getSystemService("input_method");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        view.requestFocus();
        if (z7) {
            inputMethodManager.showSoftInput(view, 1);
            inputMethodManager.toggleSoftInput(2, 1);
            return;
        }
        inputMethodManager.showSoftInput(view, 1);
    }
}
