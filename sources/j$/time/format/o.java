package j$.time.format;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o implements g {

    /* renamed from: a  reason: collision with root package name */
    private final String f50023a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str) {
        this.f50023a = str;
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        sb.append(this.f50023a);
        return true;
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        if (i8 > charSequence.length() || i8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.f50023a;
        return !sVar.r(charSequence, i8, str, 0, str.length()) ? ~i8 : this.f50023a.length() + i8;
    }

    public final String toString() {
        String replace = this.f50023a.replace("'", "''");
        return "'" + replace + "'";
    }
}
