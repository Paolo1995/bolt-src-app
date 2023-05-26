package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {

    /* renamed from: f  reason: collision with root package name */
    protected final Object f50976f;

    /* renamed from: g  reason: collision with root package name */
    private final Class f50977g;

    /* renamed from: h  reason: collision with root package name */
    private final String f50978h;

    /* renamed from: i  reason: collision with root package name */
    private final String f50979i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f50980j;

    /* renamed from: k  reason: collision with root package name */
    private final int f50981k;

    /* renamed from: l  reason: collision with root package name */
    private final int f50982l;

    public AdaptedFunctionReference(int i8, Object obj, Class cls, String str, String str2, int i9) {
        boolean z7;
        this.f50976f = obj;
        this.f50977g = cls;
        this.f50978h = str;
        this.f50979i = str2;
        if ((i9 & 1) == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f50980j = z7;
        this.f50981k = i8;
        this.f50982l = i9 >> 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.f50980j == adaptedFunctionReference.f50980j && this.f50981k == adaptedFunctionReference.f50981k && this.f50982l == adaptedFunctionReference.f50982l && Intrinsics.a(this.f50976f, adaptedFunctionReference.f50976f) && Intrinsics.a(this.f50977g, adaptedFunctionReference.f50977g) && this.f50978h.equals(adaptedFunctionReference.f50978h) && this.f50979i.equals(adaptedFunctionReference.f50979i)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f50981k;
    }

    public int hashCode() {
        int i8;
        int i9;
        Object obj = this.f50976f;
        int i10 = 0;
        if (obj != null) {
            i8 = obj.hashCode();
        } else {
            i8 = 0;
        }
        int i11 = i8 * 31;
        Class cls = this.f50977g;
        if (cls != null) {
            i10 = cls.hashCode();
        }
        int hashCode = (((((i11 + i10) * 31) + this.f50978h.hashCode()) * 31) + this.f50979i.hashCode()) * 31;
        if (this.f50980j) {
            i9 = 1231;
        } else {
            i9 = 1237;
        }
        return ((((hashCode + i9) * 31) + this.f50981k) * 31) + this.f50982l;
    }

    public String toString() {
        return Reflection.g(this);
    }
}
