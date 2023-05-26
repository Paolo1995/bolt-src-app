package com.clevertap.android.sdk.login;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Utils;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class IdentitySet {

    /* renamed from: a  reason: collision with root package name */
    private final HashSet<String> f11600a;

    private IdentitySet(String[] strArr) {
        this.f11600a = new HashSet<>();
        e(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IdentitySet b(String str) {
        return new IdentitySet(str.split(","));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IdentitySet c(String[] strArr) {
        return new IdentitySet(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IdentitySet d() {
        return new IdentitySet(Constants.f10927c);
    }

    private void e(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (Utils.c(Constants.f10928d, str)) {
                    this.f11600a.add(Utils.h(str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return Utils.c(this.f11600a, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.f11600a.equals(((IdentitySet) obj).f11600a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return !this.f11600a.isEmpty();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f11600a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (Constants.f10928d.contains(next)) {
                sb.append(next);
                if (it.hasNext()) {
                    str = ",";
                } else {
                    str = "";
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private IdentitySet(HashSet<String> hashSet) {
        HashSet<String> hashSet2 = new HashSet<>();
        this.f11600a = hashSet2;
        hashSet2.addAll(hashSet);
    }
}
