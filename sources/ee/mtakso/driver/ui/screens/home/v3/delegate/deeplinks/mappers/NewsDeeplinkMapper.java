package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.inbox.InboxFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: NewsDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class NewsDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.News> {
    @Inject
    public NewsDeeplinkMapper() {
        super(InboxFragment.class, true, null, null, 12, null);
    }
}
