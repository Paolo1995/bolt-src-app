package eu.bolt.verification.sdk.internal;

import android.graphics.Bitmap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public interface t9 {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(t9 t9Var, String str, Function1 function1, Function1 function12, boolean z7, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAsync");
            }
            if ((i8 & 8) != 0) {
                z7 = true;
            }
            t9Var.a(str, function1, function12, z7);
        }
    }

    void a(String str, Function1<? super Bitmap, Unit> function1, Function1<? super Throwable, Unit> function12, boolean z7);
}
