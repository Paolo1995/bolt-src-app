package com.google.android.play.integrity.internal;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes.dex */
public final class z implements ac {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f14645c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile ac f14646a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f14647b = f14645c;

    private z(ac acVar) {
        this.f14646a = acVar;
    }

    public static ac b(ac acVar) {
        acVar.getClass();
        if (acVar instanceof z) {
            return acVar;
        }
        return new z(acVar);
    }

    @Override // com.google.android.play.integrity.internal.ac
    public final Object a() {
        Object obj = this.f14647b;
        Object obj2 = f14645c;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f14647b;
                if (obj == obj2) {
                    obj = this.f14646a.a();
                    Object obj3 = this.f14647b;
                    if (obj3 != obj2 && obj3 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f14647b = obj;
                    this.f14646a = null;
                }
            }
        }
        return obj;
    }
}
