package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class Utils {

    /* renamed from: b  reason: collision with root package name */
    public static final long f16379b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f16380c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d  reason: collision with root package name */
    private static Utils f16381d;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f16382a;

    private Utils(Clock clock) {
        this.f16382a = clock;
    }

    public static Utils c() {
        return d(SystemClock.a());
    }

    public static Utils d(Clock clock) {
        if (f16381d == null) {
            f16381d = new Utils(clock);
        }
        return f16381d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(String str) {
        return f16380c.matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f16382a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        if (TextUtils.isEmpty(persistedInstallationEntry.b()) || persistedInstallationEntry.h() + persistedInstallationEntry.c() < b() + f16379b) {
            return true;
        }
        return false;
    }
}
