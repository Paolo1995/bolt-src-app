package eu.bolt.verification.sdk.internal;

import android.content.Context;
import eu.bolt.verification.sdk.internal.pe;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x3 implements pe {

    /* renamed from: a  reason: collision with root package name */
    private final Context f45604a;

    /* renamed from: b  reason: collision with root package name */
    private final int f45605b;

    public x3(Context context, int i8) {
        Intrinsics.f(context, "context");
        this.f45604a = context;
        this.f45605b = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean b(x3 this$0) {
        Intrinsics.f(this$0, "this$0");
        f2.d(this$0.f45604a, this$0.f45605b, 0, 2, null);
        return Boolean.TRUE;
    }

    @Override // eu.bolt.verification.sdk.internal.pe
    public void k(List<? extends je> list) {
        pe.a.a(this, list);
    }

    @Override // eu.bolt.verification.sdk.internal.pe
    public Single<Boolean> l(List<? extends je> permissions) {
        Intrinsics.f(permissions, "permissions");
        Single<Boolean> u7 = Single.u(new Callable() { // from class: eu.bolt.verification.sdk.internal.wx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean b8;
                b8 = x3.b(x3.this);
                return b8;
            }
        });
        Intrinsics.e(u7, "fromCallable {\n         …           true\n        }");
        return u7;
    }
}
