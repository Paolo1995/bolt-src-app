package j$.util.stream;

import j$.util.Collection$EL;
import j$.util.InterfaceC0106a;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class J0 implements F0 {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f50427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J0(Collection collection) {
        this.f50427a = collection;
    }

    @Override // j$.util.stream.F0
    public final F0 a(int i8) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.F0
    public final long count() {
        return this.f50427a.size();
    }

    @Override // j$.util.stream.F0
    public final void forEach(Consumer consumer) {
        Collection$EL.a(this.f50427a, consumer);
    }

    @Override // j$.util.stream.F0
    public final void i(Object[] objArr, int i8) {
        for (Object obj : this.f50427a) {
            objArr[i8] = obj;
            i8++;
        }
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ int n() {
        return 0;
    }

    @Override // j$.util.stream.F0
    public final Object[] p(IntFunction intFunction) {
        Collection collection = this.f50427a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    @Override // j$.util.stream.F0
    public final /* synthetic */ F0 q(long j8, long j9, IntFunction intFunction) {
        return AbstractC0254w0.H0(this, j8, j9, intFunction);
    }

    @Override // j$.util.stream.F0
    public final Spliterator spliterator() {
        Collection collection = this.f50427a;
        return (collection instanceof InterfaceC0106a ? ((InterfaceC0106a) collection).stream() : AbstractC0254w0.u1(Collection$EL.b(collection), false)).spliterator();
    }

    public final String toString() {
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.f50427a.size()), this.f50427a);
    }
}
