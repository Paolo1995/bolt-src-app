package j$.time;

/* loaded from: classes2.dex */
public final /* synthetic */ class h implements j$.time.temporal.q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50066a;

    @Override // j$.time.temporal.q
    public final Object c(j$.time.temporal.l lVar) {
        switch (this.f50066a) {
            case 0:
                return LocalDateTime.r(lVar);
            default:
                return OffsetDateTime.q(lVar);
        }
    }
}
