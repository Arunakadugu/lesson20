package me.aruna.lesson20;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<UserRole, Long>{
    UserRole findByRole(String role);
}
