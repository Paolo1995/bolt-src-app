package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
class KeysMap {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f15732a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final int f15733b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15734c;

    public KeysMap(int i8, int i9) {
        this.f15733b = i8;
        this.f15734c = i9;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f15734c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i8) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() > i8) {
                return trim.substring(0, i8);
            }
            return trim;
        }
        return str;
    }

    @NonNull
    public synchronized Map<String, String> a() {
        return Collections.unmodifiableMap(new HashMap(this.f15732a));
    }

    public synchronized boolean d(String str, String str2) {
        String b8 = b(str);
        if (this.f15732a.size() >= this.f15733b && !this.f15732a.containsKey(b8)) {
            Logger f8 = Logger.f();
            f8.k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f15733b);
            return false;
        }
        String c8 = c(str2, this.f15734c);
        if (CommonUtils.A(this.f15732a.get(b8), c8)) {
            return false;
        }
        Map<String, String> map = this.f15732a;
        if (str2 == null) {
            c8 = "";
        }
        map.put(b8, c8);
        return true;
    }

    public synchronized void e(Map<String, String> map) {
        String c8;
        int i8 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String b8 = b(entry.getKey());
            if (this.f15732a.size() >= this.f15733b && !this.f15732a.containsKey(b8)) {
                i8++;
            }
            String value = entry.getValue();
            Map<String, String> map2 = this.f15732a;
            if (value == null) {
                c8 = "";
            } else {
                c8 = c(value, this.f15734c);
            }
            map2.put(b8, c8);
        }
        if (i8 > 0) {
            Logger f8 = Logger.f();
            f8.k("Ignored " + i8 + " entries when adding custom keys. Maximum allowable: " + this.f15733b);
        }
    }
}
