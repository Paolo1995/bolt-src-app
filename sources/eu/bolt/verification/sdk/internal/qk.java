package eu.bolt.verification.sdk.internal;

import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public final class qk {
    public static final boolean a(CharSequence charSequence) {
        boolean z7;
        boolean y7;
        if (charSequence != null) {
            y7 = StringsKt__StringsJVMKt.y(charSequence);
            if (!y7) {
                z7 = false;
                return !z7;
            }
        }
        z7 = true;
        return !z7;
    }

    public static final boolean b(String str) {
        boolean z7;
        boolean y7;
        if (str != null) {
            y7 = StringsKt__StringsJVMKt.y(str);
            if (!y7) {
                z7 = false;
                return !z7;
            }
        }
        z7 = true;
        return !z7;
    }
}
