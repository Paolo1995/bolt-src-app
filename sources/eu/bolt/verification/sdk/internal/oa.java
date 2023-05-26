package eu.bolt.verification.sdk.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class oa {
    public static final CustomTabsIntent a(CustomTabsIntent customTabsIntent, Context context, Uri uri, Function0<Unit> function0) {
        Intrinsics.f(customTabsIntent, "<this>");
        Intrinsics.f(context, "context");
        Intrinsics.f(uri, "uri");
        try {
            customTabsIntent.a(context, uri);
        } catch (ActivityNotFoundException unused) {
            if (function0 != null) {
                function0.invoke();
            }
        }
        return customTabsIntent;
    }
}
