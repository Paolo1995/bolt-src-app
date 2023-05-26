package ee.mtakso.driver.ui.utils;

import ee.mtakso.driver.uikit.utils.Image;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemedImage.kt */
/* loaded from: classes5.dex */
public final class ThemedImageKt {
    public static final Image a(ThemedImage themedImage) {
        Intrinsics.f(themedImage, "<this>");
        return new Image.DarkLight(new Image.Url(themedImage.b()), new Image.Url(themedImage.a()));
    }
}
