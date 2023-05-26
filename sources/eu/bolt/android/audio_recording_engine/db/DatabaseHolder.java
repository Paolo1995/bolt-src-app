package eu.bolt.android.audio_recording_engine.db;

import android.content.Context;
import androidx.room.Room;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatabaseHolder.kt */
/* loaded from: classes5.dex */
public final class DatabaseHolder {

    /* renamed from: a  reason: collision with root package name */
    public static final DatabaseHolder f36598a = new DatabaseHolder();

    /* renamed from: b  reason: collision with root package name */
    private static AudioRecordingDatabase f36599b;

    private DatabaseHolder() {
    }

    public final AudioRecordingDatabase a() {
        AudioRecordingDatabase audioRecordingDatabase = f36599b;
        if (audioRecordingDatabase != null) {
            return audioRecordingDatabase;
        }
        throw new RuntimeException("Database is not initialized ");
    }

    public final void b(Context context) {
        Intrinsics.f(context, "context");
        f36599b = (AudioRecordingDatabase) Room.a(context, AudioRecordingDatabase.class, "recording_db").d();
    }
}
