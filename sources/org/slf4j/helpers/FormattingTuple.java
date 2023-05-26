package org.slf4j.helpers;

/* loaded from: classes5.dex */
public class FormattingTuple {

    /* renamed from: d  reason: collision with root package name */
    public static FormattingTuple f52839d = new FormattingTuple(null);

    /* renamed from: a  reason: collision with root package name */
    private String f52840a;

    /* renamed from: b  reason: collision with root package name */
    private Throwable f52841b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f52842c;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public Object[] a() {
        return this.f52842c;
    }

    public String b() {
        return this.f52840a;
    }

    public Throwable c() {
        return this.f52841b;
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.f52840a = str;
        this.f52841b = th;
        this.f52842c = objArr;
    }
}
