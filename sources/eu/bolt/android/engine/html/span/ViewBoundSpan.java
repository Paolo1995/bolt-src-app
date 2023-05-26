package eu.bolt.android.engine.html.span;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewBoundSpan.kt */
/* loaded from: classes5.dex */
public interface ViewBoundSpan {

    /* compiled from: ViewBoundSpan.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void a(ViewBoundSpan viewBoundSpan, TextView textView) {
            Intrinsics.f(viewBoundSpan, "this");
            Intrinsics.f(textView, "textView");
        }
    }

    void a(TextView textView);

    void b(TextView textView);
}
