package org.ccil.cowan.tagsoup;

import java.util.HashMap;

/* loaded from: classes5.dex */
public abstract class Schema {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f52710a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f52711b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private String f52712c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f52713d = "";

    /* renamed from: e  reason: collision with root package name */
    private ElementType f52714e = null;

    public void a(String str, String str2, String str3, String str4) {
        ElementType d8 = d(str);
        if (d8 != null) {
            d8.l(str2, str3, str4);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attribute ");
        stringBuffer.append(str2);
        stringBuffer.append(" specified for unknown element type ");
        stringBuffer.append(str);
        throw new Error(stringBuffer.toString());
    }

    public void b(String str, int i8, int i9, int i10) {
        ElementType elementType = new ElementType(str, i8, i9, i10, this);
        this.f52711b.put(str.toLowerCase(), elementType);
        if (i9 == Integer.MIN_VALUE) {
            this.f52714e = elementType;
        }
    }

    public void c(String str, int i8) {
        this.f52710a.put(str, new Integer(i8));
    }

    public ElementType d(String str) {
        return (ElementType) this.f52711b.get(str.toLowerCase());
    }

    public int e(String str) {
        Integer num = (Integer) this.f52710a.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String f() {
        return this.f52713d;
    }

    public String g() {
        return this.f52712c;
    }

    public void h(String str, String str2) {
        ElementType d8 = d(str);
        ElementType d9 = d(str2);
        if (d8 != null) {
            if (d9 != null) {
                d8.n(d9);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No parent ");
            stringBuffer.append(str2);
            stringBuffer.append(" for child ");
            stringBuffer.append(str);
            throw new Error(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("No child ");
        stringBuffer2.append(str);
        stringBuffer2.append(" for parent ");
        stringBuffer2.append(str2);
        throw new Error(stringBuffer2.toString());
    }

    public ElementType i() {
        return this.f52714e;
    }

    public void j(String str) {
        this.f52713d = str;
    }

    public void k(String str) {
        this.f52712c = str;
    }
}
