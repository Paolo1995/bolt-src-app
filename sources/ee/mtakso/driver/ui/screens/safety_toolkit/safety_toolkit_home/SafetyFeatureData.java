package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import ee.mtakso.driver.ui.screens.safety_toolkit.emergency_assit.EmergencyAssistType;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SafetyToolkitData.kt */
/* loaded from: classes3.dex */
public abstract class SafetyFeatureData {

    /* compiled from: SafetyToolkitData.kt */
    /* loaded from: classes3.dex */
    public static final class EmergencyAssist extends SafetyFeatureData {

        /* renamed from: a  reason: collision with root package name */
        private final EmergencyAssistType f32766a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f32767b;

        /* renamed from: c  reason: collision with root package name */
        private final Text f32768c;

        /* renamed from: d  reason: collision with root package name */
        private final Image f32769d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f32770e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmergencyAssist(EmergencyAssistType type, Text title, Text text, Image leftIcon, boolean z7) {
            super(null);
            Intrinsics.f(type, "type");
            Intrinsics.f(title, "title");
            Intrinsics.f(leftIcon, "leftIcon");
            this.f32766a = type;
            this.f32767b = title;
            this.f32768c = text;
            this.f32769d = leftIcon;
            this.f32770e = z7;
        }

        public final Text a() {
            return this.f32768c;
        }

        public final boolean b() {
            return this.f32770e;
        }

        public final Image c() {
            return this.f32769d;
        }

        public final Text d() {
            return this.f32767b;
        }

        public final EmergencyAssistType e() {
            return this.f32766a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EmergencyAssist) {
                EmergencyAssist emergencyAssist = (EmergencyAssist) obj;
                return this.f32766a == emergencyAssist.f32766a && Intrinsics.a(this.f32767b, emergencyAssist.f32767b) && Intrinsics.a(this.f32768c, emergencyAssist.f32768c) && Intrinsics.a(this.f32769d, emergencyAssist.f32769d) && this.f32770e == emergencyAssist.f32770e;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.f32766a.hashCode() * 31) + this.f32767b.hashCode()) * 31;
            Text text = this.f32768c;
            int hashCode2 = (((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f32769d.hashCode()) * 31;
            boolean z7 = this.f32770e;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode2 + i8;
        }

        public String toString() {
            EmergencyAssistType emergencyAssistType = this.f32766a;
            Text text = this.f32767b;
            Text text2 = this.f32768c;
            Image image = this.f32769d;
            boolean z7 = this.f32770e;
            return "EmergencyAssist(type=" + emergencyAssistType + ", title=" + text + ", description=" + text2 + ", leftIcon=" + image + ", hasActiveIncident=" + z7 + ")";
        }
    }

    /* compiled from: SafetyToolkitData.kt */
    /* loaded from: classes3.dex */
    public static final class ShareRideDetails extends SafetyFeatureData {

        /* renamed from: a  reason: collision with root package name */
        private final Text f32771a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f32772b;

        /* renamed from: c  reason: collision with root package name */
        private final Image f32773c;

        /* renamed from: d  reason: collision with root package name */
        private final Image f32774d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShareRideDetails(Text title, Text text, Image leftIcon, Image infoIcon) {
            super(null);
            Intrinsics.f(title, "title");
            Intrinsics.f(leftIcon, "leftIcon");
            Intrinsics.f(infoIcon, "infoIcon");
            this.f32771a = title;
            this.f32772b = text;
            this.f32773c = leftIcon;
            this.f32774d = infoIcon;
        }

        public final Text a() {
            return this.f32772b;
        }

        public final Image b() {
            return this.f32774d;
        }

        public final Image c() {
            return this.f32773c;
        }

