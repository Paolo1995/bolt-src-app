package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: Composers.kt */
/* loaded from: classes5.dex */
public final class ComposerWithPrettyPrint extends Composer {

    /* renamed from: c  reason: collision with root package name */
    private final Json f52381c;

    /* renamed from: d  reason: collision with root package name */
    private int f52382d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerWithPrettyPrint(JsonWriter writer, Json json) {
        super(writer);
        Intrinsics.f(writer, "writer");
        Intrinsics.f(json, "json");
        this.f52381c = json;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void b() {
        n(true);
        this.f52382d++;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void c() {
        n(false);
        j("\n");
        int i8 = this.f52382d;
        for (int i9 = 0; i9 < i8; i9++) {
            j(this.f52381c.g().i());
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void o() {
        e(' ');
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void p() {
        this.f52382d--;
    }
}
