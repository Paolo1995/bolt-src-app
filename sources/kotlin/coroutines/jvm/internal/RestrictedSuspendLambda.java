package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes5.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase<Object> {

    /* renamed from: f  reason: collision with root package name */
    private final int f50934f;

    public RestrictedSuspendLambda(int i8, Continuation<Object> continuation) {
        super(continuation);
        this.f50934f = i8;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f50934f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String g8 = Reflection.g(this);
            Intrinsics.e(g8, "renderLambdaToString(this)");
            return g8;
        }
        return super.toString();
    }
}
