package j$.util.stream;

import j$.util.AbstractC0156n;
import j$.util.Collection$EL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class C2 extends AbstractC0248u2 {

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f50377d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2(InterfaceC0193g2 interfaceC0193g2, Comparator comparator) {
        super(interfaceC0193g2, comparator);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.f50377d.add(obj);
    }

    @Override // j$.util.stream.InterfaceC0193g2
    public final void e(long j8) {
        if (j8 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.f50377d = j8 >= 0 ? new ArrayList((int) j8) : new ArrayList();
    }

    @Override // j$.util.stream.AbstractC0174c2, j$.util.stream.InterfaceC0193g2
    public final void end() {
        AbstractC0156n.m(this.f50377d, this.f50687b);
        this.f50557a.e(this.f50377d.size());
        if (this.f50688c) {
            Iterator it = this.f50377d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (this.f50557a.g()) {
                    break;
                }
                this.f50557a.accept((InterfaceC0193g2) next);
            }
        } else {
            ArrayList arrayList = this.f50377d;
            InterfaceC0193g2 interfaceC0193g2 = this.f50557a;
            interfaceC0193g2.getClass();
            Collection$EL.a(arrayList, new C0161a(3, interfaceC0193g2));
        }
        this.f50557a.end();
        this.f50377d = null;
    }
}
