package com.myapp.toggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyFeatures implements Feature {

    @EnabledByDefault
    @Label("Generate Number in word format")
    FEATURE_GEN_NUMBERS,
    
    @EnabledByDefault
    @Label("Generate sorted numbers")
    FEATURE_SORT_NUMBERS;
    
    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
    
}