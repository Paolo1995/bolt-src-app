package eu.bolt.android.stories.utils;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import z4.b;

/* compiled from: StoriesHtmlEngine.kt */
/* loaded from: classes5.dex */
public final class StoriesHtmlEngine {

    /* renamed from: a  reason: collision with root package name */
    public static final StoriesHtmlEngine f37614a = new StoriesHtmlEngine();

    /* renamed from: b  reason: collision with root package name */
    private static Function1<? super String, ? extends CharSequence> f37615b = new Function1<String, CharSequence>() { // from class: eu.bolt.android.stories.utils.StoriesHtmlEngine$fromHtml$1
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CharSequence invoke(String source) {
            Intrinsics.f(source, "source");
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned a8 = b.a(source, 63);
                Intrinsics.e(a8, "{\n           Html.fromHt…ML_MODE_COMPACT)\n       }");
                return a8;
            }
            Spanned fromHtml = Html.fromHtml(source);
            Intrinsics.e(fromHtml, "{\n           Html.fromHtml(source)\n       }");
            return fromHtml;
        }
    };

    private StoriesHtmlEngine() {
    }

    public final Function1<String, CharSequence> a() {
        return f37615b;
    }

    public final void b(Function1<? super String, ? extends CharSequence> function1) {
        Intrinsics.f(function1, "<set-?>");
        f37615b = function1;
    }
}
