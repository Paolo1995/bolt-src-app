package j$.time.format;

import java.text.ParsePosition;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    protected String f50017a;

    /* renamed from: b  reason: collision with root package name */
    protected String f50018b;

    /* renamed from: c  reason: collision with root package name */
    protected char f50019c;

    /* renamed from: d  reason: collision with root package name */
    protected m f50020d;

    /* renamed from: e  reason: collision with root package name */
    protected m f50021e;

    private m(String str, String str2, m mVar) {
        this.f50017a = str;
        this.f50018b = str2;
        this.f50020d = mVar;
        this.f50019c = str.length() == 0 ? (char) 65535 : this.f50017a.charAt(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(String str, String str2, m mVar, int i8) {
        this(str, str2, mVar);
    }

    private boolean a(String str, String str2) {
        int i8 = 0;
        while (i8 < str.length() && i8 < this.f50017a.length() && b(str.charAt(i8), this.f50017a.charAt(i8))) {
            i8++;
        }
        if (i8 != this.f50017a.length()) {
            m d8 = d(this.f50017a.substring(i8), this.f50018b, this.f50020d);
            this.f50017a = str.substring(0, i8);
            this.f50020d = d8;
            if (i8 < str.length()) {
                this.f50020d.f50021e = d(str.substring(i8), str2, null);
                this.f50018b = null;
            } else {
                this.f50018b = str2;
            }
            return true;
        } else if (i8 >= str.length()) {
            this.f50018b = str2;
            return true;
        } else {
            String substring = str.substring(i8);
            for (m mVar = this.f50020d; mVar != null; mVar = mVar.f50021e) {
                if (b(mVar.f50019c, substring.charAt(0))) {
                    return mVar.a(substring, str2);
                }
            }
            m d9 = d(substring, str2, null);
            d9.f50021e = this.f50020d;
            this.f50020d = d9;
            return true;
        }
    }

    public static m e(HashSet hashSet, s sVar) {
        m mVar = sVar.j() ? new m("", null, null) : new l();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            mVar.a(str, str);
        }
        return mVar;
    }

    protected boolean b(char c8, char c9) {
        return c8 == c9;
    }

    public final String c(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        if (f(charSequence, index, length)) {
            int length2 = this.f50017a.length() + index;
            m mVar = this.f50020d;
            if (mVar != null && length2 != length) {
                while (true) {
                    if (!b(mVar.f50019c, charSequence.charAt(length2))) {
                        mVar = mVar.f50021e;
                        if (mVar == null) {
                            break;
                        }
                    } else {
                        parsePosition.setIndex(length2);
                        String c8 = mVar.c(charSequence, parsePosition);
                        if (c8 != null) {
                            return c8;
                        }
                    }
                }
            }
            parsePosition.setIndex(length2);
            return this.f50018b;
        }
        return null;
    }

    protected m d(String str, String str2, m mVar) {
        return new m(str, str2, mVar);
    }

    protected boolean f(CharSequence charSequence, int i8, int i9) {
        if (charSequence instanceof String) {
            return ((String) charSequence).startsWith(this.f50017a, i8);
        }
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
            if (!b(this.f50017a.charAt(i10), charSequence.charAt(i8))) {
                return false;
            }
            i8 = i13;
            length = i11;
            i10 = i12;
        }
    }
}
