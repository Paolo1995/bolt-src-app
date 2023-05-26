package ee.mtakso.driver.ui.screens.navigator_chooser;

import android.content.Intent;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import ee.mtakso.driver.utils.AppResolver;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationOption.kt */
/* loaded from: classes3.dex */
public final class NavigationOptionKt {
    public static final boolean a(NavigationOption navigationOption, AppResolver appResolver) {
        String str;
        Intrinsics.f(navigationOption, "<this>");
        Intrinsics.f(appResolver, "appResolver");
        NavigationOption.IntentDataHolder intentDataHolder = navigationOption.getIntentDataHolder();
        String str2 = null;
        if (intentDataHolder != null) {
            str = intentDataHolder.getAction();
        } else {
            str = null;
        }
        Intent intent = new Intent(str);
        NavigationOption.IntentDataHolder intentDataHolder2 = navigationOption.getIntentDataHolder();
        if (intentDataHolder2 != null) {
            str2 = intentDataHolder2.getPackageName();
        }
        intent.setPackage(str2);
        return appResolver.c(intent);
    }
}
