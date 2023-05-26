package com.google.firebase.platforminfo;

import kotlin.KotlinVersion;

/* loaded from: classes3.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String a() {
        try {
            return KotlinVersion.f50805k.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
