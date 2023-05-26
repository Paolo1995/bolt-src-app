package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CachedSettingsIo {

    /* renamed from: a  reason: collision with root package name */
    private final File f16153a;

    public CachedSettingsIo(FileStore fileStore) {
        this.f16153a = fileStore.e("com.crashlytics.settings.json");
    }

    private File a() {
        return this.f16153a;
    }

    public JSONObject b() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        Logger.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File a8 = a();
                if (a8.exists()) {
                    fileInputStream = new FileInputStream(a8);
                    try {
                        jSONObject = new JSONObject(CommonUtils.C(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e8) {
                        e = e8;
                        Logger.f().e("Failed to fetch cached settings", e);
                        CommonUtils.e(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    Logger.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.e(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Exception e9) {
                e = e9;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.e(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.e(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j8, JSONObject jSONObject) {
        Logger.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                try {
                    jSONObject.put("expires_at", j8);
                    FileWriter fileWriter2 = new FileWriter(a());
                    try {
                        fileWriter2.write(jSONObject.toString());
                        fileWriter2.flush();
                        CommonUtils.e(fileWriter2, "Failed to close settings writer.");
                    } catch (Exception e8) {
                        e = e8;
                        fileWriter = fileWriter2;
                        Logger.f().e("Failed to cache settings", e);
                        CommonUtils.e(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        CommonUtils.e(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
