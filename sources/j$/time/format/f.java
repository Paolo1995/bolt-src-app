package j$.time.format;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private final g[] f50000a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50001b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ArrayList arrayList, boolean z7) {
        this((g[]) arrayList.toArray(new g[arrayList.size()]), z7);
    }

    f(g[] gVarArr, boolean z7) {
        this.f50000a = gVarArr;
        this.f50001b = z7;
    }

    public final f a() {
        return !this.f50001b ? this : new f(this.f50000a, false);
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        int length = sb.length();
        if (this.f50001b) {
            uVar.g();
        }
        try {
            for (g gVar : this.f50000a) {
                if (!gVar.d(uVar, sb)) {
                    sb.setLength(length);
                    return true;
                }
            }
            if (this.f50001b) {
                uVar.a();
            }
            return true;
        } finally {
            if (this.f50001b) {
                uVar.a();
            }
        }
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        if (!this.f50001b) {
            for (g gVar : this.f50000a) {
                i8 = gVar.e(sVar, charSequence, i8);
                if (i8 < 0) {
                    break;
                }
            }
            return i8;
        }
        sVar.q();
        int i9 = i8;
        for (g gVar2 : this.f50000a) {
            i9 = gVar2.e(sVar, charSequence, i9);
            if (i9 < 0) {
                sVar.e(false);
                return i8;
            }
        }
        sVar.e(true);
        return i9;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f50000a != null) {
            sb.append(this.f50001b ? "[" : "(");
            for (g gVar : this.f50000a) {
                sb.append(gVar);
            }
            sb.append(this.f50001b ? "]" : ")");
        }
        return sb.toString();
    }
}
