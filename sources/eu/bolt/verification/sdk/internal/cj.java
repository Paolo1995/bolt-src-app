package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface cj {

    /* loaded from: classes5.dex */
    public static final class a {
        public static void a(cj cjVar, String slideId) {
            Intrinsics.f(slideId, "slideId");
        }

        public static /* synthetic */ void b(cj cjVar, String str, Throwable th, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStoryLoadingFinished");
            }
            if ((i8 & 2) != 0) {
                th = null;
            }
            cjVar.l(str, th);
        }
    }

    void c(String str);

    void f(String str);

    void i(String str);

    void j(String str);

    void k(String str, Throwable th);

    void l(String str, Throwable th);
}
