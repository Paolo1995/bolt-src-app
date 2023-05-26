package ee.mtakso.driver.network.client.order;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TripAudioRecordingData.kt */
/* loaded from: classes3.dex */
public final class TripAudioRecordingData {
    @SerializedName("recording_info")

    /* renamed from: a  reason: collision with root package name */
    private final RecordingInfo f22604a;
    @SerializedName("succeded")

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22605b;

    public final RecordingInfo a() {
        return this.f22604a;
    }

    public final boolean b() {
        return this.f22605b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TripAudioRecordingData) {
            TripAudioRecordingData tripAudioRecordingData = (TripAudioRecordingData) obj;
            return Intrinsics.a(this.f22604a, tripAudioRecordingData.f22604a) && this.f22605b == tripAudioRecordingData.f22605b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        RecordingInfo recordingInfo = this.f22604a;
        int hashCode = (recordingInfo == null ? 0 : recordingInfo.hashCode()) * 31;
        boolean z7 = this.f22605b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        RecordingInfo recordingInfo = this.f22604a;
        boolean z7 = this.f22605b;
        return "TripAudioRecordingData(recordingInfo=" + recordingInfo + ", succeded=" + z7 + ")";
    }
}
