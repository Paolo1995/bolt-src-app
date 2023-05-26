package ee.mtakso.driver.service.voip.extractor;

/* compiled from: VoipInfoExtractorFactoryImpl.kt */
/* loaded from: classes3.dex */
public final class VoipInfoExtractorFactoryImpl implements VoipInfoExtractorFactory {
    @Override // ee.mtakso.driver.service.voip.extractor.VoipInfoExtractorFactory
    public VoipInfoExtractor a() {
        return new ApiInfoExtractor();
    }
}
