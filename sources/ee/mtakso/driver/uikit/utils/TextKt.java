package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
/* loaded from: classes5.dex */
public final class TextKt {
    public static final CharSequence a(Text text, Context context) {
        Intrinsics.f(text, "<this>");
        Intrinsics.f(context, "context");
        if (text instanceof Text.Resource) {
            Text.Resource resource = (Text.Resource) text;
            int b8 = resource.b();
            Object[] array = resource.a().toArray(new Object[0]);
            String string = context.getString(b8, Arrays.copyOf(array, array.length));
            Intrinsics.e(string, "context.getString(resource, *args.toTypedArray())");
            return string;
        } else if (text instanceof Text.Value) {
            return ((Text.Value) text).a();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
