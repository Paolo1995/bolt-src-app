package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes5.dex */
public final class HandlerDispatcherKt {

    /* renamed from: a  reason: collision with root package name */
    public static final HandlerDispatcher f51361a;
    private static volatile Choreographer choreographer;

    static {
        Object b8;
        HandlerDispatcher handlerDispatcher = null;
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(new HandlerContext(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        if (!Result.g(b8)) {
            handlerDispatcher = b8;
        }
        f51361a = handlerDispatcher;
    }

    public static final Handler a(Looper looper, boolean z7) {
        if (z7) {
            if (Build.VERSION.SDK_INT >= 28) {
                Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
                if (invoke != null) {
                    return (Handler) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
            }
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
