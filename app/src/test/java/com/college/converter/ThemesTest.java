package com.college.converter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ThemesTest {

    @Test
    public void verifyNoActionBarThemeAndColorChanges() {
        Context context = ApplicationProvider.getApplicationContext();

        // Create a ContextThemeWrapper with the modified theme
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, R.style.Base_Theme_AppTheme_NoActionBar);

        // Get resources from the context theme wrapper
        Resources.Theme theme = contextThemeWrapper.getTheme();
        TypedValue typedValue = new TypedValue();

        // Verify NoActionBar theme
        TypedValue actionBarValue = new TypedValue();
        boolean hasActionBar = theme.resolveAttribute(android.R.attr.windowActionBar, actionBarValue, true);
        assertFalse("Theme should have no action bar", hasActionBar);

        // Verify modified primary colors
        theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int colorPrimary = typedValue.data;
        assertEquals("ColorPrimary is incorrect", getColor(R.color.your_primary_color), colorPrimary);

        theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        int colorPrimaryDark = typedValue.data;
        assertEquals("ColorPrimaryDark is incorrect", getColor(R.color.your_primary_dark_color), colorPrimaryDark);

        theme.resolveAttribute(R.attr.colorAccent, typedValue, true);
        int colorAccent = typedValue.data;
        assertEquals("ColorAccent is incorrect", getColor(R.color.your_accent_color), colorAccent);
    }

    // Utility method to get color from resources
    private int getColor(int resId) {
        return ApplicationProvider.getApplicationContext().getResources().getColor(resId, null);
    }
}

