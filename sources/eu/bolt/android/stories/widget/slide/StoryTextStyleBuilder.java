package eu.bolt.android.stories.widget.slide;

import eu.bolt.android.stories.R$color;
import eu.bolt.android.stories.R$dimen;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ARiderX.kt */
/* loaded from: classes5.dex */
public final class StoryTextStyleBuilder {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f37743a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f37744b;

    /* renamed from: c  reason: collision with root package name */
    private int f37745c;

    /* renamed from: d  reason: collision with root package name */
    private int f37746d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f37747e;

    public StoryTextStyleBuilder() {
        int i8 = R$dimen.f37430h;
        this.f37744b = i8;
        this.f37745c = i8;
        this.f37746d = R$color.f37424f;
    }

    public final StoryTextStyleBuilder a(int i8) {
        this.f37746d = i8;
        return this;
    }

    public final StoryTextStyleBuilder b(int i8) {
        this.f37745c = i8;
        return this;
    }

    public final StoryTextStyle c() {
        return new StoryTextStyle(this.f37743a, this.f37746d, this.f37744b, this.f37745c, this.f37747e);
    }

    public final StoryTextStyleBuilder d(Integer num) {
        if (num == null) {
            num = 0;
        }
        this.f37747e = num;
        return this;
    }

    public final StoryTextStyleBuilder e(int i8) {
        this.f37744b = i8;
        return this;
    }

    public final StoryTextStyleBuilder f(CharSequence text) {
        Intrinsics.f(text, "text");
        this.f37743a = text;
        return this;
    }
}
