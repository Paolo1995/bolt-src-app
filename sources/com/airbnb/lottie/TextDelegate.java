package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TextDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f9012a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f9015d = true;

    /* renamed from: b  reason: collision with root package name */
    private final LottieAnimationView f9013b = null;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f9014c = null;

    TextDelegate() {
    }

    public String a(String str) {
        return str;
    }

    public String b(String str, String str2) {
        return a(str2);
    }

    public final String c(String str, String str2) {
        if (this.f9015d && this.f9012a.containsKey(str2)) {
            return this.f9012a.get(str2);
        }
        String b8 = b(str, str2);
        if (this.f9015d) {
            this.f9012a.put(str2, b8);
        }
        return b8;
    }
}
