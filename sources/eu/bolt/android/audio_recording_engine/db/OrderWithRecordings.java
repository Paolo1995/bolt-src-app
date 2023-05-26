package eu.bolt.android.audio_recording_engine.db;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderWithRecordings.kt */
/* loaded from: classes5.dex */
public final class OrderWithRecordings {

    /* renamed from: a  reason: collision with root package name */
    private final OrderRecordingsData f36604a;

    /* renamed from: b  reason: collision with root package name */
    private final List<RecordingFileInfo> f36605b;

    public OrderWithRecordings(OrderRecordingsData orderRecordingsData, List<RecordingFileInfo> recordingFileInfoList) {
        Intrinsics.f(orderRecordingsData, "orderRecordingsData");
        Intrinsics.f(recordingFileInfoList, "recordingFileInfoList");
        this.f36604a = orderRecordingsData;
        this.f36605b = recordingFileInfoList;
    }

    public final OrderRecordingsData a() {
        return this.f36604a;
    }

    public final List<RecordingFileInfo> b() {
        return this.f36605b;
    }
}
