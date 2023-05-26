package kotlinx.serialization.modules;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: SerializersModule.kt */
/* loaded from: classes5.dex */
public final class SerializersModuleKt {

    /* renamed from: a  reason: collision with root package name */
    private static final SerializersModule f52461a;

    static {
        Map f8;
        Map f9;
        Map f10;
        Map f11;
        Map f12;
        f8 = MapsKt__MapsKt.f();
        f9 = MapsKt__MapsKt.f();
        f10 = MapsKt__MapsKt.f();
        f11 = MapsKt__MapsKt.f();
        f12 = MapsKt__MapsKt.f();
        f52461a = new SerialModuleImpl(f8, f9, f10, f11, f12);
    }

    public static final SerializersModule a() {
        return f52461a;
    }
}
