package com.seveneleven.mycontactapp.profile;

public class ProfileManager {
    public void executeCommand(Command command) throws Exception {
        command.execute();
    }
}