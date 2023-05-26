package androidx.camera.core.internal.utils;

import android.util.Size;
import androidx.annotation.NonNull;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionUtils;

/* loaded from: classes.dex */
public final class SizeUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Size f3937a = new Size(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final Size f3938b = new Size(640, 480);

    /* renamed from: c  reason: collision with root package name */
    public static final Size f3939c = new Size(PeerConnectionUtils.HD_VIDEO_HEIGHT, 480);

    /* renamed from: d  reason: collision with root package name */
    public static final Size f3940d = new Size(1920, 1080);

    private SizeUtil() {
    }

    public static int a(@NonNull Size size) {
        return size.getWidth() * size.getHeight();
    }
}
