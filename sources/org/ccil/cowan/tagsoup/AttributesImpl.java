package org.ccil.cowan.tagsoup;

import org.xml.sax.Attributes;

/* loaded from: classes5.dex */
public class AttributesImpl implements Attributes {

    /* renamed from: a  reason: collision with root package name */
    int f52652a;

    /* renamed from: b  reason: collision with root package name */
    String[] f52653b;

    public AttributesImpl() {
        this.f52652a = 0;
        this.f52653b = null;
    }

    private void b(int i8) throws ArrayIndexOutOfBoundsException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempt to modify attribute at illegal index: ");
        stringBuffer.append(i8);
        throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
    }

    private void d(int i8) {
        int i9;
        if (i8 <= 0) {
            return;
        }
        String[] strArr = this.f52653b;
        if (strArr != null && strArr.length != 0) {
            if (strArr.length >= i8 * 5) {
                return;
            }
            i9 = strArr.length;
        } else {
            i9 = 25;
        }
        while (i9 < i8 * 5) {
            i9 *= 2;
        }
        String[] strArr2 = new String[i9];
        int i10 = this.f52652a;
        if (i10 > 0) {
            System.arraycopy(this.f52653b, 0, strArr2, 0, i10 * 5);
        }
        this.f52653b = strArr2;
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        d(this.f52652a + 1);
        String[] strArr = this.f52653b;
        int i8 = this.f52652a;
        strArr[i8 * 5] = str;
        strArr[(i8 * 5) + 1] = str2;
        strArr[(i8 * 5) + 2] = str3;
        strArr[(i8 * 5) + 3] = str4;
        strArr[(i8 * 5) + 4] = str5;
        this.f52652a = i8 + 1;
    }

    public void c() {
        if (this.f52653b != null) {
            for (int i8 = 0; i8 < this.f52652a * 5; i8++) {
                this.f52653b[i8] = null;
            }
        }
        this.f52652a = 0;
    }

    public void e(int i8) {
        int i9;
        if (i8 >= 0 && i8 < (i9 = this.f52652a)) {
            if (i8 < i9 - 1) {
                String[] strArr = this.f52653b;
                System.arraycopy(strArr, (i8 + 1) * 5, strArr, i8 * 5, ((i9 - i8) - 1) * 5);
            }
            int i10 = this.f52652a;
            int i11 = (i10 - 1) * 5;
            String[] strArr2 = this.f52653b;
            int i12 = i11 + 1;
            strArr2[i11] = null;
            int i13 = i12 + 1;
            strArr2[i12] = null;
            int i14 = i13 + 1;
            strArr2[i13] = null;
            strArr2[i14] = null;
            strArr2[i14 + 1] = null;
            this.f52652a = i10 - 1;
            return;
        }
        b(i8);
    }

    public void f(int i8, String str, String str2, String str3, String str4, String str5) {
        if (i8 >= 0 && i8 < this.f52652a) {
            String[] strArr = this.f52653b;
            int i9 = i8 * 5;
            strArr[i9] = str;
            strArr[i9 + 1] = str2;
            strArr[i9 + 2] = str3;
            strArr[i9 + 3] = str4;
            strArr[i9 + 4] = str5;
            return;
        }
        b(i8);
    }

    public void g(Attributes attributes) {
        c();
        int length = attributes.getLength();
        this.f52652a = length;
        if (length > 0) {
            this.f52653b = new String[length * 5];
            for (int i8 = 0; i8 < this.f52652a; i8++) {
                int i9 = i8 * 5;
                this.f52653b[i9] = attributes.getURI(i8);
                this.f52653b[i9 + 1] = attributes.getLocalName(i8);
                this.f52653b[i9 + 2] = attributes.getQName(i8);
                this.f52653b[i9 + 3] = attributes.getType(i8);
                this.f52653b[i9 + 4] = attributes.getValue(i8);
            }
        }
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str, String str2) {
        int i8 = this.f52652a * 5;
        for (int i9 = 0; i9 < i8; i9 += 5) {
            if (this.f52653b[i9].equals(str) && this.f52653b[i9 + 1].equals(str2)) {
                return i9 / 5;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public int getLength() {
        return this.f52652a;
    }

    @Override // org.xml.sax.Attributes
    public String getLocalName(int i8) {
        if (i8 >= 0 && i8 < this.f52652a) {
            return this.f52653b[(i8 * 5) + 1];
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getQName(int i8) {
        if (i8 >= 0 && i8 < this.f52652a) {
            return this.f52653b[(i8 * 5) + 2];
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getType(int i8) {
        if (i8 < 0 || i8 >= this.f52652a) {
            return null;
        }
        return this.f52653b[(i8 * 5) + 3];
    }

    @Override // org.xml.sax.Attributes
    public String getURI(int i8) {
        if (i8 >= 0 && i8 < this.f52652a) {
            return this.f52653b[i8 * 5];
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(int i8) {
        if (i8 < 0 || i8 >= this.f52652a) {
            return null;
        }
        return this.f52653b[(i8 * 5) + 4];
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str, String str2) {
        int i8 = this.f52652a * 5;
        for (int i9 = 0; i9 < i8; i9 += 5) {
            if (this.f52653b[i9].equals(str) && this.f52653b[i9 + 1].equals(str2)) {
                return this.f52653b[i9 + 3];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str, String str2) {
        int i8 = this.f52652a * 5;
        for (int i9 = 0; i9 < i8; i9 += 5) {
            if (this.f52653b[i9].equals(str) && this.f52653b[i9 + 1].equals(str2)) {
                return this.f52653b[i9 + 4];
            }
        }
        return null;
    }

    public AttributesImpl(Attributes attributes) {
        g(attributes);
    }

    @Override // org.xml.sax.Attributes
    public int getIndex(String str) {
        int i8 = this.f52652a * 5;
        for (int i9 = 0; i9 < i8; i9 += 5) {
            if (this.f52653b[i9 + 2].equals(str)) {
                return i9 / 5;
            }
        }
        return -1;
    }

    @Override // org.xml.sax.Attributes
    public String getType(String str) {
        int i8 = this.f52652a * 5;
        for (int i9 = 0; i9 < i8; i9 += 5) {
            if (this.f52653b[i9 + 2].equals(str)) {
                return this.f52653b[i9 + 3];
            }
        }
        return null;
    }

    @Override // org.xml.sax.Attributes
    public String getValue(String str) {
        int i8 = this.f52652a * 5;
        for (int i9 = 0; i9 < i8; i9 += 5) {
            if (this.f52653b[i9 + 2].equals(str)) {
                return this.f52653b[i9 + 4];
            }
        }
        return null;
    }
}
