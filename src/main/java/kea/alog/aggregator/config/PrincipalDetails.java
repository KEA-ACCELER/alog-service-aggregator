package kea.alog.aggregator.config;

// import java.util.*;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import jakarta.annotation.PostConstruct;
// import kea.alog.aggregator.service.openfeign.UserFeign;
// import lombok.Data;

// @Data
// public class PrincipalDetails implements UserDetails {
    
//     @Autowired
//     private UserFeign userFeign;

//     // TODO : userFeign을 이용하여 user 정보를 가져오는 것을 구현해야함
//     private User user;

//     @PostConstruct
//     public void postInit(){
//         this.user = userFeign.GetUserInfo(getPassword())
//     }


//     public PrincipalDetails(User user) {
//         this.user = user;
//     }
    
//     //해당 유저의 권한을 리턴
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         Collection<GrantedAuthority> authorities = new ArrayList<>();
//         authorities.add(new SimpleGrantedAuthority(this.user.getUserRole()));
//         return authorities;
//     }

//     @Override
//     public String getPassword() {
//         return user.getUserPw();
//     }

//     @Override
//     public String getUsername() {
//         return user.getUserId();
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
    
// }

