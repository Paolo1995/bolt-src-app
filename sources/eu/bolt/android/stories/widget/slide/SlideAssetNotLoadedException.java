package eu.bolt.android.stories.widget.slide;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlideAssetNotLoadedException.kt */
/* loaded from: classes5.dex */
public final class SlideAssetNotLoadedException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlideAssetNotLoadedException(String assetType, String url, Throwable th) {
        super("Slide asset could not be loaded: " + assetType + " , " + url, th);
        Intrinsics.f(assetType, "assetType");
        Intrinsics.f(url, "url");
    }
}
