package br.com.hourjob.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
  import javax.persistence.JoinColumn;
  import javax.persistence.OneToOne;
  import java.util.ArrayList;
  import java.util.List;
  import javax.persistence.FetchType;
  import javax.persistence.ManyToMany;

  import org.springframework.security.core.GrantedAuthority;
  import org.springframework.security.core.userdetails.UserDetails;

  import lombok.Data;

@Entity
public class LoginEmpregador implements UserDetails {

  /**
   *
   */
  private static final long serialVersionUID = -5609483637134073314L;

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne @JoinColumn(unique = true)
  private Empregador empregador;
  private String senha;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Perfil> perfis = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return perfis;

  }
  @Override
  public String getPassword() {
    return this.senha;
  }
  @Override
  public String getUsername() {
    return this.empregador.getEmail();
  }
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  }
  public long getId() {
    return this.id;
  }

}
