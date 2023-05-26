package j$.time.format;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l() {
        super("", null, null, 0);
    }

    private l(String str, String str2, m mVar) {
        super(str, str2, mVar, 0);
    }

    @Override // j$.time.format.m
    protected final boolean b(char c8, char c9) {
        return s.b(c8, c9);
    }

    @Override // j$.time.format.m
    protected final m d(String str, String str2, m mVar) {
        return new l(str, str2, mVar);
    }

    @Override // j$.time.format.m
    protected final boolean f(CharSequence charSequence, int i8, int i9) {
        int length = this.f50017a.length();
        if (length > i9 - i8) {
            return false;
        }
        int i10 = 0;
        while (true) {
            int i11 = length - 1;
            if (length <= 0) {
                return true;
            }
            int i12 = i10 + 1;
            int i13 = i8 + 1;
            if (!s.b(this.f50017a.charAt(i10), charSequence.charAt(i8))) {
                return false;
            }
            i8 = i13;
            length = i11;
            i10 = i12;
        }
    }
}
