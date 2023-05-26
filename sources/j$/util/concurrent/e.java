package j$.util.concurrent;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class e extends AbstractC0110b implements Iterator, j$.util.Iterator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(m[] mVarArr, int i8, int i9, ConcurrentHashMap concurrentHashMap) {
        super(mVarArr, i8, i9, concurrentHashMap);
    }

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public final Object next() {
        m mVar = this.f50231b;
        if (mVar != null) {
            Object obj = mVar.f50223b;
            Object obj2 = mVar.f50224c;
            this.f50211j = mVar;
            e();
            return new l(obj, obj2, this.f50210i);
        }
        throw new NoSuchElementException();
    }
}
