//package com.example.hackathon_team12.security.jwt;
//
//import com.example.hackathon_team12.domain.Member;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@NoArgsConstructor
//public class UserDetailsImpl implements UserDetails {
//    private Member member;
//
//    public UserDetailsImpl(Member member) {
//        this.member = member;
//    }
//
//    public Member getAccount() {
//        return this.member;
//    }
//
//    public void setAccount(Member member) {
//        this.member = member;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//}
