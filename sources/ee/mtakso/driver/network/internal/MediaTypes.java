package ee.mtakso.driver.network.internal;

import okhttp3.MediaType;

/* compiled from: MediaTypes.kt */
/* loaded from: classes3.dex */
public final class MediaTypes {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaTypes f22978a = new MediaTypes();

    /* renamed from: b  reason: collision with root package name */
    private static final MediaType f22979b;

    /* renamed from: c  reason: collision with root package name */
    private static final MediaType f22980c;

    /* renamed from: d  reason: collision with root package name */
    private static final MediaType f22981d;

    static {
        MediaType.Companion companion = MediaType.Companion;
        f22979b = companion.get("image/png");
        f22980c = companion.get("application/xml");
        f22981d = companion.get("application/vnd.mapbox-vector-tile");
    }

    private MediaTypes() {
    }

    public final MediaType a() {
        return f22981d;
    }

    public final MediaType b() {
        return f22980c;
    }

    public final MediaType c() {
        return f22979b;
    }
}
