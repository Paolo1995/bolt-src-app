package j$.util.stream;

import j$.util.Spliterator;
import java.util.Iterator;
import java.util.stream.BaseStream;

/* renamed from: j$.util.stream.g  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0190g implements InterfaceC0198i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaseStream f50582a;

    private /* synthetic */ C0190g(BaseStream baseStream) {
        this.f50582a = baseStream;
    }

    public static /* synthetic */ InterfaceC0198i y(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof C0194h ? ((C0194h) baseStream).f50585a : new C0190g(baseStream);
    }

    @Override // j$.util.stream.InterfaceC0198i, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f50582a.close();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ boolean isParallel() {
        return this.f50582a.isParallel();
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Iterator iterator() {
        return this.f50582a.iterator();
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i onClose(Runnable runnable) {
        return y(this.f50582a.onClose(runnable));
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i parallel() {
        return y(this.f50582a.parallel());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ InterfaceC0198i sequential() {
        return y(this.f50582a.sequential());
    }

    @Override // j$.util.stream.InterfaceC0198i, j$.util.stream.G
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.N.e(this.f50582a.spliterator());
    }

    @Override // j$.util.stream.InterfaceC0198i
    public final /* synthetic */ InterfaceC0198i unordered() {
        return y(this.f50582a.unordered());
    }
}
