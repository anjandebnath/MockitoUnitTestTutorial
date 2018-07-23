package com.anjan.mockitounittesttutorial.async;

import java.util.List;

/**
 * Created by Anjan Debnath on 7/23/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface DummyCallback {
    public void onSuccess(List<String> result);
    public void onFail(int code);
}
