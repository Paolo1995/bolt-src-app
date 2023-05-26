package com.bumptech.glide.util;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f10783a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f10784b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f10785c;

    public MultiClassKey() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, Class<?> cls3) {
        this.f10783a = cls;
        this.f10784b = cls2;
        this.f10785c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        if (this.f10783a.equals(multiClassKey.f10783a) && this.f10784b.equals(multiClassKey.f10784b) && Util.d(this.f10785c, multiClassKey.f10785c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i8;
        int hashCode = ((this.f10783a.hashCode() * 31) + this.f10784b.hashCode()) * 31;
        Class<?> cls = this.f10785c;
        if (cls != null) {
            i8 = cls.hashCode();
        } else {
            i8 = 0;
        }
        return hashCode + i8;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f10783a + ", second=" + this.f10784b + '}';
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
