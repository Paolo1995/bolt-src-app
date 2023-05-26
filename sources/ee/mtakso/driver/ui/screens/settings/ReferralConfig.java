package ee.mtakso.driver.ui.screens.settings;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScreenState.kt */
/* loaded from: classes5.dex */
public abstract class ReferralConfig {

    /* compiled from: SettingsScreenState.kt */
    /* loaded from: classes5.dex */
    public static final class Campaign extends ReferralConfig {

        /* renamed from: a  reason: collision with root package name */
        private final Integer f33034a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33035b;

        /* renamed from: c  reason: collision with root package name */
        private final String f33036c;

        public Campaign(Integer num, String str, String str2) {
            super(null);
            this.f33034a = num;
            this.f33035b = str;
            this.f33036c = str2;
        }

        public final String a() {
            return this.f33036c;
        }

        public final String b() {
            return this.f33035b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Campaign) {
                Campaign campaign = (Campaign) obj;
                return Intrinsics.a(this.f33034a, campaign.f33034a) && Intrinsics.a(this.f33035b, campaign.f33035b) && Intrinsics.a(this.f33036c, campaign.f33036c);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f33034a;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.f33035b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f33036c;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.f33034a;
            String str = this.f33035b;
            String str2 = this.f33036c;
            return "Campaign(typeface=" + num + ", refCode=" + str + ", earningsAmount=" + str2 + ")";
        }
    }

    /* compiled from: SettingsScreenState.kt */
    /* loaded from: classes5.dex */
    public static final class Invite extends ReferralConfig {

        /* renamed from: a  reason: collision with root package name */
        private final String f33037a;

        public Invite(String str) {
            super(null);
            this.f33037a = str;
        }

        public final String a() {
            return this.f33037a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Invite) && Intrinsics.a(this.f33037a, ((Invite) obj).f33037a);
        }

        public int hashCode() {
            String str = this.f33037a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            String str = this.f33037a;
            return "Invite(refCode=" + str + ")";
        }
    }

    private ReferralConfig() {
    }

    public /* synthetic */ ReferralConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
