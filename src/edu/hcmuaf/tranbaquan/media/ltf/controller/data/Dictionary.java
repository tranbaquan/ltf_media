package edu.hcmuaf.tranbaquan.media.ltf.controller.data;

public enum Dictionary {
    OPEN("OPEN"),
    CLOSE("CLOSE"),
    MUTE("MUTE"),
    VOLUME_UP("VOLUME_UP"),
    VOLUME_DOWN("VOLUME_DOWN"),
    PAUSE("PAUSE"),
    RESUME("RESUME"),
    NEXT("NEXT"),
    PREVIOUS("PREVIOUS"),
    SETTING("SETTING"),
    UNKNOWN("UNKNOWN");

    private final String command;

    Dictionary(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
