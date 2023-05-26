package eu.bolt.android.stories.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import eu.bolt.kalev.Kalev;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabLauncher.kt */
/* loaded from: classes5.dex */
public final class CustomTabLauncher {

    /* renamed from: a  reason: collision with root package name */
    public static final CustomTabLauncher f37613a = new CustomTabLauncher();

    private CustomTabLauncher() {
    }

    public static /* synthetic */ void b(CustomTabLauncher customTabLauncher, Context context, String str, int i8, Integer num, Function1 function1, int i9, Object obj) {
        int i10;
        if ((i9 & 4) != 0) {
            i10 = -1;
        } else {
            i10 = i8;
        }
        if ((i9 & 8) != 0) {
            num = null;
        }
        customTabLauncher.a(context, str, i10, num, function1);
    }

    public final void a(Context context, String url, int i8, Integer num, Function1<? super Exception, Unit> function1) {
        Intrinsics.f(context, "context");
        Intrinsics.f(url, "url");
        CustomTabColorSchemeParams a8 = new CustomTabColorSchemeParams.Builder().b(i8).a();
        Intrinsics.e(a8, "Builder()\n            .s…lor)\n            .build()");
        CustomTabsIntent a9 = new CustomTabsIntent.Builder().b(a8).a();
        Intrinsics.e(a9, "Builder()\n            .s…ams)\n            .build()");
        if (num != null) {
            a9.f2353a.addFlags(num.intValue());
        }
        try {
            a9.a(context, Uri.parse(url));
        } catch (ActivityNotFoundException e8) {
            Kalev.e(e8, "Story: Failed to open chrome tab");
            if (function1 != null) {
                function1.invoke(e8);
            }
        }
    }
}
