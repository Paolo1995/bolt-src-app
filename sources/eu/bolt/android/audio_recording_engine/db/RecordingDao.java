package eu.bolt.android.audio_recording_engine.db;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: RecordingDao.kt */
/* loaded from: classes5.dex */
public interface RecordingDao {
    Object a(String str, Continuation<? super List<Long>> continuation);

    Object b(long j8, int i8, Continuation<? super List<String>> continuation);

    Object c(String str, int i8, Continuation<? super Unit> continuation);

    Object d(String str, Continuation<? super List<Integer>> continuation);

    Object e(RecordingFileInfo recordingFileInfo, Continuation<? super Unit> continuation);

    Object f(String str, Continuation<? super OrderRecordingsData> continuation);

    Object g(OrderRecordingsData orderRecordingsData, Continuation<? super Unit> continuation);
}
