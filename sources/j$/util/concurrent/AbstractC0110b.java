package j$.util.concurrent;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.concurrent.b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0110b extends q {

    /* renamed from: i  reason: collision with root package name */
    final ConcurrentHashMap f50210i;

    /* renamed from: j  reason: collision with root package name */
    m f50211j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0110b(m[] mVarArr, int i8, int i9, ConcurrentHashMap concurrentHashMap) {
        super(mVarArr, i8, 0, i9);
        this.f50210i = concurrentHashMap;
        e();
    }

    public final boolean hasMoreElements() {
        return this.f50231b != null;
    }

    public final boolean hasNext() {
        return this.f50231b != null;
    }

    public final void remove() {
        m mVar = this.f50211j;
        if (mVar == null) {
            throw new IllegalStateException();
        }
        this.f50211j = null;
        this.f50210i.replaceNode(mVar.f50223b, null, null);
    }
}
