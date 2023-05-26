package eu.bolt.driver.core.ui.routing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import eu.bolt.driver.core.ui.common.activity.SimpleActivity;
import eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoutingCommand.kt */
/* loaded from: classes5.dex */
public interface RoutingCommand extends BackpressureRoutingCommand {

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static class ActivityIntent implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        private final RoutingState f41143a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f41144b;

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return this.f41143a;
        }

        public final Intent c() {
            return this.f41144b;
        }
    }

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static class ActivityPendingIntent implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        private final RoutingState f41145a;

        /* renamed from: b  reason: collision with root package name */
        private final PendingIntent f41146b;

        public ActivityPendingIntent(RoutingState newState, PendingIntent intent) {
            Intrinsics.f(newState, "newState");
            Intrinsics.f(intent, "intent");
            this.f41145a = newState;
            this.f41146b = intent;
        }

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return this.f41145a;
        }

        public final PendingIntent c() {
            return this.f41146b;
        }
    }

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static RoutingState a(RoutingCommand routingCommand) {
            RoutingState b8 = routingCommand.b();
            if (b8 != null) {
                return b8;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static class FragmentClass implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        private final RoutingState f41151a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<? extends Fragment> f41152b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f41153c;

        public FragmentClass(RoutingState newState, Class<? extends Fragment> clazz, Bundle args) {
            Intrinsics.f(newState, "newState");
            Intrinsics.f(clazz, "clazz");
            Intrinsics.f(args, "args");
            this.f41151a = newState;
            this.f41152b = clazz;
            this.f41153c = args;
        }

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return this.f41151a;
        }

        public final Bundle c() {
            return this.f41153c;
        }

        public final Class<? extends Fragment> d() {
            return this.f41152b;
        }
    }

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static final class RestartAppCommand implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        public static final RestartAppCommand f41154a = new RestartAppCommand();

        /* renamed from: b  reason: collision with root package name */
        private static final RoutingState f41155b = new RoutingState(SimpleActivity.class, null, 2, null);

        private RestartAppCommand() {
        }

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return f41155b;
        }
    }

    RoutingState b();

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static class ActivityClass implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        private final RoutingState f41135a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<? extends Activity> f41136b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f41137c;

        /* renamed from: d  reason: collision with root package name */
        private final int f41138d;

        public ActivityClass(RoutingState newState, Class<? extends Activity> clazz, Bundle args, int i8) {
            Intrinsics.f(newState, "newState");
            Intrinsics.f(clazz, "clazz");
            Intrinsics.f(args, "args");
            this.f41135a = newState;
            this.f41136b = clazz;
            this.f41137c = args;
            this.f41138d = i8;
        }

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return this.f41135a;
        }

        public final Bundle c() {
            return this.f41137c;
        }

        public final Class<? extends Activity> d() {
            return this.f41136b;
        }

        public final int e() {
            return this.f41138d;
        }

        public String toString() {
            RoutingState b8 = b();
            Class<? extends Activity> cls = this.f41136b;
            Bundle bundle = this.f41137c;
            return "ActivityClass(newState=" + b8 + ", clazz=" + cls + ", args=" + bundle + ")";
        }

        public /* synthetic */ ActivityClass(RoutingState routingState, Class cls, Bundle bundle, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(routingState, cls, (i9 & 4) != 0 ? new Bundle() : bundle, (i9 & 8) != 0 ? 0 : i8);
        }
    }

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static final class ActivityClassBackground implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        private final RoutingState f41139a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<? extends Activity> f41140b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f41141c;

        /* renamed from: d  reason: collision with root package name */
        private final int f41142d;

        public ActivityClassBackground(RoutingState newState, Class<? extends Activity> clazz, Bundle args, int i8) {
            Intrinsics.f(newState, "newState");
            Intrinsics.f(clazz, "clazz");
            Intrinsics.f(args, "args");
            this.f41139a = newState;
            this.f41140b = clazz;
            this.f41141c = args;
            this.f41142d = i8;
        }

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return this.f41139a;
        }

        public final Bundle c() {
            return this.f41141c;
        }

        public final Class<? extends Activity> d() {
            return this.f41140b;
        }

        public final int e() {
            return this.f41142d;
        }

        public String toString() {
            RoutingState b8 = b();
            Class<? extends Activity> cls = this.f41140b;
            Bundle bundle = this.f41141c;
            return "ActivityClassBackground(newState=" + b8 + ", clazz=" + cls + ", args=" + bundle + ")";
        }

        public /* synthetic */ ActivityClassBackground(RoutingState routingState, Class cls, Bundle bundle, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this(routingState, cls, (i9 & 4) != 0 ? new Bundle() : bundle, (i9 & 8) != 0 ? 0 : i8);
        }
    }

    /* compiled from: RoutingCommand.kt */
    /* loaded from: classes5.dex */
    public static class DialogFragmentClass implements RoutingCommand {

        /* renamed from: a  reason: collision with root package name */
        private final RoutingState f41147a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<? extends DialogFragment> f41148b;

        /* renamed from: c  reason: collision with root package name */
        private final Bundle f41149c;

        /* renamed from: d  reason: collision with root package name */
        private final String f41150d;

        public DialogFragmentClass(RoutingState newState, Class<? extends DialogFragment> clazz, Bundle args, String tag) {
            Intrinsics.f(newState, "newState");
            Intrinsics.f(clazz, "clazz");
            Intrinsics.f(args, "args");
            Intrinsics.f(tag, "tag");
            this.f41147a = newState;
            this.f41148b = clazz;
            this.f41149c = args;
            this.f41150d = tag;
        }

        @Override // eu.bolt.driver.core.ui.routing.command.BackpressureRoutingCommand
        public RoutingState a() {
            return DefaultImpls.a(this);
        }

        @Override // eu.bolt.driver.core.ui.routing.RoutingCommand
        public RoutingState b() {
            return this.f41147a;
        }

        public final Bundle c() {
            return this.f41149c;
        }

        public final Class<? extends DialogFragment> d() {
            return this.f41148b;
        }

        public final String e() {
            return this.f41150d;
        }

        public /* synthetic */ DialogFragmentClass(RoutingState routingState, Class cls, Bundle bundle, String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(routingState, cls, (i8 & 4) != 0 ? new Bundle() : bundle, (i8 & 8) != 0 ? "coordinator_content_fragment" : str);
        }
    }
}
