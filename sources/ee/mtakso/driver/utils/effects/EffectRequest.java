package ee.mtakso.driver.utils.effects;

import ee.mtakso.driver.utils.effects.SoundEffect;
import ee.mtakso.driver.utils.effects.VibrateEffect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EffectRequest.kt */
/* loaded from: classes5.dex */
public final class EffectRequest {

    /* renamed from: a  reason: collision with root package name */
    private final SoundEffect.Source f36404a;

    /* renamed from: b  reason: collision with root package name */
    private final VibrateEffect.Type f36405b;

    /* compiled from: EffectRequest.kt */
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private SoundEffect.Source f36406a;

        /* renamed from: b  reason: collision with root package name */
        private VibrateEffect.Type f36407b;

        public final EffectRequest a() {
            if (this.f36406a == null && this.f36407b == null) {
                throw new IllegalArgumentException("One of the effect should be not null");
            }
            return new EffectRequest(this, null);
        }

        public final SoundEffect.Source b() {
            return this.f36406a;
        }

        public final VibrateEffect.Type c() {
            return this.f36407b;
        }

        public final Builder d(SoundEffect.Source type) {
            Intrinsics.f(type, "type");
            this.f36406a = type;
            return this;
        }

        public final Builder e(VibrateEffect.Type type) {
            Intrinsics.f(type, "type");
            this.f36407b = type;
            return this;
        }
    }

    private EffectRequest(Builder builder) {
        this.f36404a = builder.b();
        this.f36405b = builder.c();
    }

    public /* synthetic */ EffectRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final SoundEffect.Source a() {
        return this.f36404a;
    }

    public final VibrateEffect.Type b() {
        return this.f36405b;
    }
}
