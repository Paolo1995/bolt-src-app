package eu.bolt.android.stories.widget.slide;

import eu.bolt.android.stories.widget.helper.StoryButton;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoryButtonStyle.kt */
/* loaded from: classes5.dex */
public abstract class StoryButtonStyle implements Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f37669g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final StoryButton.ButtonStyle f37670f;

    /* compiled from: StoryButtonStyle.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoryButtonStyle.kt */
    /* loaded from: classes5.dex */
    public static final class Danger extends StoryButtonStyle {

        /* renamed from: h  reason: collision with root package name */
        public static final Danger f37671h = new Danger();

        private Danger() {
            super(StoryButton.ButtonStyle.Danger, null);
        }
    }

    /* compiled from: StoryButtonStyle.kt */
    /* loaded from: classes5.dex */
    public static final class Primary extends StoryButtonStyle {

        /* renamed from: h  reason: collision with root package name */
        public static final Primary f37672h = new Primary();

        private Primary() {
            super(StoryButton.ButtonStyle.Primary, null);
        }
    }

    /* compiled from: StoryButtonStyle.kt */
    /* loaded from: classes5.dex */
    public static final class Secondary extends StoryButtonStyle {

        /* renamed from: h  reason: collision with root package name */
        public static final Secondary f37673h = new Secondary();

        private Secondary() {
            super(StoryButton.ButtonStyle.Secondary, null);
        }
    }

    /* compiled from: StoryButtonStyle.kt */
    /* loaded from: classes5.dex */
    public static final class TextButton extends StoryButtonStyle {

        /* renamed from: h  reason: collision with root package name */
        public static final TextButton f37674h = new TextButton();

        private TextButton() {
            super(StoryButton.ButtonStyle.Text, null);
        }
    }

    private StoryButtonStyle(StoryButton.ButtonStyle buttonStyle) {
        this.f37670f = buttonStyle;
    }

    public /* synthetic */ StoryButtonStyle(StoryButton.ButtonStyle buttonStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(buttonStyle);
    }

    public final StoryButton.ButtonStyle a() {
        return this.f37670f;
    }
}
