package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes3.dex */
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final int f16193a;

    /* renamed from: b  reason: collision with root package name */
    private final StackTraceTrimmingStrategy[] f16194b;

    /* renamed from: c  reason: collision with root package name */
    private final MiddleOutStrategy f16195c;

    public MiddleOutFallbackStrategy(int i8, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f16193a = i8;
        this.f16194b = stackTraceTrimmingStrategyArr;
        this.f16195c = new MiddleOutStrategy(i8);
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr;
        if (stackTraceElementArr.length <= this.f16193a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f16194b) {
            if (stackTraceElementArr2.length <= this.f16193a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.a(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.f16193a) {
            return this.f16195c.a(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
