package j$.time.format;

import j$.time.ZoneId;

/* loaded from: classes2.dex */
final class t implements j$.time.temporal.l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j$.time.chrono.b f50042a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ j$.time.temporal.l f50043b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j$.time.chrono.e f50044c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ZoneId f50045d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(j$.time.g gVar, j$.time.temporal.l lVar, j$.time.chrono.e eVar, ZoneId zoneId) {
        this.f50042a = gVar;
        this.f50043b = lVar;
        this.f50044c = eVar;
        this.f50045d = zoneId;
    }

    @Override // j$.time.temporal.l
    public final /* synthetic */ int e(j$.time.temporal.o oVar) {
        return j$.time.temporal.n.a(this, oVar);
    }

    @Override // j$.time.temporal.l
    public final j$.time.temporal.t h(j$.time.temporal.o oVar) {
        return (this.f50042a == null || !oVar.isDateBased()) ? this.f50043b.h(oVar) : ((j$.time.g) this.f50042a).h(oVar);
    }

    @Override // j$.time.temporal.l
    public final boolean k(j$.time.temporal.o oVar) {
        return (this.f50042a == null || !oVar.isDateBased()) ? this.f50043b.k(oVar) : ((j$.time.g) this.f50042a).k(oVar);
    }

    @Override // j$.time.temporal.l
    public final long n(j$.time.temporal.o oVar) {
        return (this.f50042a == null || !oVar.isDateBased()) ? this.f50043b.n(oVar) : ((j$.time.g) this.f50042a).n(oVar);
    }

    @Override // j$.time.temporal.l
    public final Object o(j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.n.d() ? this.f50044c : qVar == j$.time.temporal.n.j() ? this.f50045d : qVar == j$.time.temporal.n.h() ? this.f50043b.o(qVar) : qVar.c(this);
    }
}
