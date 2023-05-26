package eu.bolt.android.code;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Security.kt */
/* loaded from: classes5.dex */
public final class Security {
    private static final String[] parts1 = {"PXKphav0GnCF7pPszgnIeVcdklVhm3msrGtTcUMO", Native.bolt_native_RrV9(), "W6kcHYXVxEzAjlGreGXehrqgzPpiRHOOfE9hxKPV", "2pNNglJkmLVNPQUh07payHfSCgjP7KeKbVC7xh8S", "mSMp2CYkjU1lHyDbKCtriUhdz0CJlH0QGXZqQijs", Native.bolt_native_PU1o(), Native.bolt_native_JRx(), "SJkHtfOVQWZ8P7g7S0XERNGuijxR08hMzU4Rn87f", "v9fV8OPJVoiBVUfzuKrIZOZhRTqza5JrpZFdx340", "kmFRUregGex4fr0PgF4XCwighQa9HRJmxfA6YzP5", Native.bolt_native_RgK(), "yEqIJIhtEjGAUubRNV6kp1VFvp464F1010bGSlxT"};
    private static final String[] parts2 = {"ni9GguHXzAHB0kEw85ZgPquZeiq0QmeO8A2XXpVk", Native.bolt_native_o6H(), "LtnuuzwHRZaKuBohfMzpbr8kdZrAFwgtSmLKE0Zf", "VZlG8Ct1gDPTSlqzMK7nR9ShbKp0nnvpCuKXFYw0", "sYTNSDf0P2o45AofMnKQeEpHqZx8hmPjnA5NBlHq", Native.bolt_native_YAT6(), "Ujsg3U2anLMHvMo3zsKcGyc3Lp83yRRnIZhgRkhp", "SCWtMx25olj2yVLlOYpKRW5wGnVq0o25gjYaHMIr", "40sesS0vUjywT8JQIKqLezY50u8XV0ydr5cAq6Re", Native.bolt_native_YneO(), Native.bolt_native_fgm(), "KZlpjBxcGGJzpLaOqLspFuDjZVdHGNAHiZrebOAw", "TX1i4WPfdL7uIZIbEKEJQX4N9jS5OADOkh3DGQuI", "RVOyD3QVIphI69uDt7lH5E4XbWke6bwasHaozvgX"};

    @SuppressLint({"PackageManagerGetSignatures"})
    public static final boolean verifyAppSignatures(Context context) {
        Intrinsics.f(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("eu.bolt.android.code", 64);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Signature[] signatureArr = packageInfo.signatures;
            Intrinsics.e(signatureArr, "packageInfo.signatures");
            for (Signature signature : signatureArr) {
                messageDigest.update(signature.toByteArray());
            }
            return Intrinsics.a("HuGHsdnLISDuduaida;do887SDSdA\n", Base64.encodeToString(messageDigest.digest(), 0));
        } catch (Exception unused) {
            return false;
        }
    }
}
