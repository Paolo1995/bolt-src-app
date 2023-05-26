package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PersistedInstallation {

    /* renamed from: a  reason: collision with root package name */
    private File f16405a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f16406b;

    /* loaded from: classes3.dex */
    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(@NonNull FirebaseApp firebaseApp) {
        this.f16406b = firebaseApp;
    }

    private File a() {
        if (this.f16405a == null) {
            synchronized (this) {
                if (this.f16405a == null) {
                    File filesDir = this.f16406b.j().getFilesDir();
                    this.f16405a = new File(filesDir, "PersistedInstallation." + this.f16406b.n() + ".json");
                }
            }
        }
        return this.f16405a;
    }

    private JSONObject c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                int read = fileInputStream.read(bArr, 0, 16384);
                if (read < 0) {
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                    fileInputStream.close();
                    return jSONObject;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    @NonNull
    public PersistedInstallationEntry b(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.d());
            jSONObject.put("Status", persistedInstallationEntry.g().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.b());
            jSONObject.put("RefreshToken", persistedInstallationEntry.f());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.h());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.c());
            jSONObject.put("FisError", persistedInstallationEntry.e());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f16406b.j().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (!createTempFile.renameTo(a())) {
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        }
        return persistedInstallationEntry;
    }

    @NonNull
    public PersistedInstallationEntry d() {
        JSONObject c8 = c();
        String optString = c8.optString("Fid", null);
        int optInt = c8.optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String optString2 = c8.optString("AuthToken", null);
        String optString3 = c8.optString("RefreshToken", null);
        long optLong = c8.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = c8.optLong("ExpiresInSecs", 0L);
        return PersistedInstallationEntry.a().d(optString).g(RegistrationStatus.values()[optInt]).b(optString2).f(optString3).h(optLong).c(optLong2).e(c8.optString("FisError", null)).a();
    }
}