        public final Text d() {
            return this.f32771a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShareRideDetails) {
                ShareRideDetails shareRideDetails = (ShareRideDetails) obj;
                return Intrinsics.a(this.f32771a, shareRideDetails.f32771a) && Intrinsics.a(this.f32772b, shareRideDetails.f32772b) && Intrinsics.a(this.f32773c, shareRideDetails.f32773c) && Intrinsics.a(this.f32774d, shareRideDetails.f32774d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f32771a.hashCode() * 31;
            Text text = this.f32772b;
            return ((((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f32773c.hashCode()) * 31) + this.f32774d.hashCode();
        }

        public String toString() {
            Text text = this.f32771a;
            Text text2 = this.f32772b;
            Image image = this.f32773c;
            Image image2 = this.f32774d;
            return "ShareRideDetails(title=" + text + ", description=" + text2 + ", leftIcon=" + image + ", infoIcon=" + image2 + ")";
        }
    }

    /* compiled from: SafetyToolkitData.kt */
    /* loaded from: classes3.dex */
    public static final class TripAudioRecording extends SafetyFeatureData {

        /* renamed from: a  reason: collision with root package name */
        private final Text f32775a;

        /* renamed from: b  reason: collision with root package name */
        private final Text f32776b;

        /* renamed from: c  reason: collision with root package name */
        private final LeftIcon f32777c;

        /* renamed from: d  reason: collision with root package name */
        private final String f32778d;

        /* renamed from: e  reason: collision with root package name */
        private final Image f32779e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f32780f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f32781g;

        /* renamed from: h  reason: collision with root package name */
        private final RecorderEventState f32782h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TripAudioRecording(Text title, Text text, LeftIcon leftIcon, String str, Image image, boolean z7, boolean z8, RecorderEventState recorderEventState) {
            super(null);
            Intrinsics.f(title, "title");
            Intrinsics.f(leftIcon, "leftIcon");
            Intrinsics.f(recorderEventState, "recorderEventState");
            this.f32775a = title;
            this.f32776b = text;
            this.f32777c = leftIcon;
            this.f32778d = str;
            this.f32779e = image;
            this.f32780f = z7;
            this.f32781g = z8;
            this.f32782h = recorderEventState;
        }

        public final Text a() {
            return this.f32776b;
        }

        public final Image b() {
            return this.f32779e;
        }

        public final LeftIcon c() {
            return this.f32777c;
        }

        public final RecorderEventState d() {
            return this.f32782h;
        }

        public final String e() {
            return this.f32778d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TripAudioRecording) {
                TripAudioRecording tripAudioRecording = (TripAudioRecording) obj;
                return Intrinsics.a(this.f32775a, tripAudioRecording.f32775a) && Intrinsics.a(this.f32776b, tripAudioRecording.f32776b) && Intrinsics.a(this.f32777c, tripAudioRecording.f32777c) && Intrinsics.a(this.f32778d, tripAudioRecording.f32778d) && Intrinsics.a(this.f32779e, tripAudioRecording.f32779e) && this.f32780f == tripAudioRecording.f32780f && this.f32781g == tripAudioRecording.f32781g && Intrinsics.a(this.f32782h, tripAudioRecording.f32782h);
            }
            return false;
        }

        public final Text f() {
            return this.f32775a;
        }

        public final boolean g() {
            return this.f32781g;
        }

        public final boolean h() {
            return this.f32780f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f32775a.hashCode() * 31;
            Text text = this.f32776b;
            int hashCode2 = (((hashCode + (text == null ? 0 : text.hashCode())) * 31) + this.f32777c.hashCode()) * 31;
            String str = this.f32778d;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Image image = this.f32779e;
            int hashCode4 = (hashCode3 + (image != null ? image.hashCode() : 0)) * 31;
            boolean z7 = this.f32780f;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode4 + i8) * 31;
            boolean z8 = this.f32781g;
            return ((i9 + (z8 ? 1 : z8 ? 1 : 0)) * 31) + this.f32782h.hashCode();
        }

        public String toString() {
            Text text = this.f32775a;
            Text text2 = this.f32776b;
            LeftIcon leftIcon = this.f32777c;
            String str = this.f32778d;
            Image image = this.f32779e;
            boolean z7 = this.f32780f;
            boolean z8 = this.f32781g;
            RecorderEventState recorderEventState = this.f32782h;
            return "TripAudioRecording(title=" + text + ", description=" + text2 + ", leftIcon=" + leftIcon + ", rightTimer=" + str + ", infoIcon=" + image + ", isNewIndicatorVisible=" + z7 + ", isFooterEnabled=" + z8 + ", recorderEventState=" + recorderEventState + ")";
        }
    }

    private SafetyFeatureData() {
    }

    public /* synthetic */ SafetyFeatureData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
