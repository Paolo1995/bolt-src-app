package j$.time.temporal;

import j$.time.ZoneId;
import j$.time.ZoneOffset;

/* loaded from: classes2.dex */
public final /* synthetic */ class p implements q, m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50110a;

    public /* synthetic */ p(int i8) {
        this.f50110a = i8;
    }

    @Override // j$.time.temporal.q
    public Object c(l lVar) {
        switch (this.f50110a) {
            case 0:
                return (ZoneId) lVar.o(n.f50103a);
            case 1:
                return (j$.time.chrono.e) lVar.o(n.f50104b);
            case 2:
                return (r) lVar.o(n.f50105c);
            case 3:
                a aVar = a.OFFSET_SECONDS;
                if (lVar.k(aVar)) {
                    return ZoneOffset.u(lVar.e(aVar));
                }
                return null;
            case 4:
                ZoneId zoneId = (ZoneId) lVar.o(n.f50103a);
                return zoneId != null ? zoneId : (ZoneId) lVar.o(n.f50106d);
            case 5:
                a aVar2 = a.EPOCH_DAY;
                if (lVar.k(aVar2)) {
                    return j$.time.g.z(lVar.n(aVar2));
                }
                return null;
            default:
                a aVar3 = a.NANO_OF_DAY;
                if (lVar.k(aVar3)) {
                    return j$.time.k.y(lVar.n(aVar3));
                }
                return null;
        }
    }

    @Override // j$.time.temporal.m
    public k j(k kVar) {
        int i8 = this.f50110a;
        int e8 = kVar.e(a.DAY_OF_WEEK);
        if (e8 == i8) {
            return kVar;
        }
        int i9 = e8 - i8;
        return kVar.i(i9 >= 0 ? 7 - i9 : -i9, b.DAYS);
    }
}
