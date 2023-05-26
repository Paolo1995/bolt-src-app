package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class KeyPath {

    /* renamed from: c  reason: collision with root package name */
    public static final KeyPath f9292c = new KeyPath("COMPOSITION");

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f9293a;

    /* renamed from: b  reason: collision with root package name */
    private KeyPathElement f9294b;

    public KeyPath(String... strArr) {
        this.f9293a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f9293a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public KeyPath a(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f9293a.add(str);
        return keyPath;
    }

    public boolean c(String str, int i8) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (i8 >= this.f9293a.size()) {
            return false;
        }
        if (i8 == this.f9293a.size() - 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        String str2 = this.f9293a.get(i8);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z9 = false;
            } else {
                z9 = true;
            }
            if ((!z7 && (i8 != this.f9293a.size() - 2 || !b())) || !z9) {
                return false;
            }
            return true;
        }
        if (!z7 && this.f9293a.get(i8 + 1).equals(str)) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            if (i8 != this.f9293a.size() - 2 && (i8 != this.f9293a.size() - 3 || !b())) {
                return false;
            }
            return true;
        } else if (z7) {
            return true;
        } else {
            int i9 = i8 + 1;
            if (i9 < this.f9293a.size() - 1) {
                return false;
            }
            return this.f9293a.get(i9).equals(str);
        }
    }

    public KeyPathElement d() {
        return this.f9294b;
    }

    public int e(String str, int i8) {
        if (f(str)) {
            return 0;
        }
        if (!this.f9293a.get(i8).equals("**")) {
            return 1;
        }
        if (i8 == this.f9293a.size() - 1 || !this.f9293a.get(i8 + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyPath keyPath = (KeyPath) obj;
        if (!this.f9293a.equals(keyPath.f9293a)) {
            return false;
        }
        KeyPathElement keyPathElement = this.f9294b;
        KeyPathElement keyPathElement2 = keyPath.f9294b;
        if (keyPathElement != null) {
            return keyPathElement.equals(keyPathElement2);
        }
        if (keyPathElement2 == null) {
            return true;
        }
        return false;
    }

    public boolean g(String str, int i8) {
        if (f(str)) {
            return true;
        }
        if (i8 >= this.f9293a.size()) {
            return false;
        }
        if (this.f9293a.get(i8).equals(str) || this.f9293a.get(i8).equals("**") || this.f9293a.get(i8).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean h(String str, int i8) {
        if ("__container".equals(str) || i8 < this.f9293a.size() - 1 || this.f9293a.get(i8).equals("**")) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i8;
        int hashCode = this.f9293a.hashCode() * 31;
        KeyPathElement keyPathElement = this.f9294b;
        if (keyPathElement != null) {
            i8 = keyPathElement.hashCode();
        } else {
            i8 = 0;
        }
        return hashCode + i8;
    }

    public KeyPath i(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f9294b = keyPathElement;
        return keyPath;
    }

    public String toString() {
        boolean z7;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f9293a);
        sb.append(",resolved=");
        if (this.f9294b != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        sb.append(z7);
        sb.append('}');
        return sb.toString();
    }

    private KeyPath(KeyPath keyPath) {
        this.f9293a = new ArrayList(keyPath.f9293a);
        this.f9294b = keyPath.f9294b;
    }
}
