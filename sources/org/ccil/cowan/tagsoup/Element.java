package org.ccil.cowan.tagsoup;

/* loaded from: classes5.dex */
public class Element {

    /* renamed from: a  reason: collision with root package name */
    private ElementType f52654a;

    /* renamed from: b  reason: collision with root package name */
    private AttributesImpl f52655b;

    /* renamed from: c  reason: collision with root package name */
    private Element f52656c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52657d;

    public Element(ElementType elementType, boolean z7) {
        this.f52654a = elementType;
        if (z7) {
            this.f52655b = new AttributesImpl(elementType.a());
        } else {
            this.f52655b = new AttributesImpl();
        }
        this.f52656c = null;
        this.f52657d = false;
    }

    public void a() {
        for (int length = this.f52655b.getLength() - 1; length >= 0; length--) {
            if (this.f52655b.getType(length).equals("ID") || this.f52655b.getQName(length).equals("name")) {
                this.f52655b.e(length);
            }
        }
    }

    public AttributesImpl b() {
        return this.f52655b;
    }

    public boolean c(Element element) {
        return this.f52654a.b(element.f52654a);
    }

    public void d() {
        for (int length = this.f52655b.getLength() - 1; length >= 0; length--) {
            String localName = this.f52655b.getLocalName(length);
            if (this.f52655b.getValue(length) == null || localName == null || localName.length() == 0) {
                this.f52655b.e(length);
            }
        }
    }

    public int e() {
        return this.f52654a.c();
    }

    public boolean f() {
        return this.f52657d;
    }

    public String g() {
        return this.f52654a.d();
    }

    public int h() {
        return this.f52654a.f();
    }

    public String i() {
        return this.f52654a.g();
    }

    public String j() {
        return this.f52654a.h();
    }

    public Element k() {
        return this.f52656c;
    }

    public ElementType l() {
        return this.f52654a.k();
    }

    public void m() {
        this.f52657d = true;
    }

    public void n(String str, String str2, String str3) {
        this.f52654a.m(this.f52655b, str, str2, str3);
    }

    public void o(Element element) {
        this.f52656c = element;
    }
}
