package j$.util.concurrent;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class m implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    final int f50222a;

    /* renamed from: b  reason: collision with root package name */
    final Object f50223b;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f50224c;

    /* renamed from: d  reason: collision with root package name */
    volatile m f50225d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i8, Object obj, Object obj2, m mVar) {
        this.f50222a = i8;
        this.f50223b = obj;
        this.f50224c = obj2;
        this.f50225d = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(int i8, Object obj) {
        Object obj2;
        if (obj != null) {
            m mVar = this;
            do {
                if (mVar.f50222a == i8 && ((obj2 = mVar.f50223b) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return mVar;
                }
                mVar = mVar.f50225d;
            } while (mVar != null);
            return null;
        }
        return null;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        Object obj2;
        Object obj3;
        return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.f50223b) || key.equals(obj2)) && (value == (obj3 = this.f50224c) || value.equals(obj3));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f50223b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f50224c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f50223b.hashCode() ^ this.f50224c.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return this.f50223b + "=" + this.f50224c;
    }
}
