package j$.util.concurrent;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class i extends AbstractC0110b implements Iterator, Enumeration, j$.util.Iterator {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f50216k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(m[] mVarArr, int i8, int i9, ConcurrentHashMap concurrentHashMap, int i10) {
        super(mVarArr, i8, i9, concurrentHashMap);
        this.f50216k = i10;
    }

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        switch (this.f50216k) {
            case 0:
                Iterator.CC.$default$forEachRemaining(this, consumer);
                return;
            default:
                Iterator.CC.$default$forEachRemaining(this, consumer);
                return;
        }
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        switch (this.f50216k) {
            case 0:
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                return;
            default:
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
                return;
        }
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Object next() {
        switch (this.f50216k) {
            case 0:
                m mVar = this.f50231b;
                if (mVar != null) {
                    Object obj = mVar.f50223b;
                    this.f50211j = mVar;
                    e();
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                m mVar2 = this.f50231b;
                if (mVar2 != null) {
                    Object obj2 = mVar2.f50224c;
                    this.f50211j = mVar2;
                    e();
                    return obj2;
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Enumeration
    public final Object nextElement() {
        switch (this.f50216k) {
            case 0:
                return next();
            default:
                return next();
        }
    }
}
