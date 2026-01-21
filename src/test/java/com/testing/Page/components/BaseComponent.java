package com.testing.Page.components;

import com.microsoft.playwright.Page;
import com.testing.Page.IPageComponent;

public abstract class BaseComponent implements IPageComponent {
protected Page page;

    public BaseComponent(Page page) {
        this.page = page;
    }
}
