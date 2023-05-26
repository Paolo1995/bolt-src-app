package eu.bolt.driver.core.permission;

import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: PermissionInitiatorTracker.kt */
/* loaded from: classes5.dex */
public final class PermissionInitiatorTracker {

    /* renamed from: c  reason: collision with root package name */
    private static final Companion f40894c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f40895a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Boolean> f40896b;

    /* compiled from: PermissionInitiatorTracker.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PermissionInitiatorTracker.kt */
    /* loaded from: classes5.dex */
    public static final class Result {

        /* renamed from: a  reason: collision with root package name */
        private final PermissionManager.DenyInitiator f40897a;

        /* renamed from: b  reason: collision with root package name */
        private final PermissionManager.RationalStatus f40898b;

        public Result(PermissionManager.DenyInitiator denyInitiator, PermissionManager.RationalStatus rationalStatus) {
            Intrinsics.f(denyInitiator, "denyInitiator");
            Intrinsics.f(rationalStatus, "rationalStatus");
            this.f40897a = denyInitiator;
            this.f40898b = rationalStatus;
        }

        public final PermissionManager.DenyInitiator a() {
            return this.f40897a;
        }

        public final PermissionManager.RationalStatus b() {
            return this.f40898b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Result) {
                Result result = (Result) obj;
                return this.f40897a == result.f40897a && this.f40898b == result.f40898b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f40897a.hashCode() * 31) + this.f40898b.hashCode();
        }

        public String toString() {
            PermissionManager.DenyInitiator denyInitiator = this.f40897a;
            PermissionManager.RationalStatus rationalStatus = this.f40898b;
            return "Result(denyInitiator=" + denyInitiator + ", rationalStatus=" + rationalStatus + ")";
        }
    }

    @Inject
    public PermissionInitiatorTracker(BoltPrefsStorage boltPrefsStorage) {
        Intrinsics.f(boltPrefsStorage, "boltPrefsStorage");
        this.f40895a = boltPrefsStorage;
        this.f40896b = new LinkedHashMap();
    }

    private final String a(String str) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%s_%s", Arrays.copyOf(new Object[]{"permission", str}, 2));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    private final boolean c(String str) {
        Boolean bool = this.f40896b.get(str);
        this.f40896b.remove(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean e(String str) {
        return this.f40895a.getBoolean(a(str), false);
    }

    public final Result b(String permission) {
        PermissionManager.RationalStatus rationalStatus;
        Intrinsics.f(permission, "permission");
        boolean c8 = c(permission);
        boolean e8 = e(permission);
        if (c8) {
            this.f40895a.h(a(permission), Boolean.TRUE);
        }
        if (e8) {
            if (c8) {
                return new Result(PermissionManager.DenyInitiator.DENIED_BY_USER, PermissionManager.RationalStatus.RATIONAL_IS_A_MANDATORY);
            }
            return new Result(PermissionManager.DenyInitiator.AUTOMATIC_DENY, PermissionManager.RationalStatus.UNKNOWN);
        }
        PermissionManager.DenyInitiator denyInitiator = PermissionManager.DenyInitiator.DENIED_BY_USER;
        if (c8) {
            rationalStatus = PermissionManager.RationalStatus.RATIONAL_IS_A_MANDATORY;
        } else {
            rationalStatus = PermissionManager.RationalStatus.RATIONAL_IS_OPTIONAL;
        }
        return new Result(denyInitiator, rationalStatus);
    }

    public final void d(String permission, boolean z7) {
        Intrinsics.f(permission, "permission");
        this.f40896b.put(permission, Boolean.valueOf(z7));
    }
}
