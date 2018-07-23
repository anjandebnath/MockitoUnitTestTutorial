package com.anjan.mockitounittesttutorial.async;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anjan Debnath on 7/23/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class DummyCaller implements DummyCallback{

    DummyCollaborator dummyCollaborator;

    private List<String> result = new ArrayList<String>();

    public DummyCaller(DummyCollaborator dummyCollaborator){
        this.dummyCollaborator = dummyCollaborator;
    }

    public void doSomethingAsynchronously(){
        dummyCollaborator.doSomethingAsynchronously(this);
    }

    public List<String> getResult(){
        return this.result;
    }

    @Override
    public void onSuccess(List<String> result) {
       this.result = result;
       System.out.println("On success");
    }

    @Override
    public void onFail(int code) {
        System.out.println("On Fail");
    }
}
