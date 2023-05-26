package eu.bolt.driver.chat.ui.screen.conversation.pager.item;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.util.DateTimeFormatter;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class MessageMapper_Factory implements Factory<MessageMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DateTimeFormatter> f40704a;

    public MessageMapper_Factory(Provider<DateTimeFormatter> provider) {
        this.f40704a = provider;
    }

    public static MessageMapper_Factory a(Provider<DateTimeFormatter> provider) {
        return new MessageMapper_Factory(provider);
    }

    public static MessageMapper c(DateTimeFormatter dateTimeFormatter) {
        return new MessageMapper(dateTimeFormatter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MessageMapper get() {
        return c(this.f40704a.get());
    }
}
