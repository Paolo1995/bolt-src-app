package org.ccil.cowan.tagsoup;

/* loaded from: classes5.dex */
public class ElementType {

    /* renamed from: a  reason: collision with root package name */
    private String f52658a;

    /* renamed from: b  reason: collision with root package name */
    private String f52659b;

    /* renamed from: c  reason: collision with root package name */
    private String f52660c;

    /* renamed from: d  reason: collision with root package name */
    private int f52661d;

    /* renamed from: e  reason: collision with root package name */
    private int f52662e;

    /* renamed from: f  reason: collision with root package name */
    private int f52663f;

    /* renamed from: g  reason: collision with root package name */
    private AttributesImpl f52664g = new AttributesImpl();

    /* renamed from: h  reason: collision with root package name */
    private ElementType f52665h;

    /* renamed from: i  reason: collision with root package name */
    private Schema f52666i;

    public ElementType(String str, int i8, int i9, int i10, Schema schema) {
        this.f52658a = str;
        this.f52661d = i8;
        this.f52662e = i9;
        this.f52663f = i10;
        this.f52666i = schema;
        this.f52659b = i(str, false);
        this.f52660c = e(str);
    }

    public static String j(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        if (trim.indexOf("  ") == -1) {
            return trim;
        }
        int length = trim.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z7 = false;
        for (int i8 = 0; i8 < length; i8++) {
            char charAt = trim.charAt(i8);
            if (charAt == ' ') {
                if (!z7) {
                    stringBuffer.append(charAt);
                }
                z7 = true;
            } else {
                stringBuffer.append(charAt);
                z7 = false;
            }
        }
        return stringBuffer.toString();
    }

    public AttributesImpl a() {
        return this.f52664g;
    }

    public boolean b(ElementType elementType) {
        if ((elementType.f52662e & this.f52661d) != 0) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f52663f;
    }

    public String d() {
        return this.f52660c;
    }

    public String e(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(indexOf + 1).intern();
    }

    public int f() {
        return this.f52661d;
    }

    public String g() {
        return this.f52658a;
    }

    public String h() {
        return this.f52659b;
    }

    public String i(String str, boolean z7) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            if (z7) {
                return "";
            }
            return this.f52666i.g();
        }
        String substring = str.substring(0, indexOf);
        if (substring.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("urn:x-prefix:");
        stringBuffer.append(substring);
        return stringBuffer.toString().intern();
    }

    public ElementType k() {
        return this.f52665h;
    }

    public void l(String str, String str2, String str3) {
        m(this.f52664g, str, str2, str3);
    }

    public void m(AttributesImpl attributesImpl, String str, String str2, String str3) {
        String str4;
        if (!str.equals("xmlns") && !str.startsWith("xmlns:")) {
            String i8 = i(str, true);
            String e8 = e(str);
            int index = attributesImpl.getIndex(str);
            if (index == -1) {
                String intern = str.intern();
                if (str2 == null) {
                    str4 = "CDATA";
                } else {
                    str4 = str2;
                }
                if (!str4.equals("CDATA")) {
                    str3 = j(str3);
                }
                attributesImpl.a(i8, e8, intern, str4, str3);
                return;
            }
            if (str2 == null) {
                str2 = attributesImpl.getType(index);
            }
            String str5 = str2;
            if (!str5.equals("CDATA")) {
                str3 = j(str3);
            }
            attributesImpl.f(index, i8, e8, str, str5, str3);
        }
    }

    public void n(ElementType elementType) {
        this.f52665h = elementType;
    }
}
