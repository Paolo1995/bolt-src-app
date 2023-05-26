package j$.util.stream;

import java.util.Comparator;

/* renamed from: j$.util.stream.u2  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0248u2 extends AbstractC0174c2 {

    /* renamed from: b  reason: collision with root package name */
    protected final Comparator f50687b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f50688c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0248u2(InterfaceC0193g2 interfaceC0193g2, Comparator comparator) {
        super(interfaceC0193g2);
        this.f50687b = comparator;
    }

    @Override // j$.util.stream.AbstractC0174c2, j$.util.stream.InterfaceC0193g2
    public final boolean g() {
        this.f50688c = true;
        return false;
    }
}
