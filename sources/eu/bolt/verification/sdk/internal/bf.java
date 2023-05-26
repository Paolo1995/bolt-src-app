package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import eu.bolt.logger.Logger;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.fc;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes5.dex */
public final class bf {

    /* renamed from: a  reason: collision with root package name */
    public static final bf f42318a = new bf();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f42319b = ac.a.f42020b.g();

    private bf() {
    }

    @SuppressLint({"UnencryptedSharedPreferencesIssue"})
    public final synchronized SharedPreferences a(Context context, String preferencesName) {
        String string;
        Intrinsics.f(context, "context");
        Intrinsics.f(preferencesName, "preferencesName");
        Logger logger = f42319b;
        logger.b("Creating encrypted shared preferences for " + preferencesName + " with random initial vector");
        StringBuilder sb = new StringBuilder();
        sb.append(preferencesName);
        sb.append("__androidx_security_crypto_encrypted_prefs_iv");
        SharedPreferences sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
        if (!sharedPreferences.contains("iv")) {
            logger.b("Initializing random initial vector for " + preferencesName);
            sharedPreferences.edit().putString("iv", UUID.randomUUID().toString()).apply();
        }
        string = sharedPreferences.getString("iv", "");
        if (string == null) {
            string = "";
        }
        return b(context, preferencesName, string);
    }

    @SuppressLint({"UnencryptedSharedPreferencesIssue"})
    public final synchronized SharedPreferences b(Context context, String preferencesName, String initialVector) {
        SharedPreferences b8;
        Intrinsics.f(context, "context");
        Intrinsics.f(preferencesName, "preferencesName");
        Intrinsics.f(initialVector, "initialVector");
        Logger logger = f42319b;
        logger.b("Creating encrypted shared preferences for " + preferencesName + " with initial vector which passed in parameter");
        StringBuilder sb = new StringBuilder();
        sb.append(preferencesName);
        sb.append("__androidx_security_crypto_encrypted_prefs");
        String sb2 = sb.toString();
        byte[] bytes = initialVector.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        b8 = g6.b(context, sb2, bytes);
        Intrinsics.e(b8, "create(\n            cont….toByteArray(),\n        )");
        SharedPreferences plainTextPreferences = context.getSharedPreferences(preferencesName, 0);
        fc.a aVar = fc.f42978a;
        Intrinsics.e(plainTextPreferences, "plainTextPreferences");
        aVar.a(plainTextPreferences, b8);
        return b8;
    }
}
