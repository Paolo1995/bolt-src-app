package ee.mtakso.driver.network.client.auth.anonymous;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthResult.kt */
/* loaded from: classes3.dex */
public abstract class AuthResult {

    /* compiled from: AuthResult.kt */
    /* loaded from: classes3.dex */
    public static final class PartnerEmailVerification extends AuthResult {

        /* renamed from: f  reason: collision with root package name */
        private final String f21455f;

        /* renamed from: g  reason: collision with root package name */
        private final String f21456g;

        /* renamed from: h  reason: collision with root package name */
        private final String f21457h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PartnerEmailVerification(String title, String description, String email) {
            super(null);
            Intrinsics.f(title, "title");
            Intrinsics.f(description, "description");
            Intrinsics.f(email, "email");
            this.f21455f = title;
            this.f21456g = description;
            this.f21457h = email;
        }

        public final String a() {
            return this.f21456g;
        }

        public final String b() {
            return this.f21457h;
        }

        public final String c() {
            return this.f21455f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PartnerEmailVerification) {
                PartnerEmailVerification partnerEmailVerification = (PartnerEmailVerification) obj;
                return Intrinsics.a(this.f21455f, partnerEmailVerification.f21455f) && Intrinsics.a(this.f21456g, partnerEmailVerification.f21456g) && Intrinsics.a(this.f21457h, partnerEmailVerification.f21457h);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f21455f.hashCode() * 31) + this.f21456g.hashCode()) * 31) + this.f21457h.hashCode();
        }

        public String toString() {
            String str = this.f21455f;
            String str2 = this.f21456g;
            String str3 = this.f21457h;
            return "PartnerEmailVerification(title=" + str + ", description=" + str2 + ", email=" + str3 + ")";
        }
    }

    /* compiled from: AuthResult.kt */
    /* loaded from: classes3.dex */
    public static final class PartnerSuccess extends AuthResult {

        /* renamed from: f  reason: collision with root package name */
        private final String f21458f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PartnerSuccess(String refreshToken) {
            super(null);
            Intrinsics.f(refreshToken, "refreshToken");
            this.f21458f = refreshToken;
        }

        public final String a() {
            return this.f21458f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PartnerSuccess) && Intrinsics.a(this.f21458f, ((PartnerSuccess) obj).f21458f);
        }

        public int hashCode() {
            return this.f21458f.hashCode();
        }

        public String toString() {
            String str = this.f21458f;
            return "PartnerSuccess(refreshToken=" + str + ")";
        }
    }

    /* compiled from: AuthResult.kt */
    /* loaded from: classes3.dex */
    public static final class PasswordChangeRequired extends AuthResult {

        /* renamed from: f  reason: collision with root package name */
        public static final PasswordChangeRequired f21459f = new PasswordChangeRequired();

        private PasswordChangeRequired() {
            super(null);
        }
    }

    /* compiled from: AuthResult.kt */
    /* loaded from: classes3.dex */
    public static final class Success extends AuthResult {

        /* renamed from: f  reason: collision with root package name */
        private final String f21460f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String refreshToken) {
            super(null);
            Intrinsics.f(refreshToken, "refreshToken");
            this.f21460f = refreshToken;
        }

        public final String a() {
            return this.f21460f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.a(this.f21460f, ((Success) obj).f21460f);
        }

        public int hashCode() {
            return this.f21460f.hashCode();
        }

        public String toString() {
            String str = this.f21460f;
            return "Success(refreshToken=" + str + ")";
        }
    }

    /* compiled from: AuthResult.kt */
    /* loaded from: classes3.dex */
    public static final class Verification extends AuthResult implements Parcelable {
        public static final Parcelable.Creator<Verification> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final String f21461f;

        /* renamed from: g  reason: collision with root package name */
        private final VerificationChannel f21462g;

        /* renamed from: h  reason: collision with root package name */
        private final String f21463h;

        /* renamed from: i  reason: collision with root package name */
        private final int f21464i;

        /* renamed from: j  reason: collision with root package name */
        private final int f21465j;

        /* renamed from: k  reason: collision with root package name */
        private final List<VerificationChannel> f21466k;

        /* renamed from: l  reason: collision with root package name */
        private final long f21467l;

        /* compiled from: AuthResult.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Verification> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Verification createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                String readString = parcel.readString();
                VerificationChannel valueOf = VerificationChannel.valueOf(parcel.readString());
                String readString2 = parcel.readString();
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt3);
                for (int i8 = 0; i8 != readInt3; i8++) {
                    arrayList.add(VerificationChannel.valueOf(parcel.readString()));
                }
                return new Verification(readString, valueOf, readString2, readInt, readInt2, arrayList, parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Verification[] newArray(int i8) {
                return new Verification[i8];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Verification(String token, VerificationChannel channel, String target, int i8, int i9, List<? extends VerificationChannel> availableChannels, long j8) {
            super(null);
            Intrinsics.f(token, "token");
            Intrinsics.f(channel, "channel");
            Intrinsics.f(target, "target");
            Intrinsics.f(availableChannels, "availableChannels");
            this.f21461f = token;
            this.f21462g = channel;
            this.f21463h = target;
            this.f21464i = i8;
            this.f21465j = i9;
            this.f21466k = availableChannels;
            this.f21467l = j8;
        }

        public final List<VerificationChannel> a() {
            return this.f21466k;
        }

        public final VerificationChannel b() {
            return this.f21462g;
        }

        public final int c() {
            return this.f21464i;
        }

        public final int d() {
            return this.f21465j;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final long e() {
            return this.f21467l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Verification) {
                Verification verification = (Verification) obj;
                return Intrinsics.a(this.f21461f, verification.f21461f) && this.f21462g == verification.f21462g && Intrinsics.a(this.f21463h, verification.f21463h) && this.f21464i == verification.f21464i && this.f21465j == verification.f21465j && Intrinsics.a(this.f21466k, verification.f21466k) && this.f21467l == verification.f21467l;
            }
            return false;
        }

        public final String f() {
            return this.f21463h;
        }

        public final String g() {
            return this.f21461f;
        }

        public int hashCode() {
            return (((((((((((this.f21461f.hashCode() * 31) + this.f21462g.hashCode()) * 31) + this.f21463h.hashCode()) * 31) + this.f21464i) * 31) + this.f21465j) * 31) + this.f21466k.hashCode()) * 31) + i0.a.a(this.f21467l);
        }

        public String toString() {
            String str = this.f21461f;
            VerificationChannel verificationChannel = this.f21462g;
            String str2 = this.f21463h;
            int i8 = this.f21464i;
            int i9 = this.f21465j;
            List<VerificationChannel> list = this.f21466k;
            long j8 = this.f21467l;
            return "Verification(token=" + str + ", channel=" + verificationChannel + ", target=" + str2 + ", codeLength=" + i8 + ", reSendTimeout=" + i9 + ", availableChannels=" + list + ", requestedAt=" + j8 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeString(this.f21461f);
            out.writeString(this.f21462g.name());
            out.writeString(this.f21463h);
            out.writeInt(this.f21464i);
            out.writeInt(this.f21465j);
            List<VerificationChannel> list = this.f21466k;
            out.writeInt(list.size());
            for (VerificationChannel verificationChannel : list) {
                out.writeString(verificationChannel.name());
            }
            out.writeLong(this.f21467l);
        }
    }

    /* compiled from: AuthResult.kt */
    /* loaded from: classes3.dex */
    public static final class VerificationCanceled extends AuthResult {

        /* renamed from: f  reason: collision with root package name */
        public static final VerificationCanceled f21468f = new VerificationCanceled();

        private VerificationCanceled() {
            super(null);
        }
    }

    private AuthResult() {
    }

    public /* synthetic */ AuthResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
