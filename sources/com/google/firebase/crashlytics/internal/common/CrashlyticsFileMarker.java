package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CrashlyticsFileMarker {

    /* renamed from: a  reason: collision with root package name */
    private final String f15669a;

    /* renamed from: b  reason: collision with root package name */
    private final FileStore f15670b;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.f15669a = str;
        this.f15670b = fileStore;
    }

    private File b() {
        return this.f15670b.e(this.f15669a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e8) {
            Logger f8 = Logger.f();
            f8.e("Error creating marker: " + this.f15669a, e8);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
