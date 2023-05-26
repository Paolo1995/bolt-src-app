package ee.mtakso.driver.ui.screens.history.details.banner;

import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoBannerState.kt */
/* loaded from: classes3.dex */
public abstract class InfoBannerState {

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class ErrorState extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        private final Long f29522a;

        public ErrorState(Long l8) {
            super(null);
            this.f29522a = l8;
        }

        public final Long a() {
            return this.f29522a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorState) && Intrinsics.a(this.f29522a, ((ErrorState) obj).f29522a);
        }

        public int hashCode() {
            Long l8 = this.f29522a;
            if (l8 == null) {
                return 0;
            }
            return l8.hashCode();
        }

        public String toString() {
            Long l8 = this.f29522a;
            return "ErrorState(duration=" + l8 + ")";
        }
    }

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class FileSharedAndAvailable extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        private final Long f29523a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29524b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileSharedAndAvailable(Long l8, String sharedAt) {
            super(null);
            Intrinsics.f(sharedAt, "sharedAt");
            this.f29523a = l8;
            this.f29524b = sharedAt;
        }

        public final Long a() {
            return this.f29523a;
        }

        public final String b() {
            return this.f29524b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FileSharedAndAvailable) {
                FileSharedAndAvailable fileSharedAndAvailable = (FileSharedAndAvailable) obj;
                return Intrinsics.a(this.f29523a, fileSharedAndAvailable.f29523a) && Intrinsics.a(this.f29524b, fileSharedAndAvailable.f29524b);
            }
            return false;
        }

        public int hashCode() {
            Long l8 = this.f29523a;
            return ((l8 == null ? 0 : l8.hashCode()) * 31) + this.f29524b.hashCode();
        }

        public String toString() {
            Long l8 = this.f29523a;
            String str = this.f29524b;
            return "FileSharedAndAvailable(duration=" + l8 + ", sharedAt=" + str + ")";
        }
    }

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class FileSharedAndExpired extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        private final String f29525a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileSharedAndExpired(String sharedAt) {
            super(null);
            Intrinsics.f(sharedAt, "sharedAt");
            this.f29525a = sharedAt;
        }

        public final String a() {
            return this.f29525a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FileSharedAndExpired) && Intrinsics.a(this.f29525a, ((FileSharedAndExpired) obj).f29525a);
        }

        public int hashCode() {
            return this.f29525a.hashCode();
        }

        public String toString() {
            String str = this.f29525a;
            return "FileSharedAndExpired(sharedAt=" + str + ")";
        }
    }

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class Initial extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        public static final Initial f29526a = new Initial();

        private Initial() {
            super(null);
        }
    }

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class LoadingState extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        private final Long f29527a;

        public LoadingState(Long l8) {
            super(null);
            this.f29527a = l8;
        }

        public final Long a() {
            return this.f29527a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoadingState) && Intrinsics.a(this.f29527a, ((LoadingState) obj).f29527a);
        }

        public int hashCode() {
            Long l8 = this.f29527a;
            if (l8 == null) {
                return 0;
            }
            return l8.hashCode();
        }

        public String toString() {
            Long l8 = this.f29527a;
            return "LoadingState(duration=" + l8 + ")";
        }
    }

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class ShareWithCSState extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        private final Long f29528a;

        /* renamed from: b  reason: collision with root package name */
        private final WebAppLaunchParams f29529b;

        public ShareWithCSState(Long l8, WebAppLaunchParams webAppLaunchParams) {
            super(null);
            this.f29528a = l8;
            this.f29529b = webAppLaunchParams;
        }

        public final Long a() {
            return this.f29528a;
        }

        public final WebAppLaunchParams b() {
            return this.f29529b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareWithCSState) {
                ShareWithCSState shareWithCSState = (ShareWithCSState) obj;
                return Intrinsics.a(this.f29528a, shareWithCSState.f29528a) && Intrinsics.a(this.f29529b, shareWithCSState.f29529b);
            }
            return false;
        }

        public int hashCode() {
            Long l8 = this.f29528a;
            int hashCode = (l8 == null ? 0 : l8.hashCode()) * 31;
            WebAppLaunchParams webAppLaunchParams = this.f29529b;
            return hashCode + (webAppLaunchParams != null ? webAppLaunchParams.hashCode() : 0);
        }

        public String toString() {
            Long l8 = this.f29528a;
            WebAppLaunchParams webAppLaunchParams = this.f29529b;
            return "ShareWithCSState(duration=" + l8 + ", webAppLaunchParams=" + webAppLaunchParams + ")";
        }
    }

    /* compiled from: InfoBannerState.kt */
    /* loaded from: classes3.dex */
    public static final class UnsharedFileExpiredState extends InfoBannerState {

        /* renamed from: a  reason: collision with root package name */
        public static final UnsharedFileExpiredState f29530a = new UnsharedFileExpiredState();

        private UnsharedFileExpiredState() {
            super(null);
        }
    }

    private InfoBannerState() {
    }

    public /* synthetic */ InfoBannerState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
