package eu.bolt.android.maps.core.plugin.driver;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Tile.kt */
/* loaded from: classes5.dex */
public final class Tile {

    /* renamed from: a  reason: collision with root package name */
    private final int f36994a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36995b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f36996c;

    public Tile(int i8, int i9, byte[] data) {
        Intrinsics.f(data, "data");
        this.f36994a = i8;
        this.f36995b = i9;
        this.f36996c = data;
    }

    public final byte[] a() {
        return this.f36996c;
    }

    public final int b() {
        return this.f36995b;
    }

    public final int c() {
        return this.f36994a;
    }
}
