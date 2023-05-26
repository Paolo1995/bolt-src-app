package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

/* loaded from: classes3.dex */
public abstract class PersistedInstallationEntry {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static PersistedInstallationEntry f16413a = a().a();

    /* loaded from: classes3.dex */
    public static abstract class Builder {
        @NonNull
        public abstract PersistedInstallationEntry a();

        @NonNull
        public abstract Builder b(String str);

        @NonNull
        public abstract Builder c(long j8);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(String str);

        @NonNull
        public abstract Builder f(String str);

        @NonNull
        public abstract Builder g(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract Builder h(long j8);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_PersistedInstallationEntry.Builder().h(0L).g(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).c(0L);
    }

    public abstract String b();

    public abstract long c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    @NonNull
    public abstract PersistedInstallation.RegistrationStatus g();

    public abstract long h();

    public boolean i() {
        if (g() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (g() != PersistedInstallation.RegistrationStatus.NOT_GENERATED && g() != PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
            return false;
        }
        return true;
    }

    public boolean k() {
        if (g() == PersistedInstallation.RegistrationStatus.REGISTERED) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if (g() == PersistedInstallation.RegistrationStatus.UNREGISTERED) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if (g() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
            return true;
        }
        return false;
    }

    @NonNull
    public abstract Builder n();

    @NonNull
    public PersistedInstallationEntry o(@NonNull String str, long j8, long j9) {
        return n().b(str).c(j8).h(j9).a();
    }

    @NonNull
    public PersistedInstallationEntry p() {
        return n().b(null).a();
    }

    @NonNull
    public PersistedInstallationEntry q(@NonNull String str) {
        return n().e(str).g(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).a();
    }

    @NonNull
    public PersistedInstallationEntry r() {
        return n().g(PersistedInstallation.RegistrationStatus.NOT_GENERATED).a();
    }

    @NonNull
    public PersistedInstallationEntry s(@NonNull String str, @NonNull String str2, long j8, String str3, long j9) {
        return n().d(str).g(PersistedInstallation.RegistrationStatus.REGISTERED).b(str3).f(str2).c(j9).h(j8).a();
    }

    @NonNull
    public PersistedInstallationEntry t(@NonNull String str) {
        return n().d(str).g(PersistedInstallation.RegistrationStatus.UNREGISTERED).a();
    }
}
