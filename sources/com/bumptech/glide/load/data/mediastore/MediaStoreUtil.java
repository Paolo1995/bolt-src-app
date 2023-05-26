package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class MediaStoreUtil {
    private MediaStoreUtil() {
    }

    public static boolean a(Uri uri) {
        if (b(uri) && !e(uri)) {
            return true;
        }
        return false;
    }

    public static boolean b(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean c(Uri uri) {
        if (b(uri) && e(uri)) {
            return true;
        }
        return false;
    }

    public static boolean d(int i8, int i9) {
        return i8 != Integer.MIN_VALUE && i9 != Integer.MIN_VALUE && i8 <= 512 && i9 <= 384;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains(MediaStreamTrack.VIDEO_TRACK_KIND);
    }
}
