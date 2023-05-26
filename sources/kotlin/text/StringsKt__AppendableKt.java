package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* loaded from: classes5.dex */
public class StringsKt__AppendableKt {
    public static <T> void a(Appendable appendable, T t7, Function1<? super T, ? extends CharSequence> function1) {
        boolean z7;
        Intrinsics.f(appendable, "<this>");
        if (function1 != null) {
            appendable.append(function1.invoke(t7));
            return;
        }
        if (t7 == null) {
            z7 = true;
        } else {
            z7 = t7 instanceof CharSequence;
        }
        if (z7) {
            appendable.append((CharSequence) t7);
        } else if (t7 instanceof Character) {
            appendable.append(((Character) t7).charValue());
        } else {
            appendable.append(String.valueOf(t7));
        }
    }
}
