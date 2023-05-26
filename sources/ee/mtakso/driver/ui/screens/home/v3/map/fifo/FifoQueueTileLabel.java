package ee.mtakso.driver.ui.screens.home.v3.map.fifo;

import ee.mtakso.driver.service.modules.map.TilePosition;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoQueueTileLabel.kt */
/* loaded from: classes3.dex */
public final class FifoQueueTileLabel {

    /* renamed from: a  reason: collision with root package name */
    private final String f30164a;

    /* renamed from: b  reason: collision with root package name */
    private final TilePosition f30165b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30166c;

    /* renamed from: d  reason: collision with root package name */
    private final int f30167d;

    /* renamed from: e  reason: collision with root package name */
    private final int f30168e;

    /* renamed from: f  reason: collision with root package name */
    private final String f30169f;

    /* renamed from: g  reason: collision with root package name */
    private final String f30170g;

    /* renamed from: h  reason: collision with root package name */
    private final Integer f30171h;

    public FifoQueueTileLabel(String id, TilePosition tilePosition, int i8, int i9, int i10, String str, String str2, Integer num) {
        Intrinsics.f(id, "id");
        Intrinsics.f(tilePosition, "tilePosition");
        this.f30164a = id;
        this.f30165b = tilePosition;
        this.f30166c = i8;
        this.f30167d = i9;
        this.f30168e = i10;
        this.f30169f = str;
        this.f30170g = str2;
        this.f30171h = num;
    }

    public final String a() {
        return this.f30164a;
    }

    public final Integer b() {
        return this.f30171h;
    }

    public final String c() {
        return this.f30170g;
    }

    public final String d() {
        return this.f30169f;
    }

    public final int e() {
        return this.f30167d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FifoQueueTileLabel) {
            FifoQueueTileLabel fifoQueueTileLabel = (FifoQueueTileLabel) obj;
            return Intrinsics.a(this.f30164a, fifoQueueTileLabel.f30164a) && Intrinsics.a(this.f30165b, fifoQueueTileLabel.f30165b) && this.f30166c == fifoQueueTileLabel.f30166c && this.f30167d == fifoQueueTileLabel.f30167d && this.f30168e == fifoQueueTileLabel.f30168e && Intrinsics.a(this.f30169f, fifoQueueTileLabel.f30169f) && Intrinsics.a(this.f30170g, fifoQueueTileLabel.f30170g) && Intrinsics.a(this.f30171h, fifoQueueTileLabel.f30171h);
        }
        return false;
    }

    public final int f() {
        return this.f30168e;
    }

    public final TilePosition g() {
        return this.f30165b;
    }

    public final int h() {
        return this.f30166c;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f30164a.hashCode() * 31) + this.f30165b.hashCode()) * 31) + this.f30166c) * 31) + this.f30167d) * 31) + this.f30168e) * 31;
        String str = this.f30169f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f30170g;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.f30171h;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        String str = this.f30164a;
        TilePosition tilePosition = this.f30165b;
        int i8 = this.f30166c;
        int i9 = this.f30167d;
        int i10 = this.f30168e;
        String str2 = this.f30169f;
        String str3 = this.f30170g;
        Integer num = this.f30171h;
        return "FifoQueueTileLabel(id=" + str + ", tilePosition=" + tilePosition + ", tileSize=" + i8 + ", tilePixelX=" + i9 + ", tilePixelY=" + i10 + ", labelTitleHtml=" + str2 + ", labelIconUrl=" + str3 + ", labelBackground=" + num + ")";
    }
}
