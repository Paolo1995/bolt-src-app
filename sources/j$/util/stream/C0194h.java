package j$.util.stream;

import j$.util.Spliterator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;

/* renamed from: j$.util.stream.h  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0194h implements BaseStream {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InterfaceC0198i f50585a;

    private /* synthetic */ C0194h(InterfaceC0198i interfaceC0198i) {
        this.f50585a = interfaceC0198i;
    }

    public static /* synthetic */ BaseStream y(InterfaceC0198i interfaceC0198i) {
        if (interfaceC0198i == null) {
            return null;
        }
        return interfaceC0198i instanceof C0190g ? ((C0190g) interfaceC0198i).f50582a : new C0194h(interfaceC0198i);
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f50585a.close();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.f50585a.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return this.f50585a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return y(this.f50585a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return y(this.f50585a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return y(this.f50585a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.f50585a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return y(this.f50585a.unordered());
    }
}
