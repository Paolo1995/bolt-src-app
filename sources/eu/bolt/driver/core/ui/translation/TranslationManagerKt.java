package eu.bolt.driver.core.ui.translation;

import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: TranslationManager.kt */
/* loaded from: classes5.dex */
public final class TranslationManagerKt {
    public static final /* synthetic */ String a(String str) {
        return b(str);
    }

    public static final String b(String str) {
        String F;
        String F2;
        String F3;
        F = StringsKt__StringsJVMKt.F(str, "\\'", "'", false, 4, null);
        F2 = StringsKt__StringsJVMKt.F(F, "\\\"", "\"", false, 4, null);
        F3 = StringsKt__StringsJVMKt.F(F2, "\\n", "\n", false, 4, null);
        return F3;
    }
}
