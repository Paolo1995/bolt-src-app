package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface AccessibilityViewCommand {

    /* loaded from: classes.dex */
    public static abstract class CommandArguments {

        /* renamed from: a  reason: collision with root package name */
        Bundle f6071a;

        public void a(Bundle bundle) {
            this.f6071a = bundle;
        }
    }

    /* loaded from: classes.dex */
    public static final class MoveAtGranularityArguments extends CommandArguments {
    }

    /* loaded from: classes.dex */
    public static final class MoveHtmlArguments extends CommandArguments {
    }

    /* loaded from: classes.dex */
    public static final class MoveWindowArguments extends CommandArguments {
    }

    /* loaded from: classes.dex */
    public static final class ScrollToPositionArguments extends CommandArguments {
    }

    /* loaded from: classes.dex */
    public static final class SetProgressArguments extends CommandArguments {
    }

    /* loaded from: classes.dex */
    public static final class SetSelectionArguments extends CommandArguments {
    }

    /* loaded from: classes.dex */
    public static final class SetTextArguments extends CommandArguments {
    }

    boolean a(@NonNull View view, CommandArguments commandArguments);
}
