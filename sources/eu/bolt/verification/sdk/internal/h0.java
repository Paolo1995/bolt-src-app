package eu.bolt.verification.sdk.internal;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import eu.bolt.verification.sdk.internal.lf;

/* loaded from: classes5.dex */
final class h0 implements lf.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    static final h0 f43187a = new h0();

    h0() {
    }

    @Override // eu.bolt.verification.sdk.internal.lf.a
    /* renamed from: c */
    public void a(@NonNull String str, @NonNull Boolean bool, @NonNull SharedPreferences.Editor editor) {
        editor.putBoolean(str, bool.booleanValue());
    }

    @Override // eu.bolt.verification.sdk.internal.lf.a
    /* renamed from: d */
    public Boolean b(@NonNull String str, @NonNull SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
    }
}
