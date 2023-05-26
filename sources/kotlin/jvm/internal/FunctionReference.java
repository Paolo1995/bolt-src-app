package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* loaded from: classes5.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {

    /* renamed from: m  reason: collision with root package name */
    private final int f51006m;

    /* renamed from: n  reason: collision with root package name */
    private final int f51007n;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FunctionReference(int r9, java.lang.Object r10, java.lang.Class r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r8 = this;
            r0 = r14 & 1
            r1 = 1
            if (r0 != r1) goto L7
            r7 = 1
            goto L9
        L7:
            r0 = 0
            r7 = 0
        L9:
            r2 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            r8.f51006m = r9
            int r9 = r14 >> 1
            r8.f51007n = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.FunctionReference.<init>(int, java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable d() {
        return Reflection.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (getName().equals(functionReference.getName()) && i().equals(functionReference.i()) && this.f51007n == functionReference.f51007n && this.f51006m == functionReference.f51006m && Intrinsics.a(e(), functionReference.e()) && Intrinsics.a(g(), functionReference.g())) {
                return true;
            }
            return false;
        } else if (!(obj instanceof KFunction)) {
            return false;
        } else {
            return obj.equals(c());
        }
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f51006m;
    }

    public int hashCode() {
        int hashCode;
        if (g() == null) {
            hashCode = 0;
        } else {
            hashCode = g().hashCode() * 31;
        }
        return ((hashCode + getName().hashCode()) * 31) + i().hashCode();
    }

    public String toString() {
        KCallable c8 = c();
        if (c8 != this) {
            return c8.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
