package j$.util.concurrent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s extends m {

    /* renamed from: e  reason: collision with root package name */
    s f50243e;

    /* renamed from: f  reason: collision with root package name */
    s f50244f;

    /* renamed from: g  reason: collision with root package name */
    s f50245g;

    /* renamed from: h  reason: collision with root package name */
    s f50246h;

    /* renamed from: i  reason: collision with root package name */
    boolean f50247i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(int i8, Object obj, Object obj2, s sVar, s sVar2) {
        super(i8, obj, obj2, sVar);
        this.f50243e = sVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.concurrent.m
    public final m a(int i8, Object obj) {
        return b(i8, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final s b(int i8, Object obj, Class cls) {
        int compareComparables;
        if (obj != null) {
            s sVar = this;
            do {
                s sVar2 = sVar.f50244f;
                s sVar3 = sVar.f50245g;
                int i9 = sVar.f50222a;
                if (i9 <= i8) {
                    if (i9 >= i8) {
                        Object obj2 = sVar.f50223b;
                        if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                            return sVar;
                        }
                        if (sVar2 != null) {
                            if (sVar3 != null) {
                                if ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (compareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) {
                                    s b8 = sVar3.b(i8, obj, cls);
                                    if (b8 != null) {
                                        return b8;
                                    }
                                } else if (compareComparables >= 0) {
                                    sVar2 = sVar3;
                                }
                            }
                        }
                    }
                    sVar = sVar3;
                    continue;
                }
                sVar = sVar2;
                continue;
            } while (sVar != null);
            return null;
        }
        return null;
    }
}
