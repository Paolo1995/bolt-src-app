package j$.util.concurrent;

import j$.util.Collection$CC;
import j$.util.InterfaceC0106a;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.stream.Stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t extends c implements InterfaceC0106a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ConcurrentHashMap concurrentHashMap) {
        super(concurrentHashMap);
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.concurrent.c, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f50212a.containsValue(obj);
    }

    @Override // j$.util.InterfaceC0106a
    public final void forEach(Consumer consumer) {
        consumer.getClass();
        m[] mVarArr = this.f50212a.table;
        if (mVarArr == null) {
            return;
        }
        q qVar = new q(mVarArr, mVarArr.length, 0, mVarArr.length);
        while (true) {
            m e8 = qVar.e();
            if (e8 == null) {
                return;
            }
            consumer.accept(e8.f50224c);
        }
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // j$.util.concurrent.c, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f50212a;
        m[] mVarArr = concurrentHashMap.table;
        int length = mVarArr == null ? 0 : mVarArr.length;
        return new i(mVarArr, length, length, concurrentHashMap, 1);
    }

    @Override // java.util.Collection
    public final /* synthetic */ Stream parallelStream() {
        return Stream.Wrapper.convert(Collection$CC.$default$parallelStream(this));
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        AbstractC0110b abstractC0110b;
        if (obj != null) {
            Iterator it = iterator();
            do {
                abstractC0110b = (AbstractC0110b) it;
                if (!abstractC0110b.hasNext()) {
                    return false;
                }
            } while (!obj.equals(((i) it).next()));
            abstractC0110b.remove();
            return true;
        }
        return false;
    }

    @Override // j$.util.InterfaceC0106a
    public final /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection$CC.$default$removeIf(this, predicate);
    }

    @Override // java.util.Collection
    public final /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
        return Collection$CC.$default$removeIf(this, Predicate.VivifiedWrapper.convert(predicate));
    }

    @Override // java.util.Collection, java.lang.Iterable, j$.util.InterfaceC0106a, j$.util.List
    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f50212a;
        long sumCount = concurrentHashMap.sumCount();
        m[] mVarArr = concurrentHashMap.table;
        int length = mVarArr == null ? 0 : mVarArr.length;
        return new k(mVarArr, length, 0, length, sumCount >= 0 ? sumCount : 0L, 1);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    @Override // java.util.Collection, j$.util.InterfaceC0106a
    public final /* synthetic */ j$.util.stream.Stream stream() {
        return Collection$CC.$default$stream(this);
    }

    @Override // java.util.Collection
    public final /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(Collection$CC.$default$stream(this));
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection$CC.$default$toArray(this, IntFunction.VivifiedWrapper.convert(intFunction));
    }
}
