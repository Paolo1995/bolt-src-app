package eu.bolt.driver.chat.ui.screen.conversation;

import android.os.Bundle;
import android.view.View;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.R$id;
import eu.bolt.driver.chat.R$layout;
import eu.bolt.driver.chat.ui.screen.conversation.pager.ConversationPagerFragment;
import eu.bolt.driver.core.di.helper.CoreFragmentFactory;
import eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.ui.routing.command.impl.ActivityClassCommand;
import eu.bolt.driver.core.ui.theme.AppThemeUiUtils;
import eu.bolt.driver.core.ui.theme.ThemeProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationActivity.kt */
/* loaded from: classes5.dex */
public final class ConversationActivity extends BaseAuthorisedActivity {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f40587p = new Companion(null);
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public ThemeProvider f40588n;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, View> f40589o = new LinkedHashMap();

    /* compiled from: ConversationActivity.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoutingCommand a() {
            return new ActivityClassCommand(ConversationActivity.class, null, 805371904, null, 10, null);
        }
    }

    @Override // eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity
    public void P(Bundle bundle) {
        setContentView(R$layout.activity_conversation);
        AppThemeUiUtils.f41180a.a(this, R().a());
        if (bundle == null && getSupportFragmentManager().findFragmentByTag("chat") == null) {
            getSupportFragmentManager().beginTransaction().add(R$id.conversationHolder, (ConversationPagerFragment) CoreFragmentFactory.b(L(), this, ConversationPagerFragment.class, null, 4, null), "chat").commit();
        }
    }

    @Override // eu.bolt.driver.core.ui.base.activity.BaseAuthorisedActivity
    public void Q(Bundle bundle) {
        DriverChatSdk.f40388a.b().e(this);
    }

    public final ThemeProvider R() {
        ThemeProvider themeProvider = this.f40588n;
        if (themeProvider != null) {
            return themeProvider;
        }
        Intrinsics.w("themeProvider");
        return null;
    }
}
