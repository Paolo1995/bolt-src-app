package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class SharedPrefKeysetReader implements KeysetReader {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f14886a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14887b;

    public SharedPrefKeysetReader(Context context, String str, String str2) throws IOException {
        if (str != null) {
            this.f14887b = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.f14886a = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                return;
            } else {
                this.f14886a = applicationContext.getSharedPreferences(str2, 0);
                return;
            }
        }
        throw new IllegalArgumentException("keysetName cannot be null");
    }

    private byte[] b() throws IOException {
        try {
            String string = this.f14886a.getString(this.f14887b, null);
            if (string != null) {
                return Hex.a(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", this.f14887b));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", this.f14887b));
        }
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset a() throws IOException {
        return EncryptedKeyset.K(b(), ExtensionRegistryLite.b());
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        return Keyset.P(b(), ExtensionRegistryLite.b());
    }
}
