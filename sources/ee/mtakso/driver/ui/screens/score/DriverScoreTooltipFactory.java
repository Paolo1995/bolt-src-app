package ee.mtakso.driver.ui.screens.score;

import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.common.mapping.InformationMessageMapper;
import ee.mtakso.driver.uikit.onbordingtooltips.TooltipOnbordingDelegate;
import ee.mtakso.driver.uikit.utils.Text;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreTooltipFactory.kt */
/* loaded from: classes3.dex */
public final class DriverScoreTooltipFactory {

    /* renamed from: a  reason: collision with root package name */
    private final InformationMessageMapper f32948a;

    @Inject
    public DriverScoreTooltipFactory(InformationMessageMapper informationMessageMapper) {
        Intrinsics.f(informationMessageMapper, "informationMessageMapper");
        this.f32948a = informationMessageMapper;
    }

    public final List<TooltipOnbordingDelegate.TooltipElement> a() {
        List<TooltipOnbordingDelegate.TooltipElement> n8;
        Text.Resource resource = new Text.Resource(R.string.driver_score_your, null, 2, null);
        Text.Resource resource2 = new Text.Resource(R.string.driver_score_your_tooltip, null, 2, null);
        TooltipOnbordingDelegate.TooltipAnchor.ListItem listItem = new TooltipOnbordingDelegate.TooltipAnchor.ListItem("SCORE_DETAILS", null, 2, null);
        TooltipOnbordingDelegate.TooltipAllignment tooltipAllignment = TooltipOnbordingDelegate.TooltipAllignment.START;
        n8 = CollectionsKt__CollectionsKt.n(new TooltipOnbordingDelegate.TooltipElement(resource, resource2, tooltipAllignment, listItem), new TooltipOnbordingDelegate.TooltipElement(new Text.Resource(R.string.driver_score_negative_signals, null, 2, null), new Text.Resource(R.string.driver_score_negative_signals_tooltip, null, 2, null), tooltipAllignment, new TooltipOnbordingDelegate.TooltipAnchor.ListItem("SCORE_REDUCING_ISSUES", null, 2, null)), new TooltipOnbordingDelegate.TooltipElement(new Text.Resource(R.string.driver_score_more_info, null, 2, null), new Text.Resource(R.string.driver_score_more_info_tooltip, null, 2, null), tooltipAllignment, new TooltipOnbordingDelegate.TooltipAnchor.ListItem("SCORE_FIND_OUT_MORE", Integer.valueOf((int) R.id.f271findOutMore))));
        return n8;
    }
}
