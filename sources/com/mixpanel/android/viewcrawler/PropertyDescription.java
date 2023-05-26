package com.mixpanel.android.viewcrawler;

/* loaded from: classes3.dex */
class PropertyDescription {

    /* renamed from: a  reason: collision with root package name */
    public final String f19498a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f19499b;

    /* renamed from: c  reason: collision with root package name */
    public final Caller f19500c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19501d;

    public PropertyDescription(String str, Class<?> cls, Caller caller, String str2) {
        this.f19498a = str;
        this.f19499b = cls;
        this.f19500c = caller;
        this.f19501d = str2;
    }

    public Caller a(Object[] objArr) throws NoSuchMethodException {
        String str = this.f19501d;
        if (str == null) {
            return null;
        }
        return new Caller(this.f19499b, str, objArr, Void.TYPE);
    }

    public String toString() {
        return "[PropertyDescription " + this.f19498a + "," + this.f19499b + ", " + this.f19500c + "/" + this.f19501d + "]";
    }
}
