package ee.mtakso.driver.utils.effects;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import ee.mtakso.driver.utils.AssertUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoundEffect.kt */
/* loaded from: classes5.dex */
public final class SoundEffect implements Effect {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f36412a;

    /* renamed from: b  reason: collision with root package name */
    private final Ringtone f36413b;

    /* compiled from: SoundEffect.kt */
    /* loaded from: classes5.dex */
    public static abstract class Source {

        /* compiled from: SoundEffect.kt */
        /* loaded from: classes5.dex */
        public static final class RING extends Source {

            /* renamed from: a  reason: collision with root package name */
            public static final RING f36414a = new RING();

            private RING() {
                super(null);
            }

            @Override // ee.mtakso.driver.utils.effects.SoundEffect.Source
            public Uri a(Context context) {
                Intrinsics.f(context, "context");
                Uri defaultUri = RingtoneManager.getDefaultUri(1);
                Intrinsics.e(defaultUri, "getDefaultUri(RingtoneManager.TYPE_RINGTONE)");
                return defaultUri;
            }
        }

        /* compiled from: SoundEffect.kt */
        /* loaded from: classes5.dex */
        public static final class RawResource extends Source {

            /* renamed from: a  reason: collision with root package name */
            private final int f36415a;

            public RawResource(int i8) {
                super(null);
                this.f36415a = i8;
            }

            @Override // ee.mtakso.driver.utils.effects.SoundEffect.Source
            public Uri a(Context context) {
                Intrinsics.f(context, "context");
                String packageName = context.getPackageName();
                int i8 = this.f36415a;
                Uri parse = Uri.parse("android.resource://" + packageName + "/" + i8);
                Intrinsics.e(parse, "parse(ContentResolver.SC…eName + \"/\" + resourceId)");
                return parse;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof RawResource) && this.f36415a == ((RawResource) obj).f36415a;
            }

            public int hashCode() {
                return this.f36415a;
            }

            public String toString() {
                int i8 = this.f36415a;
                return "RawResource(resourceId=" + i8 + ")";
            }
        }

        private Source() {
        }

        public /* synthetic */ Source(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Uri a(Context context);
    }

    public SoundEffect(Context context, Source effectSource) {
        Intrinsics.f(context, "context");
        Intrinsics.f(effectSource, "effectSource");
        Uri a8 = effectSource.a(context);
        this.f36412a = a8;
        this.f36413b = RingtoneManager.getRingtone(context, a8);
    }

    @Override // ee.mtakso.driver.utils.effects.Effect
    public void a() {
        AssertUtils.c(this.f36413b, "Ringtone should not be null");
        Ringtone ringtone = this.f36413b;
        if (ringtone != null) {
            ringtone.play();
        }
    }

    @Override // ee.mtakso.driver.utils.effects.Effect
    public void cancel() {
        AssertUtils.c(this.f36413b, "Ringtone should not be null");
        Ringtone ringtone = this.f36413b;
        if (ringtone != null) {
            ringtone.stop();
        }
    }
}
