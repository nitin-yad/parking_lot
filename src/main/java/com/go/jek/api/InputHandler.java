package com.go.jek.api;

import com.go.jek.dtos.Input;

public abstract class InputHandler {

    public abstract Boolean isInputValid();
    public abstract void processInput(Input input);
}
