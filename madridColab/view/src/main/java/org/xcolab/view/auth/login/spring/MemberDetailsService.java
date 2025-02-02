package org.xcolab.view.auth.login.spring;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.xcolab.client.members.MembersClient;
import org.xcolab.client.members.exceptions.MemberNotFoundException;

public class MemberDetailsService implements UserDetailsService {

    @Override
    public MemberDetails loadUserByUsername(String screenNameOrEmail) throws UsernameNotFoundException {
        if (screenNameOrEmail.contains("@")) {
            return loadByEmail(screenNameOrEmail);
        } else {
            try {
                return new MemberDetails(MembersClient.findMemberByScreenName(screenNameOrEmail));
            } catch (MemberNotFoundException e) {
                throw new UsernameNotFoundException("User " + screenNameOrEmail + " not found");
            }
        }
    }

    public MemberDetails loadByEmail(String emailAddress) throws UsernameNotFoundException {
        try {
            return new MemberDetails(MembersClient.findMemberByEmailAddress(emailAddress));
        } catch (MemberNotFoundException e) {
            throw new UsernameNotFoundException("User with email " + emailAddress + " not found");
        }
    }

    public MemberDetails loadUserByFacebookId(Long facebookId) throws UsernameNotFoundException {
        try {
            return new MemberDetails(MembersClient.findMemberByFacebookId(facebookId));
        } catch (MemberNotFoundException e) {
            throw new UsernameNotFoundException("User Facebook#" + facebookId + " not found");
        }
    }

    public MemberDetails loadUserByGoogleId(String googleId) throws UsernameNotFoundException {
        try {
            return new MemberDetails(MembersClient.findMemberByGoogleId(googleId));
        } catch (MemberNotFoundException e) {
            throw new UsernameNotFoundException("User Google#" + googleId + " not found");
        }
    }

    public MemberDetails loadUserByColabSsoId(String colabSsoId) throws UsernameNotFoundException {
        try {
            return new MemberDetails(MembersClient.findMemberByColabSsoId(colabSsoId));
        } catch (MemberNotFoundException e) {
            throw new UsernameNotFoundException("User ColabSso#" + colabSsoId + " not found");
        }
    }

    public MemberDetails loadUserByClimateXId(String climateXId) throws UsernameNotFoundException {
        try {
            return new MemberDetails(MembersClient.findMemberByClimateXId(climateXId));
        } catch (MemberNotFoundException e) {
            throw new UsernameNotFoundException("User ClimateX#" + climateXId + " not found");
        }
    }
}
