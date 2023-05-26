package ee.mtakso.driver.service.chat;

import android.content.Context;
import android.content.res.Resources;
import ee.mtakso.driver.R;
import eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider;
import eu.bolt.driver.core.ui.translation.TranslatedResources;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatTerminationMessageProvider.kt */
@Singleton
/* loaded from: classes3.dex */
public final class ChatTerminationMessageProvider implements ChatExternalTerminationMessageProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24046a;

    /* renamed from: b  reason: collision with root package name */
    private final TranslatedResources f24047b;

    @Inject
    public ChatTerminationMessageProvider(Context context) {
        Intrinsics.f(context, "context");
        this.f24046a = context;
        Resources resources = context.getResources();
        Intrinsics.e(resources, "context.resources");
        this.f24047b = new TranslatedResources(resources);
    }

    @Override // eu.bolt.chat.chatcore.network.external.ChatExternalTerminationMessageProvider
    public String a() {
        return this.f24047b.getString(R.string.chat_local_termination_message);
    }
}
