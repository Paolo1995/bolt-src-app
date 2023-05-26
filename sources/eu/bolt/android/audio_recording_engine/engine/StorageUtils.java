package eu.bolt.android.audio_recording_engine.engine;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StorageUtils.kt */
/* loaded from: classes5.dex */
public final class StorageUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final StorageUtils f36684a = new StorageUtils();

    private StorageUtils() {
    }

    private final boolean b() {
        File dataDirectory = Environment.getDataDirectory();
        Intrinsics.e(dataDirectory, "getDataDirectory()");
        StatFs statFs = new StatFs(dataDirectory.getPath());
        if ((statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / 1048576 > 150) {
            return true;
        }
        return false;
    }

    public final boolean a() {
        return b();
    }
}
