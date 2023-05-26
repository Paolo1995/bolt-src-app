package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.subtle.Hex;
import java.io.IOException;

/* loaded from: classes.dex */
public final class SharedPrefKeysetWriter implements KeysetWriter {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences.Editor f14888a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14889b;

    public SharedPrefKeysetWriter(Context context, String str, String str2) {
        if (str != null) {
            this.f14889b = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.f14888a = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
                return;
            } else {
                this.f14888a = applicationContext.getSharedPreferences(str2, 0).edit();
                return;
            }
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void a(Keyset keyset) throws IOException {
        if (this.f14888a.putString(this.f14889b, Hex.b(keyset.a())).commit()) {
            return;
        }
        throw new IOException("Failed to write to SharedPreferences");
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void b(EncryptedKeyset encryptedKeyset) throws IOException {
        if (this.f14888a.putString(this.f14889b, Hex.b(encryptedKeyset.a())).commit()) {
            return;
        }
        throw new IOException("Failed to write to SharedPreferences");
    }
}
