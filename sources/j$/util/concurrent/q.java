package j$.util.concurrent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    m[] f50230a;

    /* renamed from: b  reason: collision with root package name */
    m f50231b = null;

    /* renamed from: c  reason: collision with root package name */
    p f50232c;

    /* renamed from: d  reason: collision with root package name */
    p f50233d;

    /* renamed from: e  reason: collision with root package name */
    int f50234e;

    /* renamed from: f  reason: collision with root package name */
    int f50235f;

    /* renamed from: g  reason: collision with root package name */
    int f50236g;

    /* renamed from: h  reason: collision with root package name */
    final int f50237h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m[] mVarArr, int i8, int i9, int i10) {
        this.f50230a = mVarArr;
        this.f50237h = i8;
        this.f50234e = i9;
        this.f50235f = i9;
        this.f50236g = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m e() {
        m[] mVarArr;
        int length;
        int i8;
        p pVar;
        m mVar = this.f50231b;
        if (mVar != null) {
            mVar = mVar.f50225d;
        }
        while (mVar == null) {
            if (this.f50235f >= this.f50236g || (mVarArr = this.f50230a) == null || (length = mVarArr.length) <= (i8 = this.f50234e) || i8 < 0) {
                this.f50231b = null;
                return null;
            }
            m tabAt = ConcurrentHashMap.tabAt(mVarArr, i8);
            if (tabAt == null || tabAt.f50222a >= 0) {
                mVar = tabAt;
            } else if (tabAt instanceof h) {
                this.f50230a = ((h) tabAt).f50215e;
                p pVar2 = this.f50233d;
                if (pVar2 != null) {
                    this.f50233d = pVar2.f50229d;
                } else {
                    pVar2 = new p();
                }
                pVar2.f50228c = mVarArr;
                pVar2.f50226a = length;
                pVar2.f50227b = i8;
                pVar2.f50229d = this.f50232c;
                this.f50232c = pVar2;
                mVar = null;
            } else {
                mVar = tabAt instanceof r ? ((r) tabAt).f50241f : null;
            }
            if (this.f50232c != null) {
                while (true) {
                    pVar = this.f50232c;
                    if (pVar == null) {
                        break;
                    }
                    int i9 = this.f50234e;
                    int i10 = pVar.f50226a;
                    int i11 = i9 + i10;
                    this.f50234e = i11;
                    if (i11 < length) {
                        break;
                    }
                    this.f50234e = pVar.f50227b;
                    this.f50230a = pVar.f50228c;
                    pVar.f50228c = null;
                    p pVar3 = pVar.f50229d;
                    pVar.f50229d = this.f50233d;
                    this.f50232c = pVar3;
                    this.f50233d = pVar;
                    length = i10;
                }
                if (pVar == null) {
                    int i12 = this.f50234e + this.f50237h;
                    this.f50234e = i12;
                    if (i12 >= length) {
                        int i13 = this.f50235f + 1;
                        this.f50235f = i13;
                        this.f50234e = i13;
                    }
                }
            } else {
                int i14 = i8 + this.f50237h;
                this.f50234e = i14;
                if (i14 >= length) {
                    int i15 = this.f50235f + 1;
                    this.f50235f = i15;
                    this.f50234e = i15;
                }
            }
        }
        this.f50231b = mVar;
        return mVar;
    }
}
