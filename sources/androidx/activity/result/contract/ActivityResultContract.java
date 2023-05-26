package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultContract.kt */
/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: ActivityResultContract.kt */
    /* loaded from: classes.dex */
    public static final class SynchronousResult<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f812a;

        public SynchronousResult(T t7) {
            this.f812a = t7;
        }

        public final T a() {
            return this.f812a;
        }
    }

    public abstract Intent createIntent(Context context, I i8);

    public SynchronousResult<O> getSynchronousResult(Context context, I i8) {
        Intrinsics.f(context, "context");
        return null;
    }

    public abstract O parseResult(int i8, Intent intent);
}
