package com.seveneleven.mycontactapp.profile;

import com.seveneleven.mycontactapp.user.User;

public class UpdatePreferenceCommand implements Command {
    private User user;
    private String preference;
    public UpdatePreferenceCommand(User user, String preference) {
        this.user = user;
        this.preference = preference;
    }
    public void execute() {
        user.setPreference(preference);
        System.out.println("Preference updated.");
    }
}