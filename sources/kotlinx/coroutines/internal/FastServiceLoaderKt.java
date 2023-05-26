package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes5.dex */
public final class FastServiceLoaderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f51790a;

    static {
        Object b8;
        try {
            Result.Companion companion = Result.f50818g;
            b8 = Result.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f50818g;
            b8 = Result.b(ResultKt.a(th));
        }
        f51790a = Result.h(b8);
    }

    public static final boolean a() {
        return f51790a;
    }
}
